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

13. 제어예약어
	(1) break
		1) switch블럭 or loop안에서만 나올 수 있음
		2) 자신을 둘러싼 첫번째 블럭을 '나간다'
		3) labled break

			//ex) Day07/A.java

	(2) continue
		1) loop 안에서만 나올 수 있음
		2) (조건에 맞으면) '건너뛴다'
		3) labled continue

			//ex) Day07/B.java

	(3)	return
		1) 생성자나 메소드 안에서 어디서 나올 수 있음
		2) 호출한 곳 or JVM으로 '되돌린다'

			//ex) Day07/C.java

14. 연산자 (Operator)
	(1) 연산하게 하는 '기호'

	(2) 종류
		1) 산술 ex) +, -, *, /, &
		2) 증감 ex) ++, --
		3) 대입 ex) =
		4) 산술대입 ex) +=, -=, /=, %=
		5) 비트 ex) &, |, ^, ~, 시프트(<<, >>, >>>)
		6) 비교 ex) ==, !=, <, <=, >, >=
		7) 논리 ex) &, &&, |, ||
		8) 논리대입 ex) &=, |=
		9) 조건 ex) A? B:C
		10) instanceof ex) 객체 instanceof 클래스

		//ex) Day07/E.java

15. 배열(Array)
	같은 타입의 데이터 '저장소'로서, 생성될 때 그 크기가 고정되는 '객체'

	(1) 선언
		type 배열변수[];
		( ex: int is[]; , String strs[]; ..)

	(2) 생성
		배열변수 = new type[크기];
		( ex: is = new int[4]; , strs = new String[4]; ..)

	(3) 초기화
		배열변수[인덱스] = 데이터;
		( ex: is[0]=10;, strs[0]="봄";..)

		//ex) Day08/A.java

	(4) 선언 및 생성
	    type 배열변수[] = new type[크기];
		( 예: int is[]=new int[4]; String strs[]=new String[4]; .. ) 

	(5) 선언 및 생성 및 초기화
	    type 배열변수[] = {데이터1, 데이터2, 데이터3, .. };
		( 예: int is[]={10, 20, 30, 40}; String strs[]={"봄", "여름"}; .. )

		//ex) day08/A.java

    (6) 분리 주의 사항 
	    '선언'과 '생성 및 초기화'는 분리될 수 없음
		
		//ex) day08/B.java

	(7) 배열방의 default 값 ( by JVM )
		byte, short, char, int : 0
		long : 0L
		float : 0.0f
		double : 0.0
		boolean : false
		참조형 : null

		//ex) day08/C.java

	(8) 형변환 
	    자동형변환이 가능한 데이터라면 변환되어져서 저장됨
	    ( 예: int is[] = {b, s, c, i, (int)f}; )

		//ex) day08/D.java

	(9) length 속성 
		배열방의 크기를 리턴 

		//ex) day08/E.java 

	(10) 2차원 
		1차원 배열을 데이터(element)로 갖는 배열 

	    //ex) day08/F.java 	
		
	(11) n차원 
		(n-1)차원 배열을 데이터(element)로 갖는 배열 

		//ex) day08/G.java

16. 컬렉션 ( Collection ) 계열 ( Data Structure, 가변배열 )
	같은 타입의 '참조형'데이터 '저장소'로써 그 크기가 변하는 '객체'

	(1) 종류
		1)			java.util.Collection
					  |				|
			java.util.List		java.util.Set
				|						|
		ArrayList, Vector,..	TreeSet, SortedSet,..



		2)			java.util.Map
						|
				Hashtable, HashMap,..


	(2) 특징
		1) List
			- 순서를 보존한다
			- 중복을 허용한다

			//ex) Day09/A1.java

		2) Set ( 비유: 수학에서의 집합 )
			- 순서를 보존하지 않는다
			- 중복을 허용하지 않는다

			//ex) Day09/B1~B3.java
		
		3) Map ( 비유: 1대1 대응)
			- key와 value값으로 저장
			- 순서를 보존하지 않는다
			- key는 중복 X, value는 중복 O
				(key가 중복된다면, value는 새로운 값으로 덮어씀)
			
			//ex) Day09/C1~C3.java
		
		cf) Generic, AutoBoxing, Enhanced Loop

17. OOP(Object Oriented Programming) 특성
	(1) 상속성 ( Inheritance )
		부모의 '모든 것'을 자식에서 '상속 받는 것'

		1) 다른 생성자가 하나도 없을 때만 JVM이 기본생성자를 만들어 줌
			( 자식 객체가 생성되려면 먼저 부모객체가 생성되어야 함 )
		2) 모든 생성자의 첫라인에는 super();가 생략되어 있음
			( 단, 다른 super(..)가 있다면 예외 )
		3) 자식메소드에서 부모메소드의 내용을 변경할 수 있음 ( overriding )
		4) 모든 객체는 Object 의 자식 ( 묵시적 상속 )
		5) 형변환
			- 자동형변환 by JVM ( 자식 -> 부모 )
			- 강제형변환 by 개발자 ( 부모 -> 자식 )
		6) 형제관계(남남)는 상속과 무관 ( 형변환 X )

		//ex) Day10/A.java

	(2) 다형성 ( Polimorphism )
		같은 타입 객체의 같은 메소드가 다른 일을 하는 것

		//ex) Day10/B.java

	(3) 은닉성 ( Information Hiding )
		외부 프로그램으로부터 '속성값'을 감추는 것
		( 멤버를 private 으로 놓고 선택적으로 메소드(getter/setter)를 정의해서 접근 )
		//ex) Day10/C.java
		
	(4) 캡슐화 ( Encapsulation )
		메소드의 구현 내용을 몰라도 그 형태만 알면 호출해서 사용할 수 있는 것

		//ex) Day10/D.java


