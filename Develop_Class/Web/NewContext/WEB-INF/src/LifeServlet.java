package soo.sv;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

public class LifeServlet extends HttpServlet  
{
	public void init(){ //ù��° ��û�� ���� �޸𸮿� �ε��ɶ� 
		System.out.println("init()");
	}
	public void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException { //��û�Ҷ����� 
		System.out.println("service()");
	}
	public void destroy(){ //�޸𸮿� ��ε��ɶ�( shutdown or ������å )  
        System.out.println("destroy()");

		PrintWriter pw = null;
		FileWriter fw = null;
		try{
			fw = new FileWriter("log_destroy().txt");
			pw = new PrintWriter(fw, true);
			pw.println("destroy() �����");
			pw.close();
			fw.close();
		}catch(IOException ie){}
	}
}
