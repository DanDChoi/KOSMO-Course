< 오라클 12c > 

[ Part1 : 설치 및 접근 ]

1. 오라클 설치( 12c )
   (1) 디렉토리 이름이 '한글'이면 X
       1) Oracle 설치파일이 존재하는 경로에 한글X
       2) Oracle 설치경로에 한글X

   (2) 디렉토리에 '공백'이 있으면 X
       1) Oracle 설치 파일이 존재하는 경로에 공백X
       2) Oracle 설치 경로에 공백X

   (3) Windows 계정이 한글 이름이면 X     
   
   (4) 설치시에 에러 해결 방법 
       1) OS부터 밀고 다시 설치 
       2) Oracle 를 다시 설치 
          <1> 제어판 -> 프로그램 추가제거 -> 관련 프로그램 제거
          <2> 관리도구 -> 서비스 -> 오라클 관련 서비스들을 정지
          <3> Oracle 설치 디렉토리를 삭제
	         (만약, 삭제 안되면 '안전모드'에서 삭제 )
          <4> 시작 -> 모든 프로그램에서 -> Oracle관련 메뉴 삭제 
          <5> 실행 -> regedit -> oracle관련 파일을 모두 제거 
          <6> 다시 설치

        cf) SID: JAVA 
            PWD: java1234

   (5) 오라클(12c) 설치시 셋팅
       1) 드라이브변경: D -> C 
       2) Enterprise Edition 선택 
       3) 전역데이터베이스이름(SID)변경: orcl -> JAVA
       4) 비번입력: java1234 
       5) 컨테이너 데이터베이스로 생성: 체크 해제
       6) 방화벽 허용

       참고1) 중간에 계정의 lock을 풀어주는 화면나올땐 함께 셋팅
       참고2) 참고 블로그
              https://gunnm.tistory.com/232

2. 오라클 접근 
   (1) 개발 계정(scott) 활성화 
	1) 실행창( Win + R )
	    <방법1> sqlplus / as sysdba
	    <방법2> sqlplus sys/java1234 as sysdba

	2) scott / tiger 계정 생성 
	    <방법1> alter session set "_oracle_script"=true;   
                   create user scott identified by tiger; 

	    <방법2> create user c##scott identified by tiger;

               
	    cf)계정삭제 
	        drop user scott cascade;

        3) 권한부여 
	   grant connect, resource, unlimited tablespace to scott; 

	   cf)권한뺏기 
           revoke connect, resource, unlimited tablespace from scott; 

	4) scott접속 
	    <방법1> 다른 세션에서 세션을 변경  
	        conn scott/tiger;

	    <방법2> 실행창에서 
	        sqlplus scott/tiger

	5) 테이블생성 / 데이터입력 
	   탐색기( C:\app\kosmo\virtual\product 에서 ) -> 파일찾기 
	     -> scott.sql열고 복사(line 29~96) -> sqlplus창에서 붙여넣기 -> 엔터!
	     
	6) 테이블/데이터 확인 
	   select * from tab; -- select TNAME from tab;
 
           select * from EMP;
	   select * from DEPT;
           select * from SALGRADE;
	   select * from BONUS;

	7) 검색 예쁘게.. 
	   set linesize 120; --라인의 가로길이를 조정 
	   select * from EMP;
	  
        8) 세션(session) 나오기  
	   exit;
      
   (2) 오라클 접근법 
	1) sqlplus 법 
           실행창> sqlplus scott/tiger

	2) utility 법 
	   <1> sql developer ( by Oracle 사) 공짜
	   <2> sqlgate 
	   <3> toad 
	   <4> orange 
	       ... 

[ Part2 : Oracle 개요 ]
1. DBMS( DataBase Management System )의 개념 
   (1) DB( DataBase )
       - 지속적으로 유지 관리해야 할 '데이터의 집합'

   (2) DBMS
       - 'DB를 효율적으로 관리'하고, 효율적으로 저장하고, 
         검색/입력/수정/삭제 할 수 있는 환경을 제공해주는 '시스템 소프트웨어'

