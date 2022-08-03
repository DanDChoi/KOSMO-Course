package member.mvc.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.mvc.model.MemberService;
import mvc.domain.Member;

import java.io.IOException;

@WebServlet("/member/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static HttpSession session;

	public MemberController() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m!=null) {
			m = m.trim();
			switch(m) {
				case "signUpForm": signUpForm(request, response); break;
				case "signUp": signUp(request, response); break;
				case "signIn": signIn(request, response); break;
				case "board" : board(request, response); break;
				case "signOut" : signOut(request, response); break;
			}
		} else {
			signInForm(request, response);
		}
		
	}
	
	protected void signInForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("signInForm.jsp");
	}
	protected void signUpForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("signUpForm.jsp");
	}
	
	protected void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		Member dto = new Member(-1, id, pwd, email, nickname, null);
		
		boolean flag = service.signUpInsertS(dto);
		request.setAttribute("flag", flag);
		
		String view = "signUp.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Member dto = new Member(id, pwd);
		
		boolean flag = service.signInS(dto);
		request.setAttribute("flag", flag);
		
		//setUserSession(request, response);
		Member user = service.getUserS(id);
		session = request.getSession();
		session.setAttribute("user", user);
		
		String view = "signIn.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void board(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../board_mvc/list.jsp");
	}
	
	protected void signOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session.removeAttribute("user");
		response.sendRedirect("/HelloP");
	}

} // end of class
