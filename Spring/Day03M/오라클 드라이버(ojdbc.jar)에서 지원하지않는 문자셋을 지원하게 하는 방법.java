< 오라클의 드라이버(ojdbc.jar)에서 지원하지않는 문자셋을 지원하게 하는 방법 >

(1) 에러 메세지 
	Request processing failed; 
	nested exception is org.springframework.jdbc.UncategorizedSQLException: 
	Error attempting to get column 'SEQ' from result set. Cause: java.sql.SQLException: 
	지원되지 않는 문자 집합(클래스 경로에 orai18n.jar 추가): KO16MSWIN949

(2) 해결 방법 
    1) pom..xml 에 다음을 추가
		<!-- https://mvnrepository.com/artifact/com.oracle.database.nls/orai18n -->
		<dependency>
			<groupId>com.oracle.database.nls</groupId>
			<artifactId>orai18n</artifactId>
			<version>11.2.0.4</version>
		</dependency>
  
     2) Tomcat9/context.xml 에 다음을 추가 ( tomcat실행시 warning 메세지 줄이는 효과 )
        <WatchedResource>WEB-INF/web.xml</WatchedResource>
	    ..
	    <JarScanner scanManifest="false"/>

     3) Tomcat restart!