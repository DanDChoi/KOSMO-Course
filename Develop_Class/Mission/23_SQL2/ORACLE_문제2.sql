< ���� (FUNCTION) >

(1) EMP Table���� �̸�, �޿�, Ŀ�̼� �ݾ�, �Ѿ�(sal+comm)�� ���Ͽ� �Ѿ��� 
    ���� ������ ����϶�. ��, Ŀ�̼��� NULL�� ����� �����Ѵ�. 
        select ENAME, SAL, COMM, SAL+COMM FROM EMP
        where COMM is not NULL
        order by SAL+COMM desc;
    
(2) 10�� �μ��� ��� ����鿡�� �޿��� 13%�� ���ʽ��� �����ϱ�� �Ͽ���.
    �̸�, �޿�, ���ʽ� �ݾ�, �μ� ��ȣ�� ����϶�.
        select ENAME, SAL, SAL*1.3-SAL "���ʽ��ݾ�", DEPTNO from EMP
        where DEPTNO = 10;  

(3) 30�� �μ��� ������ ����Ͽ� �̸�, �μ���ȣ, �޿�, ������ ����϶�.
    ��, ������ �޿��� 150%�� ���ʽ��� �����Ѵ�. 
        select ENAME, DEPTNO, SAL, SAL*12 "����", SAL*1.5 "���ʽ�" from EMP;

   
(4) �μ� ��ȣ�� 20�� �μ��� �ð��� �ӱ��� ����Ͽ� ����϶�.
    ��, 1���� �ٹ��ϼ��� 12���̰�, 1�� �ٹ��ð��� 5�ð��̴�.
    ��¾���� �̸�, �޿�, �ð��� �ӱ�(�Ҽ����� 1��° �ڸ����� �ݿø�)
    �� ����϶�. 
        select ENAME, SAL, round(SAL/60, 1) "�ð��� �ӱ�" from EMP;

(5) �޿��� $1,500 ���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���.
    �̸� �̸�, �޿�, ȸ��(-2�ڸ����� �ݿø�)�� ����϶�.
        select ENAME, SAL, round(SAL*0.15, 2) "ȸ��" from EMP
        where SAL>=1500 and SAL<=3000;
	   
(6) �޿��� $2,000 �̻��� ��� ����� �޿��� 15%�� ������� ����� �Ͽ���. 
    �̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�.
        select ENAME, SAL, trunc(SAL*0.15, -1) "������" from EMP
        where SAL>=2000;    

(7) �Ի��Ϻ��� ���ݱ����� ��¥���� ����϶�.
    �μ� ��ȣ, �̸�, �Ի���, ������, �ٹ��ϼ�(�Ҽ��� ���� ����), 
	�ٹ����(�ݿø�),�ٹ�����(30�� ����,�ݿø�), �ٹ��ּ�(�ݿø�)�� ����϶�.
        select DEPTNO, ENAME, HIREDATE "�Ի���", SYSDATE "������",
        trunc (MONTHS_BETWEEN(SYSDATE, HIREDATE)*30, -1) "�ٹ��ϼ�",
        round (MONTHS_BETWEEN(SYSDATE, HIREDATE)/12) "�ٹ����",
        round (MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�ٹ�����",  
        round (MONTHS_BETWEEN(SYSDATE, HIREDATE)*4) "�ٹ��ּ�" from EMP;

(8) ��� ����� �Ǽ��ɾ��� ����Ͽ� ����϶�.
    ��, �޿��� ���� ������ �̸�, �޿�, �Ǽ��ɾ��� ����϶�
    (�Ǽ��ɾ��� �޿��� ���� 10%�� ������ �� �ݾ�)
        select ENAME, SAL, SAL*0.9 "�Ǽ��ɾ�" from EMP
        order by SAL desc;

(9) �Ի��Ϸκ��� 90���� ���� ���� ��� �̸�, �Ի���, 90�� ���� ��, �޿��� ����϶�.
        select ENAME, 
        to_char(HIREDATE, 'YY-MM-DD') "�Ի���", 
        to_char(HIREDATE+90, 'YY-MM-DD') "�Ի���+90", SAL from EMP;


(10) �Ի��Ϸκ��� 6������ ���� ���� �Ի���, 6���� ���� ��¥, �޿��� ����϶�.
        select HIREDATE, add_months(HIREDATE, 6) "�Ի� �� 6����", SAL from EMP;

(11) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �Ի���, �ٹ��ϼ��� ����϶�.
        select DEPTNO, ENAME, HIREDATE, last_day(HIREDATE)-HIREDATE "�Ի��� �� �ٹ��ϼ�" from EMP;

(12) ��� ����� 60���� ���� ���� 'MONDAY'�� �� ��, �� ��, �� �� �ΰ��� ���Ͽ�
     �̸�, �Ի���, 'MONDAY'�� ����϶�.
        select ENAME, HIREDATE, next_day(HIREDATE+60, 2) "Monday" from EMP;

(13) �Ի��Ϸκ��� ���ñ����� �ϼ��� ���Ͽ� �̸�, �Ի���, �ٹ��ϼ�(�ݿø�)�� 
     ����϶�.
        select ENAME, HIREDATE, round(MONTHS_BETWEEN(SYSDATE, HIREDATE)*30) "�ٹ��ϼ�" from EMP;

(14) �Ի����� '1996�� 5�� 14��'�� ���·� �̸�, �Ի����� ����϶�.
        select ENAME, to_char(HIREDATE, 'YYYY"��"MM"��"DD"��"') "�Ի��� "from EMP;

(15) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� 
     �ҹ��ڷ� �̸����� ����϶�.
        select lower(substr(ENAME,1,3)) from EMP
        where length(ENAME)>=6;

(16) 10�� �μ� ������ ���, �ְ�, ����, �ο����� ���Ͽ� ����϶�.
        select avg(SAL), MAX(SAL), MIN(SAL), count(*) from EMP
        where DEPTNO=10;

(17) �� �μ��� �޿��� ���, �ְ�, ����, �ο����� ���Ͽ� ����϶�.
     (�μ���ȣ�� ���)
        select DEPTNO, avg(SAL), MAX(SAL), MIN(SAL), count(*) from EMP
        group by DEPTNO order by DEPTNO; 

(18) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ, ������, �ο����� ����϶�.
        select DEPTNO, JOB, count(*) from EMP
        group by DEPTNO, JOB
        order by DEPTNO, JOB;  

(19) ���� ������ �ϴ� ����� ���� 4�� �̻��� ������ �ο����� ����϶�.
        select DEPTNO, JOB, count(*) from EMP
        group by DEPTNO, JOB
        having count(*)>=4
        order by DEPTNO, JOB desc;

(20) �� �μ��� ��� ����, ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ 
     ���� ������ ����϶�. (�μ���ȣ�� ���)
        select DEPTNO, avg(SAL), sum(SAL), max(SAL), min(SAL) from EMP
        group by DEPTNO
        order by sum(SAL) desc;



