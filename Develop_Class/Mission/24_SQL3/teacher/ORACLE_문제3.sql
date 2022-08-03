 < ���� (JOIN & SUB-QUERY) >

(1) EMP�� DEPT TABLE�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿��� ����϶�.
    select d.DEPTNO, d.DNAME, e.ENAME, e.SAL from EMP e 
    join DEPT d 
    on e.DEPTNO=d.DEPTNO;
    
(2) �̸��� 'ALLEN'�� ����� �μ����� ����϶�.
    select e.ENAME, d.DNAME from EMP e, DEPT d 
    where e.ENAME='ALLEN';

(3) EMP Table�� �ִ� DATA�� JOIN�Ͽ� ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ����϶�.
    select e.ENAME "�̸�", D.DEPTNO "�μ���ȣ", D.DNAME "�μ���", e.SAL "�޿�" from EMP e, DEPT d
    where e.DEPTNO=d.DEPTNO;  

(4) EMP Table�� �ִ� EMPNO�� MGR�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�.
    --> SMITH�� �Ŵ����� FORD�̴�.
    select e.ENAME||'�� �Ŵ����� ', m.ENAME||'�̴�' from EMP e, EMP m 
    where e.MGR=m.EMPNO; 
(5) 'ALLEN'�� ������ ���� ����� �̸�, �μ���, �޿�, ������ ����϶�.
    select e.ENAME, d.DNAME, e.SAL, e.JOB from EMP e, DEPT d
    where e.DEPTNO=d.DEPTNO and JOB=any(select JOB from EMP where ENAME='ALLEN');

(6) 'JONES'�� �����ִ� �μ��� ��� ����� �μ���ȣ, �����ȣ, �̸�, �Ի���, 
   �޿��� ����϶�.
    select DEPTNO, EMPNO, ENAME, HIREDATE, SAL from EMP
    where DEPTNO=(select DEPTNO from EMP where ENAME='JONES');

(7) ��ü ����� ����ӱݺ��� ���� ����� �����ȣ, �̸�, �μ���, �Ի���, ����, 
    �޿��� ����϶�. 
    select e.EMPNO "�����ȣ", e.ENAME "�̸�", d.DNAME "�μ���", e.HIREDATE "�Ի���", d.LOC "����", e.SAL "�޿�"from EMP e, DEPT d
    where e.DEPTNO=d.DEPTNO and SAL>(select avg(SAL) from EMP);

(8) 10�� �μ� ����� �߿� 20�� �μ��� ����� ���� ������ �ϴ� ����� �����ȣ, 
    ����, �̸�, �μ���, �Ի���, ������ ����϶�. 
    select e.EMPNO "�����ȣ", e.JOB "����", e.ENAME "�̸�", d.DNAME "�μ���", HIREDATE "�Ի���", d.LOC "����"
    from EMP e, DEPT d 
    where e.DEPTNO=d.DEPTNO and e.DEPTNO=10 and JOB=any(select JOB from EMP where DEPTNO=20);

(9) 10�� �μ��߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, ����, 
    �̸�, �μ���, �Ի���, ������ ����϶�.
    select e.EMPNO "�����ȣ", e.JOB "����", e.ENAME "�̸�", d.DNAME "�μ���", HIREDATE "�Ի���", d.LOC "����"
    from EMP e, DEPT d 
    where e.DEPTNO=d.DEPTNO and e.DEPTNO=10 and JOB!=any(select JOB from EMP where DEPTNO=30);

(10) 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, ����, �̸�, �μ���ȣ, �μ���, 
   ����, �޿��� �޿��� ���� ������ ����϶�.
    select e.EMPNO "�����ȣ", e.JOB "����", e.ENAME "�̸�", e.DEPTNO "�μ���ȣ", d.DNAME "�μ���", HIREDATE "�Ի���", d.LOC "����", e.SAL "�޿�"
    from EMP e, DEPT d 
    where e.DEPTNO=d.DEPTNO and JOB=any(select JOB from EMP where DEPTNO=10)
    order by SAL desc;
  
(11) 'MARTIN'�̳� 'SCOTT'�� �޿��� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.
    select DEPTNO, ENAME, SAL from EMP 
    where SAL=(select SAL from EMP where ENAME='MARTIN' or ENAME='SCOTT');
  
(12) �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.
    select EMPNO, ENAME, SAL from EMP 
    where SAL>(select max(SAL) from EMP where DEPTNO=30);

(13) �޿��� 30�� �μ��� ���� �޿����� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.
    select EMPNO, ENAME, SAL from EMP 
    where SAL<(select min(SAL) from EMP where DEPTNO=30);