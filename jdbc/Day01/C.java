import java.sql.*;

//PreparedStatement 
class C
{
	String url = "jdbc:oracle:thin:@localhost:1521:JAVA";
	Connection con;
	PreparedStatement pstmt0, pstmt1, pstmt2;
	String tname = "JDBCT";
	String sql0 = "insert into "+tname+" values(?, ?, SYSDATE)"; //������ 
	String sql1 = "select * from "+tname+" order by NO desc";
	String sql2 = "select * from "+tname+" where NAME like ?"; //�ӵ�
	C(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			pstmt0 = con.prepareStatement(sql0);
			pstmt1 = con.prepareStatement(sql1);
			pstmt2 = con.prepareStatement(sql2);
		}catch(ClassNotFoundException cnfe){
			pln("����̹��ε� ����(Ŭ������ �� ã��)");
		}catch(SQLException se){
            pln("Oracle�� ���� ���� or stmt ���� ����");
		}
	}
    void insertD(int no, String name){
        try{
			pstmt0.setInt(1, no);
			pstmt0.setString(2, name);
			int i = pstmt0.executeUpdate();
            if(i>0) pln(i+"���� row �Է� ����");
			else pln("�Էµ��� ����");
		}catch(SQLException se){
			pln("insertD() se: " + se);
		}
	}
	void selectD(){
		ResultSet rs = null;
		try{
			rs = pstmt1.executeQuery();
			int cnt = 0;
			pln("NO\tNAME\tRDATE");
			pln("--------------------------");
			while(rs.next()){
				int no = rs.getInt("NO"); 
				String name = rs.getString("NAME");
				Date rdate = rs.getDate("RDATE");
				pln(no+"\t"+name+"\t"+rdate);

				cnt++;
			}
			pln("--------------------------");
			pln("�� "+cnt+"�� ������ �˻���");
		}catch(SQLException se){
            pln("selectD() ����: " + se);  
		}finally{
            try{
				rs.close();
			}catch(SQLException se){}
		}
	}
	void selectD(String na){
		ResultSet rs = null;
		try{
			na = "%"+na+"%";
			pstmt2.setString(1, na);
			rs = pstmt2.executeQuery();
			int cnt = 0;
			pln("NO\tNAME\tRDATE");
			pln("--------------------------");
			while(rs.next()){
				int no = rs.getInt("NO"); 
				String name = rs.getString("NAME");
				Date rdate = rs.getDate("RDATE");
				pln(no+"\t"+name+"\t"+rdate);

				cnt++;
			}
			pln("--------------------------");
			pln("�� "+cnt+"�� ������ �˻���");
		}catch(SQLException se){
            pln("selectD(na) ����: " + se);  
		}finally{
            try{
				rs.close();
			}catch(SQLException se){}
		}
	}
	void closeAll(){
		try{
		    pstmt0.close();
			pstmt1.close();
			pstmt2.close();
			con.close();
		}catch(SQLException se){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		C c = new C();
		//c.insertD(10, "������");
		//c.insertD(20, "�ź�ö");
		//c.insertD(30, "���ȯ");

		//c.selectD();

		c.selectD("��");
		c.closeAll();
	}
}
