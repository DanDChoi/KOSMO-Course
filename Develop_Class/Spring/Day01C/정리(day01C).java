< 복습 >

1. JDK변경 
    (1) (프로그램 추가/제거) jdk11제거 
    (2) jdk 1.8 설치 

2. STS셋팅 
    (1) spring-tool-suite-3.9.11.RELEASE-e4.14.0-win32-x86_64.zip 압축해제 
    (2) C:\SOO\Spring\sts-bundle 이동  
    (3) STS.ini 추가 
       -vm
       C:\Program Files\Java\jdk1.8.0_221\bin\javaw.exe
    (4) STS.exe 실행 
    (5) C:\SOO\Spring\sts-bundle\workspace 추가 

3. 프로젝트 생성  
    (1) Spring Legacy Project -> Project name: Sp01 -> Spring MVC Project 선택 
    (2) 패키지설정: soo.ct.controller 

4. STS에서 JDK 버젼 변경  
    (1) Window -> Preferences -> Java -> Compiler -> JDK Compliance -> 1.8 

    (2) Properties for Sp01 ( Sp01 -> 오른쪽 마우스 -> Properties )
       <1> Java Build Path -> Libraries -> JRE System Library -> 1.8 
       <2> Project Facets -> Java -> 1.8
  
5. UTF-8 인코딩 변경 ( Window -> Preperences -> Web )
    (1) CSS 
    (2) HTML 
    (3) JSP 

6. 프로젝트 셋팅 
    (1) pom.xml 수정 
       <1> 수정
            <java-version>1.8</java-version>  
       <2> 추가 
           1> 변경
            <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
		<dependency>
		    <groupId>javax.servlet</groupId>
		    <artifactId>javax.servlet-api</artifactId>
		    <version>3.1.0</version>
		    <scope>provided</scope>
		</dependency>
           2> 변경 
             <dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
	     </dependency> 
	   3> 변경 
	      <dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>

	   4> lombok 추가 ( lombok.jar -> 실행: (java -jar lombok.jar -> STS.exe 지정)  )
	        <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
		<dependency>
		    <groupId>org.projectlombok</groupId>
		    <artifactId>lombok</artifactId>
		    <version>1.18.6</version>
		    <scope>provided</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-test</artifactId>
		    <version>${org.springframework-version}</version>
		    <scope>test</scope>
		</dependency>

7. ContextLoaderListener 에러 해결 
    (1) 에러 메세지
      java.lang.ClassNotFoundException: org.springframework.web.context.ContextLoaderListener
   
    (2) 해결 방법 
      Properties for Sp01( Sp01 -> 오른쪽 마우스 -> Properties ) 에서 
      Deployment Assembly -> Add버튼 -> java build path entries -> Next버튼 -> Maven Dependencies 추가

8. 톰켓서버로 변경 + Context경로 수정  
    (1) Servers탭 -> 오른쪽마우스 -> New -> Server -> tomcat9선택 -> tomcat9경로 지정 
    (2) 생성된 tomcat9 더블클릭 -> Modules탭 -> edit버튼 -> Path : /

9. Controller 예제 
    (1) 인덱스 생성 
        - soo.ct.controller.IndexController 생성 
        - index.jsp 
    (2) 컨트롤러 생성 
        - TestController 생성 
        - index.jsp 링크 + TestController 메소드추가 ( 12개 )

        cf) log.info()를 인식 못할때 -> 재부팅 
   
 