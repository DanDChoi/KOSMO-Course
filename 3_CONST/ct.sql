drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;

create table CT_DEPT(
    DEPTNO number(2), -- PK부여 
    DNAME varchar2(14) default '개발부', 
    LOC char(1) -- CHECK부여: '1' or '2'
);
--select constraint_name, constraint_type, table_name from user_constraints where table_name='CT_DEPT';

create table CT_EMP( 
    NO number(4), -- PK부여 
    NAME varchar2(10), -- not null부여 
    ADDR varchar2(6), -- CHECK부여: '서울' or '부산' 
    JUMIN varchar2(13), -- UNIQUE부여
    RDATE date, -- default 현재날짜/시간
    DEPTNO number(2) -- FK부여 
);
--select constraint_name, constraint_type, table_name from user_constraints where table_name='CT_EMP';

insert into CT_DEPT(DEPTNO, LOC) values(10, '1');
select * from CT_DEPT;

insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) 
   values(1000, '홍길동', '서울', '123456124567', 10);
insert into CT_EMP
   values(2000, '이순신', '부산', '123456124568', SYSDATE, 10);
commit;
select * from CT_EMP;