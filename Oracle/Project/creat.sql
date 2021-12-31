drop table EMPLOYEE;
drop table FRANCHISE;
drop table MENU;
drop table INVENTORYCONTROL;
drop table CUSTOMER;
drop table ORDERSSET;
drop table VISIT;
drop table ORDERS;
drop table DELIVERY;
drop table DELICUSTOMER;
drop table SUPPLY;
drop table SALES;
drop table ORDERSBACKUP;
drop SEQUENCE supplyNumber_SEQ;
drop SEQUENCE dayNumber_SEQ;
drop SEQUENCE orderNumber_SEQ;
drop SEQUENCE VorderNumber_SEQ;
drop SEQUENCE BorderNumber_SEQ;
drop SEQUENCE DrderNumber_SEQ;
drop TRIGGER sorting;
purge recyclebin;


create table MENU(  -- 메뉴 메뉴네임을 -> 미리넣기 
   menuName nvarchar2(30) not null check(menuName in('drink' , 'chicken' , 'alcohole')), --메뉴이름
   price number(20) not null --가격  
);

alter table MENU add constraint menuName_PK primary key(menuName);
select CONSTRAINT_NAME , CONSTRAINT_TYPE from user_constraints;
--drop table Menu;
insert into MENU values('chicken', 20000 );
insert into MENU values('alcohole', 4000);
insert into MENU values('drink', 3000);
----------------------------------------------------------------------------------------------- insert 
create table SUPPLY( --납품 // 보급같은                                   
   supplyNumber number(10) not null,--납품번호
   daynumber number(10) not null,
   drinkCount number(5) default 0,  
   alcholeCount number(5) default 0,  
   chickenCount number(10) default 0
);
alter table SUPPLY add constraint Supply_PK primary key(supplyNumber);
select CONSTRAINT_NAME , CONSTRAINT_TYPE from user_constraints where table_name='SUPPLY';
create sequence supplyNumber_SEQ start with 1 increment by 1 nocache;
------------------------------------------------------------------------------------------------- trigger 완성  
create table INVENTORYCONTROL(  --재고관리
   daynumber number(10) not null, -- 입고번호
   warehousingDATE DATE default SYSDATE not null, --입고일
   useDATE DATE default SYSDATE not null, --사용일
   drinkCount number(5) default 0,  
   alcholeCount number(5) default 0,  
   chickenCount number(10) default 0,
   supplyNumber number(10) not null,
   FranchiseNumber number(5) not null
);
create sequence daynumber_SEQ start with 1 increment by 1 nocache;
alter table INVENTORYCONTROL add constraint daynumberr_PK primary key(daynumber);
alter table INVENTORYCONTROL add constraint supplyNumber_FK foreign key(supplyNumber) references SUPPLY(supplyNumber);
alter table INVENTORYCONTROL add constraint FranchiseNumber_FK foreign key(FranchiseNumber) references FRANCHISE(FranchiseNumber);
select CONSTRAINT_NAME , CONSTRAINT_TYPE from user_constraints where table_name='INVENTORYCONTROL'; 
--drop table INVENTORYCONTROL;
---------------------------------------------------------------------------------------------------------
create table FRANCHISE(  --가맹점  미리넣기 
   FranchiseNumber number(5) not null, --가맹점번호
   FranchiseName nvarchar2(30) not null, --지점명
   star number(5,2) , --별점 얘도 트리거필요한데. 프로시져도 필요한데
   employeeCount number(2) not null, --직원수
   FLoc nvarchar2(200) not null, --가맹점 주소
   businessOwner nvarchar2(20) default '점장', --사업주
   businesshours nvarchar2(40) default 'AM 11시00 ~ AM 1시00' --영업시간
);
insert into FRANCHISE values (1, '가산디지털단지점', 4.33, 2, '서울특별시 금천구 가산디지털단지로 3', '김치킨', 'PM12 ~ AM12');
insert into FRANCHISE values (2, '구로디지털단지점', 4.11, 3, '서울특별시 구로구 구로로 53', '박통닭', 'PM2 ~ PM10');
insert into FRANCHISE values (3, '가산점', 4.89, 2, '서울특별시 금천구 가산로 55', '최순살', 'AM11 ~ AM2');
insert into FRANCHISE values (4, '서울점', 3.23, 3, '서울특별시 서울구 서울로 66', '이후추', 'PM12 ~ AM12');
insert into FRANCHISE values (5, '천왕역점', 3.90, 2, '서울특별시 천왕구 천왕로 12', '강황금', 'PM3 ~ PM9');

