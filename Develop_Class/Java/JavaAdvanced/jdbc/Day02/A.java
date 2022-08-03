import java.sql.*;

//동적 커서 이동 
class A 
{
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
	Connection con;
	Statement stmt;
	String sql = "select * from JDBCT order by NO";
	//String sql = "select NO, NAME, to_char(RDATE, 'YYYY-MM-DD AM HH:MI:SS DAY')  from JDBCT order by NO";

	A(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE
			//ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE
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

			forward(rs); //BOF -> EOF 
			backward(rs); //EOF -> BOF
			rs.afterLast(); //EOF
            backward(rs); //EOF -> BOF

            forward(rs); //BOF -> EOF
            rs.beforeFirst(); //BOF 
			forward(rs);
		}catch(SQLException se){
			pln("(3) Excep: " + se);
		}
	}
	void forward(ResultSet rs){
		try{
			pln("< 순방향 >");
			while(rs.next()){
				int no = rs.getInt(1);
				String name = rs.getString(2);
				//Date rdate = rs.getDate(3);
				String rdate = rs.getString(3);
				pln(no + "\t" + name + "\t"+ rdate);
			}
		}catch(SQLException se){}
	}
	void backward(ResultSet rs){ //구현!! 
        try{
			pln("< 역방향 >");
			while(rs.previous()){
				int no = rs.getInt(1);
				String name = rs.getString(2);
				//Date rdate = rs.getDate(3);
				String rdate = rs.getString(3);
				pln(no + "\t" + name + "\t"+ rdate);
			}
		}catch(SQLException se){
			pln("backward() se: " + se);
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
		A a = new A();
		a.createRs();
	}
}

//rs.next()
//rs.previous()
//rs.afterLast()
//rs.beforeFirst()