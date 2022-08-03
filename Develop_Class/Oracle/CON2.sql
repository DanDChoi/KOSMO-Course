select EMPNO, ENAME, SAL from EMP where DEPTNO=10;

select ENAME, HIREDATE, DEPTNO from EMP where EMPNO=7369;

select *from EMP where ENAME='ALLEN';

select ENAME, DEPTNO, SAL from EMP where HIREDATE='81/05/01';

select * from EMP where JOB != 'MANAGER';

select * from EMP where HIREDATE>='81/04/02';

select ENAME, SAL, DEPTNO from EMP where SAL>=800;

select * from EMP where DEPTNO>=20;

select ENAME from EMP where ENAME >= 'L';

select * from EMP where HIREDATE<'81/12/09';

select ENAME, EMPNO from EMP where EMPNO<=7698;

select ENAME, SAL, DEPTNO, EMPNO from EMP where HIREDATE>'81/04/02'
and HIREDATE<'82/12/09';
select ENAME, SAL, DEPTNO, EMPNO from EMP where HIREDATE 
between '81/04/02' and '82/12/09';

select ENAME, JOB, SAL from EMP where SAL>1600 and SAL<3000;

select ENAME, EMPNO from EMP where not (EMPNO between '7654' and '7782');

select ENAME from EMP where ENAME between 'B%' and 'J%';

select HIREDATE from EMP order by HIREDATE desc;
select ENAME, HIREDATE from EMP 
where not(HIREDATE between '81/02/20' and '81/12/03');
select HIREDATE, ENAME from EMP 
where not( HIREDATE >'81/01/01' and HIREDATE<'81/12/31');

select ENAME, JOB from EMP where JOB in('MANAGER', 'SALESMAN');

select ENAME, EMPNO, DEPTNO from EMP where not(DEPTNO=20 or DEPTNO=30);

select EMPNO, ENAME, HIREDATE, DEPTNO from EMP where ENAME like 'S%';

select HIREDATE, ENAME from EMP where HIREDATE like '81/%';

select EMPNO, ENAME from EMP where ENAME like '%A%';

select ENAME from EMP where ENAME like 'S%' and ENAME like '%T';

select ENAME from EMP where ENAME like '_A%';
select ENAME from EMP where ENAME like '__A%';

select ENAME, COMM from EMP where COMM is null;

select ENAME, COMM from EMP where COMM is not null;

select ENAME, DEPTNO, SAL from EMP where DEPTNO='30' and SAL>=1500;

select EMPNO, ENAME, DEPTNO from EMP 
where ENAME like 'K%' or DEPTNO ='30';

select SAL, DEPTNO, JOB from EMP 
where SAL>=1500 and DEPTNO=30 and JOB='MANAGER';

select ENAME, EMPNO, DEPTNO from EMP where DEPTNO=30 order by EMPNO desc;

select ENAME, SAL from EMP order by SAL desc;

select ENAME, DEPTNO, SAL from EMP order by DEPTNO, SAL desc;

select DEPTNO, JOB, SAL from EMP order by DEPTNO desc, JOB, SAL desc;