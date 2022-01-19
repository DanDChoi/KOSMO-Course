package soo.sv;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

public class HelloServlet extends HttpServlet{

    public void service(HttpsServletRequest req, HttpsServletResponse res)
        throws ServletException, IOException {
            res.setContentType("text/html;charset=utf-8");
            PrintWriter pw = res.getWriter();
            pw.println("<center>");
            pw.println("<h3 style='color:red'>Hi Servlet<h3>");
            pw.println("<a href='index.html' style='text-decoration:none'>¿Œµ¶Ω∫</a>");
            pw.println("</center>");
        }
}