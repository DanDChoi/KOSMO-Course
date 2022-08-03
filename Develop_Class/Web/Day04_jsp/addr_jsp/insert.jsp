<%@ page contentType="text/html;charset=utf-8" import="java.sql.*"%>

<%!
    Connection con;
	PreparedStatement pstmt;
	String sql = "insert into address values(ADDRESS_SEQ.nextval, ?, ?, SYSDATE)";
	public void jspInit(){ //DB연결 
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		String usr = "servlet";
		String pwd = "java";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, usr, pwd);
			pstmt = con.prepareStatement(sql);
		}catch(ClassNotFoundException cnfe){
			System.out.println("#Oracle driver loading failed");
		}catch(SQLException se){
			System.out.println("#init() se: " + se);
		}
	}
	public void jspDestroy(){ //DB연결해제 
        try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se){}
	}
%>
<%
    request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");

%>
    <script>
<%
	
	try{
		pstmt.setString(1, name);
		pstmt.setString(2, addr);
		int i = pstmt.executeUpdate();
		if(i>0){
			out.println("alert('입력성공 with JSP')");
		}else{
			out.println("alert('입력실패 with JSP')");
		}
	}catch(SQLException se){
		out.println("alert('입력실패 with JSP')");
	}
%>
    location.href='list.jsp';
	</script>

