package soo.sv.board;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;

public class BoardServletUpdate extends HttpServlet {
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	String sql;

	public void init() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		String usr = "servlet";
		String pwd = "java";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, usr, pwd);
			stmt = con.createStatement();
			pstmt = con.prepareStatement(sql);
		} catch (ClassNotFoundException cbfe) {
			System.out.println("Oracle driver loading failed");
		} catch (SQLException se) {
			System.out.println("se: " + se);
		}
	}

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		String seqStr = req.getParameter("seq");
		String name = "";
		String email = "";
		String subject = "";
		String content = "";
		int seq = -1;
		if (seqStr != null) {
			seqStr = seqStr.trim();
			try {
				seq = Integer.parseInt(seqStr);
			} catch (Exception es) {
				res.sendRedirect("update.do");
			}
		}
		ResultSet rs = null;
		sql = "select * from board where seq =" + seq + " order by seq desc";
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				name = rs.getString(2);
				email = rs.getString(3);
				subject = rs.getString(4);
				content = rs.getString(5);
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
			pw.println("<h2>Update</h2>");
			pw.println("&nbsp;&nbsp;&nbsp;");
			pw.println("<a href='list.do'>글목록</a>");
			pw.println("<hr width='600' size='2' noshade>");
			pw.println("<form name='f' method='post' action='getupdate.do'>");

			pw.println("<input type='hidden' name='seq' value='" + seq + "'>");
			pw.println("<input type='hidden' name='writer' value=" + name + ">");
			pw.println("<table border='1' width='600' align='center' cellpadding='3' cellspacing='1'><tr>");
			pw.println("<td width='30%' align='center'>글쓴이</td>");
			pw.println(
					"<td align='center'><input type='text' name='name' size='60' value='" + name + "' disabled></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td width='30%' align='center'>이메일</td>");
			pw.println("<td align='center'><input type='text' name='email' size='60' value='" + email + "'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td width='30%' align='center'>글제목</td>");
			pw.println("<td align='center'><input type='text' name='subject' size='60' value='" + subject + "'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td width='30%' align='center'>글내용</td>");
			pw.println(
					"<td align='center'><textarea name='content' rows='5' cols='53'>" + content + "</textarea></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td colspan='2' align='center'>");
			pw.println("<input type='submit' value='수정'>");
			pw.println("</td>");
			pw.println("</tr>");

		} catch (Exception e) {
		}
		pw.println("<script>");
		pw.println("</script>");
	}

	public void destroy() {
		try {
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (SQLException se) {
		}
	}
}
