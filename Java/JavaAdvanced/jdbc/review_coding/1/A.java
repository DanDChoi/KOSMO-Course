import java.sql.*;

class A{
    void init(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            pln("1 드라이버로딩 성공");
        }catch(ClassNotFoundException cnfe){
            pln("1 드라이버로딩실패 (클래스를 못찾음):"+cnfe);
        }

        String url = "jdbc:oracle:thin:@localhost:1521:JAVA";
        Conncetion con = null;
        try{
            con = DriverManager.getConnection(url, "scott", "tiger");
            pln("2 Oracle과 연결성공");
        }catch(SQLException se){
            pln("2 Oracle과 연결실패: "+se);
        }
        Statement stmt = null;
        try{
            stmt = con.createStatement();
            pln("3 stmt 생성 성공");
        }catch(SQLException se){
            pln("3 stmt 생성 실패");
        }

        pln("4 SQL 작성/전송/실행");

        try{
            stmt.close();
            con.close();
            pln("연결객체들 닫기 성공");
        }catch(SQLException se){
        }
    }
    void pln(String str){
        System.out.print(str);
    }
    public static void main(String[] args){
        new A().init();
    }
}