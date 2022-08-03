<%@  page contentType="text/html; charset=utf-8" import="java.sql.*"%>
<%!
	   Connection con;
	   Statement stmt;
	   PreparedStatement pstmt;
	   String sql = "delete from BOARD where SEQ=?";
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
		  }catch(SQLException se){}
	   }
	   public void jspDestroy(){ //DB연결해제 
        try{
         if(stmt != null) stmt.close();
         if(con != null) con.close();
      }catch(SQLException se){}
   } 
		private int getSeq(HttpServletRequest request){
			  String seqStr = request.getParameter("seq");
			  int seq = -1;
			  if(seqStr != null) {
				seqStr = seqStr.trim();
				if(seqStr.length() !=0){
					try{
						seq = Integer.parseInt(seqStr);
						return seq;
					}catch(Exception se){
					}
				 }
			  }
			  return seq;
		}
%> 
<%
	int seq = getSeq(request); 
	if(seq!=-1){
		 try{
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		  }catch(SQLException se){
		  } 
	}
	response.sendRedirect("list.jsp");
%>