18. 예외 처리

	(1) 예외( Exception )
		프로그램이 정상적으로 진행되지 못하게 하는 '돌발 상황'

		예) 숫자가 아닌 형태의 문자열을 숫자로 바꾸려할 때 
		    채팅하다가 상대방이 나가 버릴때
			온라인 게임하고 있는 중에 전원케이블이 빠짐
			게임 서버 다운됨 
			...

	(2) 처리 목적 
		프로그램 진행시 발생할 수 있는 '돌발 상황'을 예외로 미리 정해놓고, 
		해당하는 예외가 발생했을 경우 적적한 조치를 취해서, 프로그램이
		'정상 작동'하도록 하는 것 

	(3) 계층도 
			              Object 
						    | 
						 Throwable
						 |        | 
					  Error     Exception 
					            |        | 
				    CompileException   RuntimeException  
				   (CheckedException) 

			예) IOException is a CompileException 
			    NumberFormatException is a RuntimeException 

			//ex) Day11/A.java 
		
	(4) 특징
		1) 일(생성자 or 메소드)할 때 발생할 수 있음
		2) throw 로 예외 객체를 던짐 (발생시킴)
		3) throws 로 예외 발생 가능 표식을 함 ( == (소극적으로) 떠넘김 )
		4) try catch 로 잡을 수 있음 ( == (적극적으로) 때려잡음 )


			//ex) Day11/B.java

	(5) 방법
		1) 때려 잡는 방법
			try{
				예외가 발생할 수 있는 구문 (생성자 or 메소드)
			}catch(예외타입 예외객체){
				처리로직
			}

		2) 떠넘기는 방법
			throws 예외타입
		
			//ex) Day11/C.java

			
	(6) 순서 ( try절 안에 2개 이상의 예외가 발생시 )
		1) 상속관계X
			[순서존재X] 아무 예외나 먼저 잡아줌
			예) catch(MyException me)
				catch(YourException ye)

		2) 상속관계O
			[순서존재O] 하위예외부터 잡아줌
			예) catch(MyException me)
				catch(Exception e)

			질문) 자식예외를 먼저 잡는 이유? 구체적이고 세련된 예외처리를 위해서

			//ex) Day11/D.java

	(7) 2개 이상의 예외를 떠넘길 때
		throws MyExceptin, YourException, ..... , Exception
			//ex) Day11/D.java

	(8) finally 절
		1) try절이 나오면
			catch절이 나오던지.. finally절이 나오던지..
			둘 다 나오던지 해야 함
		
		2) 항상 수행되는 절
			- 예외 발생과 상관 없이 수행
			- 심지어 return을 만나더라도 finally 절을 수행 후 리턴

		3) 얘는 못이김
			System.exit(0); //normal termination
			System.exit(-1); //abnormal termination

		
			//ex) Day11/E.java

19. 제한자 ( Modifier )
	클래스(인터페이스), 변수, 생성자, 메소드 앞에 붙어서 기능을 '제한'하는 예약어

	(1) 접근제한자 ( Access Modifier )
			1) 종류
				<1> public : 접근 제한이 없음
				<2> protected : 같은 패키지의 자원 or 상속관계의 부모 자원
				<3> default : 같은 패키지의 자원
				<4> private : 클래스 안
			
			2) 붙는 특성
				<1> 클래스나 인터페이스 앞의 접근제한자는 public 과 default 만 가능
				<2> public 클래스나 인터페이스는 파일이름과 이름이 같아야 한다
				<3> 멤버, 생성자, 메소드는 제한없이 붙을 수 있음
				<4> 지역변수는 default만 붙음
				
			3) 범위
				<1> 넓은 순위 : public > protected > default > private
				<2> 강력 순위 : public < protected < default < private

			//ex) Day12/A.java, AUser.java, B.java

	(2) 소유제한자 ( static )
			-> 붙으면 클래스 소유 됨
			1) 멤버와 메소드에만 붙을 수 있음
			2) static 자원은 클래스 이름으로 접근 가능
			3) static 메소드에서는 자원접근시 자신의 클래스 이름 생략가능
				(단, 다른 클래스에서는 클래스이름 생략 불가)
			4) static 메소드내에서 객체자원을 접근시에는 객체를 생성시켜서 그 객체로 접근함
			5) static 자원은 메모리에 1개 생성되어 모든 객체에게 공유 됨

			//ex) Day12/C.java, D.java

	(3) 수정제한자 ( final )
		-> 붙으면 수정을 못하게 함
		1) 클래스, 변수(지역변수 포함), 메소드 앞에 붙을 수 있음
		2) 클래스 앞에 붙으면 자식을 못낳고,
		   변수 앞에 붙으면 초기값을 못바꾸고,
		   	메소드 앞에 붙으면 오버라이딩을 막음

			//ex) Day12/E.java
			
	(4) 추상제한자 ( abstract )
		->붙으면 추상화 됨
		1) 클래스와 메소드 앞에서만 붙을 수 있음
		2) 하나 이상의 '추상메소드'를 가진 클래스는 반드시 '추상클래스'가 되어야 함
		3) 추상 클래스 객체는 완벽한 자식클래스 객체를 생성해서 형변환하여 생성 함
			- 추상클래스: abstract 가 붙은 클래스 
			- 추상메소드: abstract 가 붙은 메소드

			//ex) Day12/F.java

	(5) 기타제한자
		synchronized(쓰레드), transient(보안), native(OS자원) 