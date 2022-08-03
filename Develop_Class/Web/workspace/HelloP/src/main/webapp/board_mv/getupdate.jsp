<%@ page contentType="text/html;charset=utf-8" import="javax.sql.DataSource, java.sql.*"%>
<jsp:useBean id="dbcp" class="soo.dbcp.DbcpBean" scope="application"/>

<%
	  request.setCharacterEncoding("UTF-8");
	  int seq = -1;
	  String seqStr = request.getParameter("seq");
	  seqStr = seqStr.trim();
	  if(seqStr.length() != 0){
		seq = Integer.parseInt(seqStr);
	  }else{
		response.sendRedirect("list.jsp");
	  }
	  String name = request.getParameter("writer"); 
	  String email = request.getParameter("email");
	  String subject = request.getParameter("subject"); 
	  String content = request.getParameter("content");
	  String sql = "update BOARD set EMAIL='"+email+"', WRITER='"+name+"', SUBJECT='"+subject+"', CONTENT='"+content+"' where SEQ='"+seq+"'";
	
	DataSource ds = null;
	Connection con = null;
	Statement stmt = null;
	  try{
			ds = dbcp.getDs();
			con = ds.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql); 
	  }catch(SQLException se){
	  }
	  response.sendRedirect("list.jsp");
%>