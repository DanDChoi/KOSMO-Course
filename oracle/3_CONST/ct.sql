drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;

create table CT_DEPT(
    DEPTNO number(2), -- PK�ο� 
    DNAME varchar2(14) default '���ߺ�', 
    LOC char(1) -- CHECK�ο�: '1' or '2'
);
--select constraint_name, constraint_type, table_name from user_constraints where table_name='CT_DEPT';

create table CT_EMP( 
    NO number(4), -- PK�ο� 
    NAME varchar2(10), -- not null�ο� 
    ADDR varchar2(6), -- CHECK�ο�: '����' or '�λ�' 
    JUMIN varchar2(13), -- UNIQUE�ο�
    RDATE date, -- default ���糯¥/�ð�
    DEPTNO number(2) -- FK�ο� 
);
--select constraint_name, constraint_type, table_name from user_constraints where table_name='CT_EMP';

insert into CT_DEPT(DEPTNO, LOC) values(10, '1');
select * from CT_DEPT;

insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) 
   values(1000, 'ȫ�浿', '����', '123456124567', 10);
insert into CT_EMP
   values(2000, '�̼���', '�λ�', '123456124568', SYSDATE, 10);
commit;
select * from CT_EMP;