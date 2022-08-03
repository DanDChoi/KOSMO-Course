<%@ page contentType="text/html;charset=utf-8" import="java.sql.*"%>


<%!
	Connection con;
	PreparedStatement pstmt;

	String sql = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, ?, ?, SYSDATE)";

	public void jspInit(){ 
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
		public void jspDestroy(){ 
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String email = request.getParameter("email");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
out.println("<script>");
	try{
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, subject);
		pstmt.setString(4, content);
		int i = pstmt.executeUpdate();
		if(i>0){
			out.println("alert('게시글 등록 성공 with jsp')");
		}else{
			out.println("alert('게시글 등록 실패 with jsp')");
		}
	}catch(SQLException se){
		out.println("alert('게시글 등록 실패 with jsp')");
	}
	out.println("location.href='list.jsp'");
	out.println("</script>");
%>