desc FRANCHISE; 
alter table FRANCHISE add constraint Franchise_PK primary key(FranchiseNumber);
select CONSTRAINT_NAME , CONSTRAINT_TYPE from user_constraints where table_name='FRANCHISE';
--drop table FRANCHISE;

-----------------------------------------------------------------------------------------------------------
create table EMPLOYEE(  --직원 미리넣기 
   employeeNumber number(10) not null,--직원번호
   employeeName nvarchar2(20) not null, --직원이름
   salary number(20), --급여
   position nvarchar2(30) not null check(position in( '아르바이트', '사원', '매니저','점장', '사업주')), 
   FranchiseNumber number(5) not null
);
insert into EMPLOYEE values (511, '김치킨', 4900000, '사업주', 1);
insert into EMPLOYEE values (99, '박통닭', 5300000, '사업주' , 2);
insert into EMPLOYEE values (134, '최순살', 6100000, '사업주', 3);
insert into EMPLOYEE values (223, '이후추', 5500000, '사업주', 4);
insert into EMPLOYEE values (122, '강황금', 4800000, '점장' , 5);
insert into EMPLOYEE values (45, '이가나', 3200000, '매니저' , 1);
insert into EMPLOYEE values (52, '박나나', 3000000, '매니저' , 2);
insert into EMPLOYEE values (103, '김다라', 2500000, '사원' , 1);
insert into EMPLOYEE values (178, '최마바', 2700000, '사원' , 1);
insert into EMPLOYEE values (145, '강사아', 1800000, '아르바이트', 1);
insert into EMPLOYEE values (155, '손자차', 1900000, '아르바이트', 3);
insert into EMPLOYEE values (172, '정타카', 1500000, '아르바이트' , 4);
insert into EMPLOYEE values (391, '하파하', 1200000, '아르바이트', 5);

alter table EMPLOYEE add constraint Employee_PK primary key(employeeNumber);
alter table EMPLOYEE add constraint Employee_FK foreign key(FranchiseNumber) references FRANCHISE(FranchiseNumber);
select constraint_name, constraint_type from user_constraints where table_name='EMPLOYEE';
--drop table EMPLOYEE;
--------------------------------------------------------------------------------------------------------------insert 
/*
create table CUSTOMER( -- 방문고객전용 
   customerNumber number(5) not null, 
   orderDATE DATE default SYSDATE not null
);
alter table CUSTOMER add constraint CUSTOMER_PK primary key(customerNumber);
select constraint_name, constraint_type from user_constraints where table_name='CUSTOMER';
--drop table customer;
*/
-------------------------------------------------------------------------------------------------------------------- 정보가 없는애들이 주문할때,
create table ORDERSSET(
   customerNumber number(5) 
);
alter table ORDERSSET add constraint ORDERSSET_PK primary key(customerNumber);
select constraint_name, constraint_type from user_constraints where table_name='ORDERSSET';

--drop table ORDERSSET;
--------------------------------------------------------------------------------------------------------------------

create table DELICUSTOMER(  -- 미리넣어두고 
        ID nvarchar2(40) not null, -- ID
        customerNumber number(5) not null, --고객번호 
        customerName nvarchar2(40) not null, --고객이름
        Loc nvarchar2(200) , -- 고객주소
        customerPhonenumber nvarchar2(80) , -- 고객전화번호
        joinDATE DATE default SYSDATE -- 주문(방문)일자
);
alter table DELICUSTOMER add constraint DELICUSTOMER_PK primary key(ID);
select constraint_name, constraint_type from user_constraints where table_name='DELICUSTOMER';


