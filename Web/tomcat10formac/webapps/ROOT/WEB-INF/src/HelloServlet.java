package soo.sv;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

public class HelloServlet extends HttpServlet  
{
	public void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<center>");
		pw.println("Hi Servlet~^^ 한글도 지원되나?");
		pw.println("</center>");
	}
}
