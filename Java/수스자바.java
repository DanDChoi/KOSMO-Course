1. HW ( OS + JVM + App1, App2, ... )
   (1) CPU, GPU : 두뇌 
   (2) RAM(메모리) : 책상 
   (3) HDD/SSD : 책꽃이
   (4) MainBoard : 방
   (5) Card : Sound, Video, Ran, WLRan, .. 
   (6) 주변기기: 키보드, 모니터, 마우스, 프린터, 본체.. 

2. 환경 설정 
   (1) JDK (file) 설치 
	   - jdk ( Java Development Kit )
	   - jre (Java Runtime Environment )
   (2) 환경변수 
	   - JAVA_HOME => C:\Program Files\Java\jdk-11.0.13 
	   - Path => %C:\Program Files\Java\jdk-11.0.13%\bin
	   - classpath => .
   (3) Editer
       - Editplus 
	   - Eclipse
	   - VSCode
	   - IntelliJ

   (4) API
       - jdk-11.0.13_doc-all.zip 압축해제 / 즐겨찾기 

3. 실행 원리 
   (1) 작성(.java) -> 컴파일(javac.exe) -> 클래스파일생성(.class) -> 실행(java.exe)
   (2) .java ( for Man) -> .class ( for Com )

4. 실행되는 클래스 
    public static void main(String args[]){}

	ex) day01/A.java 

5. 클래스 구조 
   (1) 패키지 선언 
   (2) 임포트 구문 
   (3) 클래스 선언 {
		(4) 멤버변수 
		(5) 생성자(Constructor)
		(6) 메소드(Method) 
    }

	ex) day02/A.java, AUser.java 

6. 패키지 컴파일 / 실행 
   > javac -d . *.java 
   > java AUser 
   > java aa.bb.AUser //AUser.java 에 패키지가 선언된 경우

7. 주석 ( Comment )
   (1) 1라인 //
   (2) N라인 
       /*
	      라인1
		  라인2 .... 
	   */
   (3) 문서화주석 
       /**
	      라인1
		  라인2 .... 
	   */

	ex) day02/B.java 

8. 객체지향( OOP: Object Oriented Programming ) 용어   
	(1) 클래스 ( Class ) : '객체'를 만드는 틀
	    ex) 붕어빵틀 

	(2) 객체 ( Object ) : 클래스를 통해 나온 구현물, 모든 것 
        ex) 붕어빵 

	(3) 생성자 ( Constructor ) : '객체'가 생성될 때 하는 일(행위)
	   
	(4) 메소드 ( Method ) : '객체'가 할 수 있는 일(행위)

	(5) 속성 ( Attribute == Member == Field ) : '객체'의 특성 
	    ( 다양한 객체를 표현하기 위해서 존재 )  
	    ex) 앙꼬, 가격  

		ex) day02/D.java 

9. 클래스 설계 
/*
    일상의 어떤 현상을 상상해서.. 
    클래스 설계를 하고, 객체를 생성하여 표현(메소드/속성)하시오
	
*/
    //점심식사 후에 발표! 

   ex) day03/빵어빵.java 

10. 변수( Variable )
	(1) 유효범위 
		1) 멤버(==전역) 
			<1> 클래스(소속) 
			<2> 객체(소속) ( == 인스턴스 ) 
		2) 지역 
			<1> 파라미터(==매개==아규먼트)
			<2> 선언초기화 

		ex) day04/A.java, B.java
		   

	(2) 메모리 
		1) 기본형(primitive==원시데이터) : 8가지 
			<1> call by value 
			<2> 형태 : 모두 소문자 
			<3> 종류 
			    byte ▶ short ▶ int ▶ long ▶ float ▶ double 
                        char ▶

				boolean 
		    <4> 담을 수 있는 값의 범위
			    1> byte(1) : -2^7 ~ 2^7-1 (경우의수: 2^8)
				2> short(2) : -2^15 ~ 2^15-1(경우의수: 2^16)
				3> char(2) : 0 ~ 2^16-1 (경우의수: 2^16)
				4> int(4) : -2^31 ~ 2^31-1 (경우의수: 2^32)
				5> long(8) : -2^63 ~ 2^63-1 (경우의수: 2^64)
				6> float(4) : 무한대 (경우의수: 2^32)
				7> double(8) : 무한대 (경우의수: 2^64) 
				8> boolean(1) : false / true 

				ex) day04/C.java, D.java,  

		    <5> 형변환( Type Casting )
				1> 자동형변환(암시적/Implicit) by JVM
				   - 범위 작은 Type -> 큰 Type 

				2> 강제형변환(명시적/Explicit) by 개발자 
				   - 범위 큰 Type -> 작은 Type 
				 
				ex) day04/E.java

			<6> 예외 형변환 
			   정수형(byte, short, char, int)끼리의 연산의 결과는 int 

			    ex) day04/E.java

			<7> 컴퓨터 소수 연산 오차 
			   float 오차가 double 보다 큼 

			<8> 디폴트 초기값 by JVM
			   정수(0, 0L), 실수(0.0f, 0.0), 불린(false)
			    ex) day04/F.java

		    <9> 존재이유 
			   실행의 효율성 

			   cf) Wrapper class 
			   Byte, Short, Character, Integer, Long, Float, Double, Boolean 
			   
		2) 참조형(reference==레퍼런스) : 무한대
			<1> call by reference  
			<2> 형태: (관례상)첫문자 대문자 
			<3> 디폴트초기값: null
            <4> 형변환
			      //나중에... 

			ex) day04/G.java

	(3) 소유 
		1) 클래스(==정적)
			static 붙으면 클래스 소유 
		2) 객체(==동적)
		    static 붙지 않으면 객체 소유

           ex) day04/A.java 

	(4) final 
		1) 상수( Constant )
		    final 붙으면 '초기'값을 못 바꿈 

		2) 변수( Variable ) 

		    ex) day04/H.java 
	
11. 제어
    어떤 프로그램이 실행되고 있을 때..
	어느 한 시점의 (CPU/GPU)연산은 어떤 특정 코드부분을 실행하고 있을 것이다
	그 코드 부분을 '제어점'이라고 하고, 그 제어점들의 집합을 '제어'라고 한다
	즉, "프로그램의 실행 흐름(line)"

	JVM -> main() ..... main() -> JVM

	cf 비유 : '부메랑'

	ex) Day05/A.java

12. 제어문
	(1) 조건문
		1)if(boolean형){}
		2)if(boolean형){}.. else if(boolean형){}.. else{}
		3)switch(정수형){case: .... default: } 문
			=>정수형+String, break, default위치X, case안에 블럭을 생략가능

			ex) day05/B.java, C.java //점심시간까지 1번씩 타이핑

	(2) 반복문
		초기식(루프 밖에), 조건식(루프 안에), 증감식(루프 안에)을 갖추어야 '유한루프'가 됨
		
		1) while(boolean형){} //신사
			//ex) Day06/A.java

		2) for (초기식; 조건식; 증감식){} //신사 (while과 100%호환가능)
			//ex) Day06/A.java, B.java
		
		3) do{} while(boolean형); //조폭
			//ex) Day06/A.java

		