2. DBMS 역사 
   (1) 1960 : File System
   (2) 1970 : Network-DBMS 
   (3) 1980 : 관계형-DBMS ( RDBMS )
   (4) 1990 : 관계형-DBMS, 객체관계형( ORDBMS )
   (5) 2000 : 관계형/객체관계형/객체지향  

       ex) oracle 6.X, 7.X -> 관계형 
           oracle 8.X, 11.X, 12c.X -> 객체관계형 

3. 데이터베이스 설계
   실세계(업무분석) -> '개'념적 모델링 -> '논'리적 모델링 -> '물'리적 모델링 -> SQL작성 
                ( Entity / Attribute)  (ERD)    ( 구체적인 DBMS결정)

4. SQL( Structured Query Language )
 
	    
5. 기본 계정 
   (1) SYS
       오라클 super 사용자 ID이며, 데이터베이스에서 발생하는 
        '모든 문제'를 처리할 수 있는 권한    

   (2) SYSTEM 
       SYS과 같은데, 차이는 데이터베이스를 생성할 수 있는 권한이 없음 

   (3) SCOTT 
       처음 오라클을 사용하는 user들을 위한 SAMPLE 계정이며, 
       일반적으로 프로젝트를 구현할 때 사용하는 권한( for Developer )을 가진 계정

6. 주요 용어 
   (1) TABLE 
       관계형 DBMS에서 기본 데이터 저장 구조로써 'Entity(실체)'의 
       집합 저장소 ( ex: DEPT, EMP, SALGRADE, BONUS, ... ) 

   (2) ROW 
       테이블의 행 ( 하나의 유효한 데이터 ) 즉, Entity(실체)
       (ex : 10 ACCOUNTING     NEW YORK  )

   (3) COLUMN 
       테이블의 열명 ( Attibute 가 COLUMN이 됨 ) 
       (ex : DEPTNO,  DNAME, LOC )

   (4) FIELD 
       테이블에서 ROW와 COLUMN이 교차하는 데이터 

   (5) NULL
       데이터가 존재하지 않는 FIELD

   (6) PRIMARY-KEY
       테이블에서 각 ROW를 유일하게 구분하는 COLUMN 에 
       부여되는 '제약조건( Constraint )'

   (7) FOREIGN-KEY ( == 참조키, 외래키 )   
       부모테이블의 COLUMN값을 참조하는 테이블의 COLUMN에 
       부여되는 '제약조건( Constraint )' 

   (8) 무결성 : 데이터가 '논리적'으로 결함이 없는 성질

7. SQL의 구분 
   (1) DQL( Data Query Language ) : 조회/질의 
       ( ex: select ~ )
   (2) DML( Data Manipulation Language ) : 조작 
       ( ex: insert~,  update~,  delete~ )
   (3) TCL ( Transaction Control Language ): 트랜젝션 
       ( ex: commit, rollback, savepoint )
   (4) DDL ( Data Definition Language ) : 정의 
       ( ex: create~, alter~, drop~ , ... ) 
   (5) DCL ( Data Control Language ) : 권한 
       ( ex: grant~, revoke~ )  

8. PL-SQL
   제어문(조건문, 반복문)이 들어있는 SQL로써 오라클 DBMS에서 지원하는 확장된 SQL 
   (1) Stored Procedure
       -> 일련의 '작업처리순서를 정의'해 놓은 것으로 
         미리 DBMS에 컴파일되어져있어 프로그램 or 사용자로부터 
	 호출되면 실행되는 일종의 '작업처리순서' 
   (2) Anonymous Procedure 
       -> Stored Procedure 와의 차이점은 'DBMS에 자동으로 포함'되어 
         내부적으로 호출되는 프로시져 
   (3) Stored Function 
       -> 프로시져와 차이점은 'return값'이 존재해야 함 
   (4) Trigger 
       -> 어떤 조건에 만족되어지는 상황(DML)이 발생되면 
         자동으로 호출되어 작동되는 로직 
   (5) Package 
       -> 위의 것들을 기능별 묶어놓은 꾸러미


