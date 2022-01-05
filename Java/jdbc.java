import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc {
    public static void main(String[] args) throws Exception{

        String url = "jdbc:oracle:thin:@db01_medium?TNS_ADMIN=/Users/Dan/Desktop/Develop/Develop_Class/Oracle/";
        String user = "ADMIN";
        String password = "Dandatabase01";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("드라이버 연결됨");

        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("db연결됨");
    }
}