package soo.sv.board;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;

public class BoardServletContent extends HttpServlet{
	Connection con;
	PreparedStatement pstmt;
	public void init(){   
		String sql = "select * from BOARD where SEQ=?";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		String usr = "servlet";
		String pwd = "java";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, usr, pwd);
			pstmt = con.prepareStatement(sql);
		}catch(ClassNotFoundException cbfe){
			System.out.println("Oracle driver loading fauled");
		}catch(SQLException se){
			System.out.println("se: " + se);
		}
	}
	public void service(HttpServletRequest req, HttpServletResponse res)  
		throws ServletException, IOException {   
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter(); 
		String seqStr = req.getParameter("seq");
		int seq = -1;
		if(seqStr == null){
			res.sendRedirect("list.do");
			return;
		}
		seqStr = seqStr.trim();
		if(seqStr.length() == 0){
			res.sendRedirect("list.do");
			return;
		}else{
			try{
				seq = Integer.parseInt(seqStr);
			}catch(NumberFormatException nfe){
				res.sendRedirect("list.do");
				return;
			}
		}

		pw.println("<meta charset='utf-8'>");
		pw.println("<style>");
		pw.println("table, th, td {");
		pw.println("border: 1px solid black;");
		pw.println("border-collapse: collapse;");
		pw.println("}");
		pw.println("th, td {");
		pw.println("padding: 5px;");
		pw.println("}");
		pw.println("a { text-decoration:none }");
		pw.println("</style>");
		pw.println("<center>");
		pw.println("<hr width='600' size='2' noshade>");
		pw.println("<h1>");
		pw.println("Simple Board");
		pw.println("</h1>");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;");  
		pw.println("<a href='input.html'>글쓰기</a>");
		pw.println("<hr width='600' size='2' noshade>");
		pw.println("<table border='1' width='600' align='center' cellpadding='3'>");

		ResultSet rs = null;
		try{
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String con = rs.getString(5);
				Date rdate = rs.getDate(6);    
				pw.println("<tr>");
				pw.println("<td width='100' align='center'>글번호</th>");
				pw.println("<td>"+seq+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th width='100' align='center'>글쓴이</th>");
				pw.println("<td>"+name+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th width='100' align='center'>이메일</th>");
				pw.println("<td>"+email+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th width='100' align='center'>글제목</th>");
				pw.println("<td>"+subject+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th width='100' align='center'>글내용</th>");
				pw.println("<td>"+con+"</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th width='100' align='center'>날짜</th>");
				pw.println("<td>"+rdate+"</td>");
				pw.println("</tr>");
			}
		}catch(SQLException se){
		}finally{
			try{
				if(rs != null) rs.close();
			}catch(SQLException se){}
		}
		pw.println("</table>");
		pw.println("<hr width='600' size='2' noshade>");
		pw.println("<b>");
		pw.println("<a  href='update.do?seq="+seq+"'>수정</a>");
		pw.println("| ");
		pw.println("<a href='delete.do?seq="+seq+"'>삭제</a>");
		pw.println("| ");
		pw.println("<a href='list.do'>목록</a>");
		pw.println("</b>");
		pw.println("<hr width='600' size='2' noshade>");
		pw.println("</center>");	
	}
	public void destroy(){  
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se){}
		
	} 
}