[ Part3 : SQL ]
1. DQL
   #1 Base 
   (1) 기본 
       SQL> select TNAME from tab;
       SQL> select TABLE_NAME from user_tables; -- user_tables들을 데이터딕셔너리라 함  
       SQL> desc DEPT -- sqlplus명령어
       SQL> select * from DEPT;
       SQL> select DEPTNO, LOC from DEPT;

   (2) all / distinct
       SQL> select JOB from EMP;
       SQL> select all JOB from EMP;
       SQL> select distinct JOB from EMP;

   (3) order by
       -- 모든 사원의 사번과 급여 출력 
       SQL> select EMPNO, SAL from EMP;
       -- 모든 사원의 사번과 급여 출력( 단, 급여가 적은 순으로 ) 
       SQL> select EMPNO, SAL from EMP order by SAL;
       SQL> select EMPNO, SAL from EMP order by SAL asc;
       -- 모든 사원의 사번과 급여 출력( 단, 급여가 많은 순으로 )
       SQL> select EMPNO, SAL from EMP order by SAL desc;
       -- 모든 사원의 사번과 급여를 출력 ( 급여가 높은 순, 같은 급여일 땐 EMPNO 오름차순 )
       SQL> select EMPNO, SAL from EMP order by SAL desc, EMPNO;
       
       -- 모든 사원의 사번과 커미션을 출력( 커미션 낮/높 순 )
       SQL> select EMPNO, COMM from EMP order by COMM; --null 뒤로 
       SQL> select EMPNO, COMM from EMP order by COMM desc; --null 앞으로 

       -- (null 제외한) 모든 사원의 사번과 커미션을 출력
       SQL> select EMPNO, COMM from EMP where COMM is not null;

       -- (null 제외한) 모든 사원의 사번과 커미션을 출력 (단, 커미션이 높으로 정렬 )
       SQL> select EMPNO, COMM from EMP where COMM is not null 
            order by COMM desc;

       -- JOB에 대해서 오름차순 정렬한 후, 급여(SAL)가 높은 순으로 정렬
       SQL> select JOB, SAL from EMP order by JOB, SAL desc;

   (4) where
       ---(부서번호가 20인) 사번과 부서번호 출력 
       SQL> select EMPNO, DEPTNO from EMP where DEPTNO=20;

       -- 30번 부서인 부서번호(DEPTNO)와 급여(SAL)와 사번(EMPNO)을 출력(단, 급여가 높으로 순)
       SQL> select EMPNO, DEPTNO, SAL from EMP where DEPTNO=30 order by SAL desc;

       -- 입사일이 81년 12월 3일 이후의 사번과 이름과 입사일과 부서번호 출력 (단, 사번의 내림차순)
       SQL> select EMPNO, ENAME, HIREDATE, DEPTNO from EMP
            where HIREDATE>='81/12/03'
            order by EMPNO desc;
	   
       -- 입사일이 81년 12월 3일 이후의 사번과 이름과 입사일과 부서번호 출력 (단, 사번의 내림차순, 20번부서만 )
       SQL> select EMPNO, ENAME, HIREDATE, DEPTNO from EMP
            where HIREDATE>='81/12/03' and DEPTNO=20
            order by EMPNO desc;

  (5) Alias 
      SQL> select JOB "직업", SAL "급여" from EMP;
      SQL> select JOB as "직업", SAL as "급여" from EMP;
      SQL> select JOB 직업, SAL 급여 from EMP;
      SQL> select JOB 직업, SAL "1234" from EMP;
      SQL> select JOB 직업, SAL "!@#$" from EMP;
      SQL> select JOB 직업, SAL "급 여" from EMP;


  (6) 연산자( Operator )
      1) 산술연산자 ( + , -, * , / )
         --30번 부서 사원의 급여를 10% 인상해서 사번(EMPNO)과 급여(SAL)를 출력
         SQL> select EMPNO, SAL*1.1 from EMP where DEPTNO=30;

	 --30번 부서 사원의 '연말보너스'를 이름과 연말보너스를 출력(연말보너스가 높은 순) 
	 -- ( 단, 연말보너스는 급여의 2배와 커미션의 1/2의 합이다.)
	 SQL> select EMPNO, ENAME, SAL*2+COMM/2 "연말보너스" from emp 
	      where DEPTNO=30 order by "연말보너스" desc;
	 SQL> select EMPNO, ENAME, SAL*2+NVL(COMM, 0)/2 "연말보너스" from emp 
	      where DEPTNO=30 order by "연말보너스" desc;

      2) 비교연산자 ( =, !=, >, >=, < , <= )
	 -- 급여가 3000 이상인 사원의 이름(ENAME)과 급여(SAL)를 출력
	 SQL> select ENAME, SAL from emp where SAL>=3000;

	 -- 30부서가 아닌 사원의 이름(ENAME)과 급여(SAL)와 부서번호(DEPTNO)를 출력
	   -- ( 부서번호의 오름차순, 높은 급여순, 이름 오름차순 )
	 SQL> select ENAME, SAL, DEPTNO from EMP where DEPTNO!=30 
	      order by DEPTNO, SAL desc, ENAME;

      3) 논리연산자 ( and(곱) , or(합), not )  
	 -- 20번 부서이면서 급여 3000이상인 사원의 이름, 급여, 부서번호를 출력
	 SQL> select ENAME, SAL, DEPTNO from EMP where SAL>=3000 and DEPTNO=20;

	 -- 직업이 'SALESMAN'이고 부서번호가 30번인 이름, 직업, 부서번호를 출력
         SQL> select ENAME, JOB, DEPTNO from EMP 
	      where JOB='SALESMAN' and DEPTNO=30;

	 -- 급여가 1000 미만이거나, 4000 이상인 사원의 사번, 급여를 출력
	 SQL> select EMPNO, SAL from EMP where SAL<1000 or SAL>=4000;
	 SQL> select EMPNO, SAL from EMP where not (SAL>=1000 and SAL<4000);


      4) SQL연산자( in, any, all, between, like, is null, is not null, exists )
	 -- 부서번호가 10 or 20 or 100 인 사원의 부서번호과 이름을 출력
	 SQL> select DEPTNO, ENAME from EMP where DEPTNO=10 or DEPTNO=20 or DEPTNO=100;     
	 SQL> select DEPTNO, ENAME from EMP where DEPTNO in(10, 20, 100);
	 SQL> select DEPTNO, ENAME from EMP where DEPTNO=any(10, 20, 100);

	 -- 30부서의 최대 급여보다 더 큰 급여를 받는 사원의 이름, 급여 출력
	 SQL> select ENAME, SAL from EMP where DEPTNO=30;
	 SQL> select ENAME, SAL from EMP where SAL>all(select SAL from EMP where DEPTNO=30);
	    cf) all은 전체값을 모두 만족해야 true가 됨 

         -- 급여가 1250 이상 3000 이하인 사원의 이름과 급여 출력
	 SQL> select ENAME, SAL from EMP where SAL>=1250 and SAL<=3000;
	 SQL> select ENAME, SAL from EMP where SAL between 1250 and 3000;

	 -- 이름이 'FORD'와 'KING' 사이의 사원 이름을 출력!(단, 알파벳 순 정렬) 
	 SQL> select ENAME from EMP where ENAME 
	      between 'FORD' and 'KING' order by ENAME;

	 -- 이름이 'J'로 시작되는 사원 이름을 출력(단, 오름차순 정렬)
         SQL> select ENAME from EMP where ENAME like 'J%' order by ENAME;

	 -- 이름에 'T'로 시작되는 사원 이름을 출력
	 SQL> select ENAME from EMP where ENAME like '%T%';

	 -- 이름에 세번째 문자가 'A'인 사원의 이름을 출력
	 SQL> select ENAME from EMP where ENAME like '__A%';

	 -- 급여의 십의 자리가 5인 사원의 급여를 출력
	 SQL> select SAL from EMP where SAL like '%5_';

	 -- 커미션이 NULL인 사원의 사번과 커미션을 출력
	 SQL> select EMPNO, COMM from EMP where COMM is null;

	 -- 커미션이 NULL이 아닌 사원의 사번과 커미션을 출력
	 SQL> select EMPNO, COMM from EMP where COMM is not null;

	 -- 이름이 'FORD'라는 사원이 존재하면 모든 사원의 이름을 출력
	 SQL> select ENAME from EMP where ENAME='FORD';
	 SQL> select ENAME from EMP where exists(select ENAME from EMP where ENAME='FORD');

	 -- 이름이 'ford'라는 사원이 존재하면 모든 사원의 이름을 출력
	 SQL> select ENAME from EMP where ENAME='ford';
	 SQL> select ENAME from EMP where exists(select ENAME from EMP where ENAME='ford');


      5) 결합연산자 ( || )
	--SMITH의 급여는 800입니다
	select ENAME||'의 급여는', SAL||'입니다' from EMP;

      6) 집합연산자 ( union(합) , union all, intersect(교), minus(차) )
        -- 사원의 사번과 이름 출력하고, 부서의 번호와 부서이름을 출력
        SQL> select EMPNO, ENAME from EMP;
	SQL> select DEPTNO, DNAME from DEPT;
	SQL> select EMPNO, ENAME from EMP
	      union
	     select DEPTNO, DNAME from DEPT;
	     
        -- 사원의 사번과 이름 출력하고, 사원의 사번과 이름 출력
	SQL> select EMPNO, ENAME from EMP;
	SQL> select EMPNO, ENAME from EMP;
	SQL> select EMPNO, ENAME from EMP
	      union 
	     select EMPNO, ENAME from EMP;
	SQL> select EMPNO, ENAME from EMP
	      union all
	     select EMPNO, ENAME from EMP;

	-- '사원의 사번과 이름'과 '부서의 번호와 부서이름'의 공통부분을 출력 
	SQL> select EMPNO, ENAME from EMP
	      intersect
	     select DEPTNO, DNAME from DEPT; --0개 

	SQL> select EMPNO, ENAME from EMP
	      intersect
	     select EMPNO, ENAME from EMP where ENAME='FORD'; --1개 

	SQL> select EMPNO, ENAME from EMP 
	      minus
	     select EMPNO, ENAME from EMP where ENAME='FORD'; --11개 

	cf) 연산자 우선 순위
	  <1> 1순위: 비교, SQL, 산술  
	  <2> 2순위: not
	  <3> 3순위: and 
	  <4> 4순위: or
	  <5> 5순위: ||, 집합 

	SQL> select ENAME, SAL from EMP
	    where NOT SAL>1000 and SAL<3000;
	SQL> select ENAME, SAL from EMP
	    where NOT (SAL>1000 and SAL<3000); 
	  
