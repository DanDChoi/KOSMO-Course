import java.sql.*;

//ResultSet¿« ±∏¡∂ ( ResultSetMetaData ) 
class B {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
	Connection con;
	Statement stmt;
	String sql = "select * from JDBCT order by NO desc";

	B(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		}catch(ClassNotFoundException cnfe){
			pln("(1) Excep: " + cnfe);
		}catch(SQLException se){
			pln("(2) Excep: " + se);
		}
	}
	void createRs(){
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery(sql);
			
			ResultSetMetaData rsmd = rs.getMetaData();
            int cc = rsmd.getColumnCount();
            for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				p(cn + "\t");
			}
			pln("");

			for(int i=1; i<=cc; i++){
				p("--------");
			}
			pln("");

			while(rs.next()){
				for(int i=1; i<=cc; i++){
					String data = rs.getString(i);
					p(data + "\t");
				}
				pln("");
			}
		}catch(SQLException se){
		}
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		B b = new B();
		b.createRs();
	}
}

