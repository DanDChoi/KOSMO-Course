트리거 가온나

주문을 받았을떄 if then 걸어서 그래서 배달이라는 insert 로 주문을 받았으니까 배달이면 배달에 인서트 되고 
방문이면 방문에 인서트가 된다 그리고 따다다

그리고 old new 는 재영님이캐리

납품 카운트로 받으면 거기서 거기서 업데이트가 되는데 업데이트가 되면 재고쪽이 올라가게 되고 그게 올라가면
주문을 받게되면 카운트가 빠져야함 거기까지 그리고나서 카운트받고 빠지면 되겠죠 
카운트 까지니까 툭 툭 2번

   1번 납품업체에서 카운트 받아서 재고관리로 쌓는거 1번
   테이블 업뎃 됐을때 트리거 발생  납품업체에서 인서트 받으면 발생 

   2번 --DONE by JYGOD
   주문이 들어왔을때 트리거 발생
   재고에서 주문을 받았을때,
   재고 카운트를 빼야하고 
   빼는거는 지점별로 세일에 카운트를 올려주고 
   올려줄때 금액별로 올려줌 

   ex 술이면 카운트 빠지면 3 올라가고 금액 곱하기 3 해서 올라감

   3번 주문에서 실행이되면 주문에서 나온 결ㅈ금액들이 매출금액으로 
   주문이 일어났을때 세일테이블로 이동 금액 계산하는 트리거를 걸어줘야함 >>3~4번 줄

   4번 주문마다 리뷰가 다르니까 그 리뷰가 가맹점으로 올라가서 평균값을 내줘야함 > 
   
   5

트리거는 주문이 들어왔을때 발생 


create or replace trigger avgstar
after insert on ORDERS
for each row 
begin
if inserting then
   update FRANCHISE set :new.star = ((:old.star+:new.star)/2) where ORDERS;
end if;
end;
/

 
insert into ORDERS values (orderNumber_SEQ.nextval, 'GODJY', 3842, 43000, 'chicken', 4, 3, '배달', SYSDATE, '현금', 1, 0, 2);
 

creat or replace trigger getorder
after insert on ORDERS
for each row
begin
if inserting then
    update INVENTORYCONTROL
    set :new.drinkcount = :old.drinkcount - drinkcount where ORDERS;
end if;
end;
/


--------------------------------------방문&매출 구분 트리거 --------------------------------------------------------
create or replace trigger sorting
after insert on ORDERS 
for each row
begin
if :new.ordersSort = '방문' 
then
    insert into VISIT -- 방문고객 정보 입력 절차
    (orderNumber, customerNumber, drinkCount, alcholeCount, chickenCount, customercost, FranchiseNumber, payment) 
    values 
    (:new.orderNumber, :new.customerNumber, :new.drinkCount, :new.alcholeCount, 
    :new.chickenCount, :new.customercost, :new.FranchiseNumber, :new.payment);

    insert into SALES (FranchiseNumber, orderNumber, ordersale, f_totsal) --매출정보 저장
    values (:new.FranchiseNumber, :new.orderNumber, :new.customercost, :new.customercost);
    update SALES set f_totsal = (select sum(f_totsal) from SALES where franchisenumber=:new.franchisenumber) where franchisenumber =:new.franchisenumber;
elsif :new.ordersSort = '배달'
then
    insert into ORDERSBACKUP (orderNumber, ID)  --ID,고객번호,주소,고객전화번호를 가져오기위해 backup 테이블에 넣고 가져옴 (cause ORDERS에서 직접 가져오면 오류발생)
    values (:new.orderNumber, :new.ID);

    insert into DELIVERY -- 배달고객 정보 입력 절차
    (orderNumber, ID, FranchiseNumber, customerName, drinkCount, alcholeCount, chickenCount, customercost, Loc, customerPhonenumber, payment)
    values 
    (:new.orderNumber, 
    (select ID from DELICUSTOMER where ID =(select ID from ORDERSBACKUP where orderNumber=(select max(orderNumber) from ORDERSBACKUP))), 
    :new.FranchiseNumber, 
    (select customerNumber from DELICUSTOMER where ID =(select ID from ORDERSBACKUP where orderNumber=(select max(orderNumber) from ORDERSBACKUP))), 
    :new.drinkCount, 
    :new.alcholeCount, 
    :new.chickenCount, 
    :new.customercost, 
    (select Loc from DELICUSTOMER where ID =(select ID from ORDERSBACKUP where orderNumber=(select max(orderNumber) from ORDERSBACKUP))), 
    (select customerPhonenumber from DELICUSTOMER where ID =(select ID from ORDERSBACKUP where orderNumber=(select max(orderNumber) from ORDERSBACKUP))), 
    :new.payment);

    insert into SALES (FranchiseNumber, orderNumber, ordersale, f_totsal) --매출정보 저장
    values (:new.FranchiseNumber, :new.orderNumber, :new.customercost, :new.customercost);
    update SALES set f_totsal = (select sum(f_totsal) from SALES where franchisenumber=:new.franchisenumber) where franchisenumber =:new.franchisenumber;