///////////////////// 문제 1 ///////////////////////////////////////

--최대 급여를 받는 사원의 이름을 출력
SQL> select ENAME from EMP where SAL>=all(select SAL from EMP);
SQL> select max(SAL) from EMP;
Main> select ENAME from EMP where SAL=(select max(SAL) from EMP);

    #2 Function
    (1) 함수(Function)란?
        어떤 일을 수행하는 기능으로써 주어진 인수(arguments)를 재료로 '처리'하여,
        그 결과를 '반환'하는 일
        
    (2) 기능 기준 분류
        1) Data 계산
        2) Data 변환
    
    (3) 종류
        1) 단일행 함수 (ex: nvl, ...)
            -> 하나의 행(row)당, 하나의 결과값을 리턴하는 함수
        2) 복수행 함수 (ex: max, min, avg ..)
            -> 여러개의 행(row)당, 하나의 결과값을 리터하는 함수
    
    (4) 단일행 함수
        1) 문자 함수
            <1> chr
                SQL> select chr(65) from DUAL;

            <2> concat(컬럼명, '붙일문자열')
                SQL> select ENAME||' is a ' || JOB from EMP;
                SQL> select concat(ENAME, ' is a '), JOB from EMP;

            <3> initcap('문자열')
                SQL> select initcap('the lion') from DUAL;
            
            <4> lower('문자열')
                SQL> select lower('MY NAME IS KHS') from DUAL;
                SQL> select lower(ENAME) from EMP;

            <5> lpad('문자열1', 자리수, '문자열2')
                SQL> select lpad('khs', 13, '*#') from DUAL;
                
                설명) lpad('대상문자열', 총 문자길이, '채움문자')
            
            <6>

        2) 숫자 함수
        
        3) 날짜 함수 ( *** )

        4) 문자 변환 함수 ( ***** )
    
    (5) 복수행 함수 ( group function ***** )