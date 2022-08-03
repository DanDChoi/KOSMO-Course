drop table TR_MYHOME;
drop table TR_LOGIN;
drop table TR_MEMBER;
drop sequence TR_MYHOME_SEQ;
purge recyclebin;

-- ȸ�� 
create table TR_MEMBER(
    ID varchar2(10) constraint TR_MEMBER_PK primary key, 
    PWD varchar2(10) constraint TR_MEMBER_PWD_NN not null, 
    NAME varchar2(20) constraint TR_MEMBER_NAME_NN not null, 
    EMAIL varchar2(20) constraint TR_MEMBER_UQ unique, 
    RDATE date
);
-- �α��� 
create table TR_LOGIN(
    ID varchar2(10), 
    PWD varchar2(10), 
    constraint TR_LOGIN_PK primary key(ID), 
    constraint TR_LOGIN_FK foreign key(ID) references TR_MEMBER(ID) on delete cascade
);
-- Ȩ������ 
create table TR_MYHOME(
    SEQ number constraint TR_MYHOME_PK primary key, 
    ID varchar2(10) constraint TR_MYHOME_ID_NN not null, 
    HNAME varchar2(100) constraint TR_MYHOME_HNAME_NN not null, 
    TOTCOUNT number default 0, 
    HMSG varchar2(100), 
    CDATE date, 
    constraint TR_MYHOME_FK foreign key(ID) references TR_MEMBER(ID) on delete cascade
);
create sequence TR_MYHOME_SEQ start with 1 increment by 1 nocache;

select TNAME from tab;
select SEQUENCE_NAME from seq;

--HNAEM, HMSG varchar2�� �����ʿ�.



--Q1
CREATE OR REPLACE TRIGGER JOIN 
AFTER DELETE OR INSERT OR UPDATE ON TR_MEMBER 
FOR EACH ROW
BEGIN
IF INSERTING THEN
    insert into TR_LOGIN values (:NEW.ID, :NEW.PWD);
    insert into TR_MYHOME values (TR_MYHOME_SEQ.nextval, :NEW.ID, :NEW.NAME||'�� Ȩ������', 123841, :NEW.NAME||'�Դϴ�.', SYSDATE);  
END IF;
END;
/

--Q2
CREATE OR REPLACE TRIGGER CHANGEPWD
AFTER DELETE OR INSERT OR UPDATE ON TR_MEMBER
FOR EACH ROW
BEGIN
IF UPDATING THEN
    update TR_LOGIN set PWD=:NEW.PWD;
END IF;
END;
/



insert into TR_MEMBER values('DAN', '123456', '�ִ���', 'dan@gmail.com', SYSDATE);


select * from TR_LOGIN;
select * from TR_MEMBER;
select * from TR_MYHOME;


update TR_MEMBER set PWD='654321';

select * from TR_LOGIN;
select * from TR_MEMBER;


create or replace trigger sorting
after insert on ORDERS 
for each row
begin
if :new.ordersSort = '�湮' 
then
    insert into VISIT values 
    (:new.orderNumber, :new.customerNumber, :new.drinkCount, :new.alcholeCount, 
    :new.chickenCount, :new.customercost, :new.FranchiseNumber, :new.payment);
elsif :new.ordersSort = '���'
then
    insert into DELIVERY values 
    (:new.orderNumber, 
    (select ID from DELICUSTOMER where ROWNUM = 1 order by orderTime desc), 
    :new.FranchiseNumber, 
    (select customerNumber from DELICUSTOMER where ROWNUM = 1 order by orderTime desc), 
    :new.drinkCount, 
    :new.alcholeCount, 
    :new.chickenCount, 
    :new.customercost, 
    (select Loc from DELICUSTOMER where ROWNUM = 1 order by orderTime desc), 
    (select customerPhonenumber from DELICUSTOMER where ROWNUM = 1 order by orderTime desc), 
    :new.payment);
end if;
end;
/