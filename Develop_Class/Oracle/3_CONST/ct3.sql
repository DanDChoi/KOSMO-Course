drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;
set linesize 120;

create table CT_DEPT(
    DEPTNO number(2), 
    DNAME varchar2(14) default '개발부', 
    LOC char(1), 
    primary key(DEPTNO), 
    check(LOC in ('1', '2'))
);
select constraint_name, constraint_type from user_constraints 
where table_name='CT_DEPT';

create table CT_EMP( 
    NO number(4),  
    NAME varchar2(10) not null, 
    ADDR varchar2(6), 
    JUMIN varchar2(13), 
    RDATE date default SYSDATE, 
    DEPTNO number(2), 
    primary key(NO), 
    check(ADDR in ('서울', '부산')), 
    unique(JUMIN), 
    foreign key(DEPTNO) references CT_DEPT(DEPTNO)
);
select constraint_name, constraint_type from user_constraints 
where table_name='CT_EMP';

insert into CT_DEPT(DEPTNO, LOC) values(10, '1');
select * from CT_DEPT;

insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) 
   values(1000, '홍길동', '서울', '123456124567', 10);
insert into CT_EMP
   values(2000, '이순신', '부산', '123456124568', SYSDATE, 10);
commit;
select * from CT_EMP;