insert into DELICUSTOMER values ('GODJY', 3842, '이재영', '서울특별시 강남구 도산대로 1', '010-1212-3434', SYSDATE);
insert into DELICUSTOMER values ('JOE', 5341, '조한영', '서울특별시 금천구 가산디지털1로 13', '010-5552-2233', SYSDATE);
insert into DELICUSTOMER values ('Nayoung_GOD', 9374, '이나영', '서울특별시 종로구 아무개로 13', '010-1122-3334', SYSDATE);
insert into DELICUSTOMER values ('Jewelry_SONG', 2012, '송보석', '서울특별시 강서구 강서로 45', '010-1552-3534', SYSDATE);
insert into DELICUSTOMER values ('CHOOOOOI', 2038, '최대현', '서울특별시 강서구 강강로 56', '010-6485-3458', SYSDATE);
insert into DELICUSTOMER values ('HKD', 7492, '홍길동', '서울특별시 어쩌구 그런대로 9', '010-6953-4534', SYSDATE);
insert into DELICUSTOMER values ('LEESS', 4752, '이순신', '서울특별시 저쩌구 치킨로 30-1', '010-0394-3452', SYSDATE);
insert into DELICUSTOMER values ('HAEEN', 5583, '조핸영', '서울특별시 서울구 서울로 6', '010-6945-3458', SYSDATE);
insert into DELICUSTOMER values ('Go_GD', 5823, '고길동', '서울특별시 부산구 해운대로 99', '010-3958-3494', SYSDATE);

-------------------------------------------------------------------------------------------------------------------- order 에서 파생 trigger
create table ORDERS(  -- 주문   RESERVATION r   r.   
   orderNumber number(8) not null, -- 주문번호
   ID nvarchar2(40) not null, -- ID
   customerNumber number(5) not null, -- 고객번호
   customercost number(20) not null, -- 결제금액
   menuName nvarchar2(30) not null check(menuName in('drink' , 'chicken' , 'alcohole')),
   star number(1) check(star in( 1 , 2 , 3 , 4 , 5)), --별점
   FranchiseNumber number(5) not null, -- 가맹점번호
   ordersSort nvarchar2(30) not null check(ordersSort in('배달' , '방문' )),
   orderDATE DATE default SYSDATE, -- 주문(방문)일자
   payment nvarchar2(50) not null check(payment in('현금' , '카드' , '계좌이체' , '삼성페이' , '카카오페이' )), --결제방식
   drinkCount number(5)  default 0,  
   alcholeCount number(5)  default 0,  
   chickenCount number(5)  default 0
);

