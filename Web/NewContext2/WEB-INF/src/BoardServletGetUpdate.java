package soo.sv.board;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;

public class BoardServletGetUpdate extends HttpServlet {
   Connection con;
   Statement stmt;
   PreparedStatement pstmt;
   String sql;
   public void init(){
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
      String usr = "servlet";
      String pwd = "java";
      try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
         con = DriverManager.getConnection(url, usr, pwd);
		 stmt = con.createStatement();
      }catch(ClassNotFoundException cnfe){
         System.out.println("Oracle driver loading failed");
      }catch(SQLException se){}
   }
   public void service(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException { 
      res.setContentType("text/html;charset=utf-8"); 
	  req.setCharacterEncoding("UTF-8");
	  int seq = -1;
	  String seqStr = req.getParameter("seq");
	  seqStr = seqStr.trim();
	  if(seqStr.length() != 0){
		seq = Integer.parseInt(seqStr);
	  }else{
		res.sendRedirect("list.do");
	  }
	  String name = req.getParameter("writer");
	  String email = req.getParameter("email");
	  String subject = req.getParameter("subject"); 
	  String content = req.getParameter("content");
      String sql = "update BOARD set EMAIL='"+email+"', WRITER='"+name+"', SUBJECT='"+subject+"', CONTENT='"+content+"' where SEQ='"+seq+"'";
	  PrintWriter pw = res.getWriter(); 
	  
      pw.println("<script>");
	  try{
		int i = stmt.executeUpdate(sql);
		if(i>0){
			pw.println("alert('게시글 수정성공)");
		}else{
			pw.println("alert('게시글 수정 실패')");  
		}
	  }catch(SQLException se){
	  }

	  pw.println("location.href='list.do'");
	  pw.println("</script>");
      res.sendRedirect("list.do");
   }
   public void destroy(){ 
        try{
         if(stmt != null) stmt.close();
         if(con != null) con.close();
      }catch(SQLException se){}
   }
}