--alter session set "_oracle_script"=true;
--create user servlet identified by java;
--grant connect, resource, unlimited tablespace to servlet;
--conn servlet/java;


drop table MVCMEMBER;
drop sequence MEMBER_SEQ;
purge recyclebin;

create table MVCMEMBER(
   MNUM number constraint MEMBER_PK primary key, 
   NAME varchar2(12), 
   ID varchar2(20) unique,
   PWD varchar2(20),
   ATHUR number default 2 check(ATHUR in(0, 1, 2))
); 
create sequence MEMBER_SEQ increment by 1 start with 1 nocache;

insert into MVCMEMBER values(MEMBER_SEQ.nextval, '김형수', '김형수id', '1234', default);
insert into MVCMEMBER values(MEMBER_SEQ.nextval, '박과장', '박과장id', 'rhkwkd', 0);
insert into MVCMEMBER values(MEMBER_SEQ.nextval, '이사장', '이사장id', 'tkwkd', 1);


commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='MVCMEMBER';
select * from MVCMEMBER order by MNUM desc;

