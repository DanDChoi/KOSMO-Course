package soo.sv;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

public class LifeServlet extends HttpServlet  
{
	public void init(){ //첫번째 요청에 의해 메모리에 로딩될때 
		System.out.println("init()");
	}
	public void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException { //요청할때마다 
		System.out.println("service()");
	}
	public void destroy(){ //메모리에 언로딩될때( shutdown or 서버정책 )  
        System.out.println("destroy()");

		PrintWriter pw = null;
		FileWriter fw = null;
		try{
			fw = new FileWriter("log_destroy().txt");
			pw = new PrintWriter(fw, true);
			pw.println("destroy() 수행됨");
			pw.close();
			fw.close();
		}catch(IOException ie){}
	}
}
