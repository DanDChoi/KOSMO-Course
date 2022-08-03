--납품표
create or replace trigger inven_trigger  
after insert on INVENTORYCONTROL for each row    
begin
    update FRANCHISE set drinkCount = (drinkCount + :new.drinkCount)  , alcoholCount = (alcoholCount + :new.alcoholCount) , chickenCount = ( chickenCount + :new.chickenCount ) where FranchiseNumber = :new.FranchiseNumber ;
end;
/

-- 납품받음.
create or replace trigger supply_trigger  
after insert on SUPPLY for each row
begin
    insert into INVENTORYCONTROL values( :new.supplyNumber , :new.FranchiseNumber , SYSDATE , SYSDATE ,:new.drinkCount , :new.alcoholCount , :new.chickenCount );
end;
/

------------------------------------------------------------------
-- 프렌차이즈별로 수량체크하고 0 개가 되면 주문거부하는 프로시져
create or replace procedure buy_inven_procedure(r in NUMBER , r1 in NUMBER , r2 in NUMBER , r3 in NUMBER)
is
   newdrinkCount number;
   newalcoholCount number;
   newchiCount number;
   ifdrinCount number;
begin
   select drinkCount into newdrinkCount from FRANCHISE where FranchiseNumber = r3;
   newdrinkCount := newdrinkCount-r; 
   if newdrinkCount>=0 
   then
   update FRANCHISE set drinkCount=newdrinkCount where FranchiseNumber = r3; 
   elsif newdrinkCount<=0
   then
   RAISE_APPLICATION_ERROR(-20002,'드링크의 재고가 없습니다');
   end if;
   
   select alcoholCount into newalcoholCount from FRANCHISE where FranchiseNumber = r3;
   newalcoholCount := newalcoholCount-r1;
   if newalcoholCount>=0 
   then
   update FRANCHISE set alcoholCount=newalcoholCount where FranchiseNumber = r3;
   elsif newalcoholCount<=0
   then
   RAISE_APPLICATION_ERROR(-20003,'술의 재고가 없습니다');
   end if;
   
   if newchiCount>=0 
   then
   select chickenCount into newchiCount from FRANCHISE where FranchiseNumber = r3;
   newchiCount := newchiCount-r2;
   update FRANCHISE set chickenCount=newchiCount where FranchiseNumber = r3;
   elsif newchiCount<=0
   then
   RAISE_APPLICATION_ERROR(-20004,'닭의 재고가 없습니다');
   end if;
end;
/

-- 오더들어오면 프렌차이즈 수량변화함 
create or replace trigger buy_inven_trigger
after insert on ORDERS for each row 
begin
   buy_inven_procedure(:new.drinkCount , :new.alcoholCount , :new.chickenCount , :new.FranchiseNumber);
end;
/

-- 프랜차이즈별 평점합계 평균내기
create or replace trigger avgstar
after insert on ORDERS
for each row 
begin
if inserting then
   update FRANCHISE set star = ((:old.star+:new.star)/2) where FRANCHISENUMBER = :new.FRANCHISENUMBER; 
end if;
end;
/

-- 아이디(배달), 방문 나누기 + 주문표금액 cost
create or replace trigger sorting
after insert on ORDERS 
for each row
begin

if( :new.ID = '방문') 
then
    insert into VISIT (orderNumber,  drinkCount, alcoholCount, chickenCount, customercost, FranchiseNumber, payment , orderDATE) 
    values (:new.orderNumber, :new.drinkCount, :new.alcoholCount, :new.chickenCount, ((:new.drinkCount*(select price from menu where menuName = 'drink'))+(:new.alcoholCount*(select price from menu where menuName = 'alcohol'))+(:new.chickenCount*(select price from menu where menuName = 'chicken'))), :new.FranchiseNumber, :new.payment , :new.orderDATE);
else
    insert into DELIVERY values ( :new.orderNumber , :new.ID , :new.FranchiseNumber,:new.drinkCount, 
    :new.alcoholCount, :new.chickenCount, ((:new.drinkCount*(select price from menu where menuName = 'drink'))+(:new.alcoholCount*(select price from menu where menuName = 'alcohol'))+(:new.chickenCount*(select price from menu where menuName = 'chicken'))) ,
    (select Loc from DELICUSTOMER where ID = :new.ID) , (select customerPhonenumber from DELICUSTOMER where ID = :new.ID), :new.payment , :new.orderDATE);
end if;
end;
/

-- 프렌차이즈별 쌓는 프로시져
create or replace procedure SALESCAL (r in number , r1 in number)
is
   v_total number;
begin
    select totalSAL into v_total from toSALES where r = FranchiseNumber;
    v_total := v_total + r1;
    update toSALES set totalSAL = v_total where r = FranchiseNumber;
end;
/

-- 프렌차이즈 별 매출액 
create or replace trigger total_SALES
after insert on SALES for each row
begin
    SALESCAL(:new.FranchiseNumber, :new.orderSALES);
end;
/

--딜리버리업데이트시 매출표로
create or replace trigger Deli_SALES 
after insert on  delivery  for each row 
begin 
     insert into SALES values (:new.orderNumber , :new.FranchiseNumber , :new.orderDATE , :new.customercost); 
end;
/

--방문고객업데이트시 매출표로
create or replace trigger visit_SALES
after insert on  visit  for each row 
begin  
     insert into SALES values (:new.orderNumber , :new.FranchiseNumber , :new.orderDATE , :new.customercost);
end;
/