import java.sql.*;

class B 
{
	String url = "jdbc:oracle:thin:@localhost:1521:JAVA";
	Connection con;
	Statement stmt;
	B(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			stmt = con.createStatement();
			//pln("stmt ���� �ܰ���� ����");
		}catch(ClassNotFoundException cnfe){
			pln("����̹��ε� ����(Ŭ������ �� ã��)");
		}catch(SQLException se){
            pln("Oracle�� ���� ���� or stmt ���� ����");
		}

		//createT();

        createTnoExist(); //�̼�! 
		//��Ʈ: sql = select TABLE_NAME from user_tables where TABLE_NAME='"+tname+"';

		//dropT();

		//insertD(10, "ȫ�浿");
		//insertD(20, "�̼���");
		//insertD(30, "������");

		//updateD(20, "�ź�ö");

		//deleteD(10); // ���� �ð� �����鼭.. ���� �õ��غ�����

		selectD();

		closeAll();
	}

    //DDL 
	String tname = "JDBCT";
    void createT(){
		String sql = "create table "+tname+"(NO number(2) primary key, NAME varchar(10), RDATE date)";
		try{
			stmt.execute(sql);
			pln(tname+"���̺� ���� ����");
		}catch(SQLException se){
            pln(tname+"���̺� ���� ����: " + se);
		}
	}
	void createTnoExist(){
		String sql = "select TABLE_NAME from user_tables where TABLE_NAME='"+tname+"'";
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery(sql);
			if(!rs.next()) createT();
		}catch(SQLException se){
		}finally{
			try{
				rs.close();
			}catch(SQLException se){}
		}
	}
	void dropT(){
		String sql = "drop table "+tname;
		String purge = "purge recyclebin";
		try{
			stmt.execute(sql);
			stmt.execute(purge);
			pln(tname+"���̺� ��� ����");
		}catch(SQLException se){
            pln(tname+"���̺� ��� ����: " + se);
		}
	}

    //DML
	void insertD(int no, String name){
		String sql = "insert into "+tname+" values("+no+", '"+name+"', SYSDATE)";
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0){
				pln(i+"���� row �Է� ����");
			}else{
			    pln("�Էµ��� ����");
			}
		}catch(SQLException se){
			pln("�Է� ����: " + se);
		}
	}
	void updateD(int no, String name){
		String sql = "update "+tname+" set name='"+name+"' where NO="+no;
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0){
				pln(i+"���� row ���� ����");
			}else{
			    pln("�������� ����");
			}
		}catch(SQLException se){
			pln("���� ����: " + se);
		}
	}
	void deleteD(int no){ //����!!
        String sql = "delete from "+tname+" where NO="+no;
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0){
				pln(i+"���� row ���� ����");
			}else{
			    pln("�������� ����");
			}
		}catch(SQLException se){
			pln("���� ����: " + se);
		} 
	}

	//DQL
	void selectD(){
		String sql = "select * from "+tname+" order by RDATE desc";
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery(sql);
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
    
	void closeAll(){
		try{
		    stmt.close();
			con.close();
		}catch(SQLException se){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		B b = new B();
	}
}