end if;
end;
/
------------------------------------------------------------------------------------------------------------------------------------
create or replace trigger supply_trigger  -- 남품받으면 인벤토리의 카운트가 증가되는 트리거 
after insert on SUPPLY for each row
begin
    insert into INVENTORYCONTROL values
    ( :new.daynumber , SYSDATE , SYSDATE ,:new.drinkCount , :new.alcholeCount , :new.chickenCount );
end;
/



create or replace procedure INCRE2(n in EMP2.EMPNO%TYPE , r in NUMBER)
is
   newPay number;  
begin
   select SAL into newPay from EMP2 where EMPNO=n;
   newPay := newPay + newPay*r/100;
   update EMP2 set SAL=newPay where EMPNO=n;
   commit;
end;
/


create or replace trigger buy_inven_trigger
after insert on ORDERS for each row -- 주문이 들어왔잖아요.
begin
   buy_inven_procedure(:new.drinkCount , :new.alcholeCount , :new.chickenCount); -- inven , count를 - 해주는 프로시져
   insert into DELIVERY VALUES
end;
/

create or replace trigger buy_inven_trigger2
after insert on DELIVERY for each row -- 주문이 들어왔잖아요.
begin
   total_procedure(:new.drinkCount , :new.alcholeCount , :new.chickenCount); 
   insert into DELIVERY VALUES
end;
/


 -- buy_inven_procedure3(:new.chiCount);
 -- buy_inven_procedure2(:new.alcholeCount);
create or replace procedure buy_inven_procedure(r in NUMBER , r1 in NUMBER , r2 in NUMBER)
is
   newdrinkCount number;
   newalcholeCount number;
   newchiCount number;
begin
   select drinkCount into newdrinkCount from INVENTORYCONTROL;
   newdrinkCount := newdrinkCount-r;
   update INVENTORYCONTROL set drinkCount=newdrinkCount;
   select alcholeCount into newalcholeCount from INVENTORYCONTROL;
   newalcholeCount := newalcholeCount-r1;
   update INVENTORYCONTROL set alcholeCount=newalcholeCount;
   select chickenCount into newchiCount from INVENTORYCONTROL;
   newchiCount := newchiCount-r2;
   update INVENTORYCONTROL set chickenCount=newchiCount;
end;
/


create or replace trigger orders_Deli
after insert ORDERS


create or replace procedure total_procedure(r in NUMBER , r1 in NUMBER , r2 in NUMBER)
is
   newdrinkSUM number;
   newalcholeSUM number;
   newchiSUM number;
begin
   select drinkCount into newdrinkSUM from ORDERS;
   newdrinkSUM := r * 3000;
   update SALES set f_totsal = f_totsal + newdrinkSUM where FranchiseNumber = 
   (select o.FranchiseNumber from ORDERS o , SALES s where o.orderNumber=s.orderNumber );
   
   select alcholeCount into newalcholeSUM from ORDERS;
   newalcholeSUM := r1 * 4000;
   update SALES set f_totsal = f_totsal + newalcholeSUM where FranchiseNumber = 
   (select o.FranchiseNumber from ORDERS o , SALES s where o.orderNumber=s.orderNumber );
   
   select chickenCount into newchiSUM from ORDERS;
   newchiSUM := r2 * 20000;
   update SALES set f_totsal = f_totsal + newchiSUM where FranchiseNumber = 
   (select o.FranchiseNumber from ORDERS o , SALES s where o.orderNumber=s.orderNumber );
end;
/


create or replace procedure buy_inven_procedure2(r in NUMBER)
is
   newalcholeCount number;
begin
    select alcholeCount into newalcholeCount from INVENTORYCONTROL;
   newalcholeCount := newalcholeCount-r;
   update INVENTORYCONTROL set alcholeCount=newalcholeCount;
   
end;
/

create or replace procedure buy_inven_procedure3(r in NUMBER)
is
   newchiCount number;
begin
    select chiCount into newchiCount from INVENTORYCONTROL;
   newchiCount := newchiCount-r;
   update INVENTORYCONTROL set chiCount=newchiCount;
   
end;
/



— 프로시져 , 트리거 검증
 insert into supply values (supplyNumber_SEQ.nextval , 100 , 200, 300, 1);
 insert into orders values (1, 1 , 52000 , 'chicken' , 5 , 1 , '배달', SYSDATE , '현금' , 10 , 8 , 3  );
 */