alter table ORDERS add constraint orders_PK primary key(orderNumber);
--alter table ORDERS add constraint orders_customerNumber_FK foreign key(customerNumber) references CUSTOMER(customerNumber);
alter table ORDERS add constraint orders_menuName_FK foreign key(menuName) references MENU(menuName);
alter table ORDERS add constraint orders_FranchiseNumber_FK foreign key(FranchiseNumber) references FRANCHISE(FranchiseNumber);
alter table ORDERS add constraint orders_ID_FK foreign key(ID) references DELICUSTOMER(ID);
select constraint_name, constraint_type from user_constraints where table_name='ORDERS';
create sequence orderNumber_SEQ start with 1 increment by 1 nocache;
--drop table ORDERS;
-----------------------------------------------------------------------------------------------------------------
create table ORDERSBACKUP(
   orderNumber number(8) not null, -- 주문번호
   ID nvarchar2(40) not null -- ID
);
alter table ORDERSBACKUP add constraint ORDERSBACKUP_PK primary key(orderNumber);
create sequence BorderNumber_SEQ start with 1 increment by 1 nocache;
-----------------------------------------------------------------------------------------------------------------
create table VISIT( --방문
   orderNumber number(8) not null, --주문번호
   customerNumber number(5) not null, --고객번호
   drinkCount number(5)  default 0,  
   alcholeCount number(5)  default 0,  
   chickenCount number(10)  default 0,
   customercost number(20) not null, --결제금액
   FranchiseNumber number(5) not null, --
   payment nvarchar2(50) not null check(payment in('현금' , '카드' , '계좌이체' , '삼성페이' , '카카오페이' ))
);
alter table VISIT add constraint Visit_PK primary key(orderNumber);
alter table VISIT add constraint Visit_FK foreign key(orderNumber) references ORDERS(orderNumber) on delete cascade;
select constraint_name, constraint_type from user_constraints where table_name='VISIT';
create sequence VorderNumber_SEQ start with 1 increment by 1 nocache;
--drop table Visit;
------------------------------------------------------------------------------------------------------------------------- prder trigger
create table DELIVERY( --배달
   orderNumber number(8) not null, --주문번호 from ORDERS new
   ID nvarchar2(40) not null, --고객번호 from DELICUSTOMER 있던값
   FranchiseNumber number(5) not null, --가맹점번호 from ORDERS new
   customerName nvarchar2(40) not null, --고객이름 from DELICUSTOMER 있던값
   drinkCount number(5)  default 0,   --from ORDERS new
   alcholeCount number(5)  default 0,   --from ORDERS new
   chickenCount number(10)  default 0,   --from ORDERS new
   customercost number(20) not null, -- 결제금액 from ORDERS new
   Loc nvarchar2(200) not null, -- 고객주소 from DELICUSTOMER 있던값
   customerPhonenumber nvarchar2(80) not null , -- 고객번호 from DELICUSTOMER  있던값
   payment nvarchar2(50) not null check(payment in('현금' , '카드' , '계좌이체' , '삼성페이' , '카카오페이' )) --from ORDERS new
);
alter table DELIVERY add constraint Delivery_PK primary key(orderNumber);
alter table DELIVERY add constraint Delivery_FK foreign key(orderNumber) references ORDERS on delete cascade;
alter table DELIVERY add constraint DELIVERY_ID_FK foreign key(ID) references DELICUSTOMER(ID);
select constraint_name, constraint_type from user_constraints where table_name='DELIVERY';
create sequence DorderNumber_SEQ start with 1 increment by 1 nocache;
--drop table Delivery;
--CONSTRAINT ID_FK FOREIGN KEY(userID_FK) REFERENCES userlist(userID)
-----------------------------------------------------------------------------------------------------------------------trigger 
create table SALES( --매출 테이블 
   FranchiseNumber number(5) not null, 
   orderNumber nvarchar2(20) not null, --가맹점번호
   f_totsal number(20) not null, --매출액?
   f_daysal DATE default SYSDATE
);
alter table SALES add constraint FranchiseNumber_PK primary key(FranchiseNumber);
alter table SALES add constraint SALES_DELIVERY_FK foreign key(orderNumber) references DELIVERY(orderNumber) on delete cascade;
alter table SALES add constraint SALES_VISIT_FK foreign key(orderNumber) references VISIT(orderNumber) on delete cascade;
select constraint_name, constraint_type from user_constraints where table_name='SALES';

select CONSTRAINT_NAME , CONSTRAINT_TYPE from user_constraints;





