<%@ page contentType="text/html;charset=utf-8" import="javax.sql.DataSource, java.sql.*"%>
<jsp:useBean id="dbcp" class="soo.dbcp.DbcpBean" scope="application"/>

<%!
	Connection con;
	PreparedStatement pstmt;
	DataSource ds;
	String sql = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, ?, ?, SYSDATE)";

%>
<%
String name = request.getParameter("name");
String email = request.getParameter("email");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
out.println("<script>");
	try{
		ds = dbcp.getDs();
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, subject);
		pstmt.setString(4, content);
		int i = pstmt.executeUpdate();
		if(i>0){
			out.println("alert('게시글 등록 성공 with dbcp')");
		}else{
			out.println("alert('게시글 등록 실패 with dbcp')");
		}
	}catch(SQLException se){
		out.println("alert('게시글 등록 실패 with dbcp')");
	}
	out.println("location.href='list.jsp'");
	out.println("</script>");
%>