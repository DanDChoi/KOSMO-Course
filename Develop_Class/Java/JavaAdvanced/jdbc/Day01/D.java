import java.sql.*;

//CallableStatement 
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
			pln("����̹��ε� ����(Ŭ������ �� ã��)");
		}catch(SQLException se){
            pln("Oracle�� ���� ���� or stmt ���� ����");
		}
	}
	void call(int empno, float rate){
		try{
			cstmt.setInt(1, empno);
			cstmt.setFloat(2, rate);
			cstmt.execute();
			pln("ȣ�� ����");
		}catch(SQLException se){
			pln("ȣ�� ����: " + se);
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		D d = new D();
		d.call(7902, 0.1f);
	}
}
