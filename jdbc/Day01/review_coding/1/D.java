import java.sql.*;

class D {
    String url = "jdbc:oracle:thin:@localhost:1521:JAVA";
    Connection con;
    CallableStatement cstmt;
    String sql = "call incre(?, ?)";
    D(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "scott", "tiger");
            cstmt = con.prepareCall(sql);
        }catch(ClassNotFoundException cnfe){
            pln("드라이버로딩 실패(클래스를 못 찾음)");
        }catch(SQLException se){
            pln("Orcle과 연결실패 or stmt 생성 실패");
        }
    }
    void call(int empno, float rate){
        try{
            cstmt.setInt(1, empno);
            cstmt.setFloat(2, rate);
            cstmt.execute();
            pln("호출성공");
        }catch(SQLException se){
            pln("호출실패"+se);
        }
    }
    void pln (String str){
        System.out.print(str);
    }
    public static void main(String[] args){
        D d= new D();
        d.call(7902, 0.1f);
    }
}