--drop table OrderList;*/
/*
create table SUPPLY( --납품
   supplyNumber number(10) not null, --납품번호
   drinkCount number(5) default 0,  
   alcholeCount number(5) default 0,  
   chiCount number(10) default 0,
   daynumber number(10) not null
);
create table INVENTORYCONTROL(  --재고관리
   daynumber number(10) not null, -- 기본키
   FranchiseName nvarchar2(30) not null, 
   FranchiseNumber number(5) not null, 
   warehousingDATE DATE default SYSDATE not null, --입고일
   useDATE DATE default SYSDATE not null, --사용일
   drinkCount number(5),  
   alcholeCount number(5),  
   chiCount number(10) not null 
);
create table ORDERS(  -- 주문
   orderNumber number(8) not null, -- 주문번호
   customerNumber number(5) not null, -- 고객번호
   customercost number(20) not null, -- 결제금액
   menuName1 nvarchar2(200)  not null, -- 주문표
   star number(1) check(star in( 1 , 2 , 3 , 4 , 5)), --별점
   FranchiseNumber number(5) not null, -- 가맹점번호
   ordersSort nvarchar2(30) not null check(ordersSort in('배달' , '방문' , '예약')),
   orderDATE DATE default SYSDATE, -- 주문(방문)일자
   payment nvarchar2(50) not null check(payment in('현금' , '카드' , '계좌이체' , '삼성페이' , '카카오페이' )), --결제방식
   
   drinkCount number(5),  
   alcholeCount number(5),  
   chiCount number(5)  
);

*/
create or replace trigger supply_trigger  -- 남품받으면 인벤토리의 카운트가 증가되는 트리거 
after insert on SUPPLY for each row
begin
    insert into INVENTORYCONTROL values( :new.daynumber , SYSDATE , SYSDATE ,:new.drinkCount , :new.alcholeCount , :new.chickenCount );
end;
/


/*
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

create table DELIVERY( --배달
   orderNumber number(8) not null, --주문번호
   customerNumber number(5) not null, --고객번호
   FranchiseNumber number(5) not null, --가맹점번호
   customerName nvarchar2(40) not null, --고객이름
   menuName nvarchar2(200)  not null, -- 메뉴이름
   drinkCount number(5),  
   alcholeCount number(5),  
   chiCount number(10),
   customercost number(20) not null, -- 결제금액
   Loc nvarchar2(200) not null, -- 고객주소
   customerPhonenumber nvarchar2(80) not null , -- 고객번호
   payment nvarchar2(50) not null check(payment in('현금' , '카드' , '계좌이체' , '삼성페이' , '카카오페이' ))
);

*/
/*
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
  -- insert into DELIVERY VALUES ()
end;
/
*/

 -- buy_inven_procedure3(:new.chiCount);
 --  buy_inven_procedure2(:new.alcholeCount);
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

/*
create table SALES( -- 주문목록
   FranchiseNumber number(5) not null, --가맹점번호
   orderNumber number(8) not null,
   f_totsal number(20) not null, --매출액?
   f_daysal DATE default SYSDATE,
   f_bestmenu nvarchar2(100) not null
);
*/
/*
create or replace trigger orders_Deli
after insert ORDERS
*/
/*
create or replace procedure total_procedure(r in NUMBER , r1 in NUMBER , r2 in NUMBER)
is
   newdrinkSUM number;
   newalcholeSUM number;
   newchiSUM number;
begin
   select drinkCount into newdrinkSUM from DELIVERY;
   newdrinkSUM := r * 2000;
   update SALES set f_totsal = f_totsal + newdrinkSUM where FranchiseNumber = (select o.FranchiseNumber from DELIVERY o , SALES s where o.orderNumber=s.orderNumber );
   select alcholeCount into newalcholeSUM from DELIVERY;
   newalcholeSUM := r1 * 3000;
   update SALES set f_totsal = f_totsal + newalcholeSUM where FranchiseNumber = (select o.FranchiseNumber from DELIVERY o , SALES s where o.orderNumber=s.orderNumber );
   select chickenCount into newchiSUM from DELIVERY;
   newchiSUM := r2 * 20000;
   update SALES set f_totsal = f_totsal + newchiSUM where FranchiseNumber = (select o.FranchiseNumber from DELIVERY o , SALES s where o.orderNumber=s.orderNumber );
end;
/
*/
/*
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
*/

/*
— 프로시져 , 트리거 검증
 insert into supply values (supplyNumber_SEQ.nextval , 100 , 200, 300, 1);
 insert into orders values (1, 1 , 52000 , 'chicken' , 5 , 1 , '배달', SYSDATE , '현금' , 10 , 8 , 3  );
 */