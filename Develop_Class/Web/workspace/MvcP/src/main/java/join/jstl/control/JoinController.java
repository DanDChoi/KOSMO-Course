package join.jstl.control;

import static login.mvc.model.LoginConst.YES_ID_PWD;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import join.mvc.model.JoinService;
import login.mvc.model.LoginService;
import mvc.domain.Member;
import static join.mvc.model.JoinConst.*;

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
				case "join" :join(request, response); break;
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
	private void check(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String email = request.getParameter("id");
		String phone = request.getParameter("phone");
		//유효성 검사 (클라이언트측 View(JS), 서버측 Controller(java))
		
		JoinService service =  JoinService.getInstance();
		int result = service.check(email, phone);
		
		if(result == APPROVED) {
			Member m = service.getMemberS(email);
			HttpSession session = request.getSession();
			session.setAttribute("loginOkUser", m);
		}
		request.setAttribute("result", result);
		
		String view = "msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
