package join.jstl.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch (m) {
				case "joinForm" : joinForm(request, response); break;
			}
		}else {
			response.sendRedirect("../");
		}
	}
	private void joinForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "joinForm.jsp";
		response.sendRedirect(view);
	}
	private void join(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
