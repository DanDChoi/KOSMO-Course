import java.sql.*;

class A 
{
	void init(){
		//(1) 드라이버(driver) 로딩 
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			pln("(1) 드라이버로딩 성공");
		}catch(ClassNotFoundException cnfe){
			pln("(1) 드라이버로딩 실패(클래스를 못 찾음): " + cnfe);
		}
		//(2) Connection 생성 
		String url = "jdbc:oracle:thin:@localhost:1521:JAVA";
		Connection con = null;
		try{
			con = DriverManager.getConnection(url, "scott", "tiger");
			pln("(2) Oracle과 연결 성공");
		}catch(SQLException se){
            pln("(2) Oracle과 연결 실패: " + se);
		}
		//(3) Statement 생성 
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			pln("(3) stmt 생성 성공");
		}catch(SQLException se){
			pln("(3) stmt 생성 실패");
		}

		//(4) SQL 작성/전송/실행
		pln("(4) SQL작성/전송/실행");

		//(5) 연결객체들 닫기
		try{
		    stmt.close();
			con.close();
			pln("(5) 연결객체들 닫기 성공");
		}catch(SQLException se){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new A().init();
	}
}

//set classpath=.;C:\Users\CHOI\Desktop\Dan\Develop\Develop_Class\Java\ojdbc8.jar
//javac A.java
//java A