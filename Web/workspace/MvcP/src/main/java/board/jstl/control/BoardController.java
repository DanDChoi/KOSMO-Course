package board.jstl.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import addr.mvc.model.AddrService;
import mvc.domain.Address;
import mvc.domain.Board;
import java.io.IOException;
import java.util.ArrayList;
import board.mvc.model.BoardService;

@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if (m != null) {
			switch(m) {
				case "list": list(request, response); break;
				case "input" : input(request, response); break;
				case "content" : content(request, response); break;
				case "insert" : insert(request, response); break;
				case "delete" : delete(request, response); break;
			}
		}else {
			list(request, response);
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//(1)Model Handling (java)
		BoardService service = BoardService.getInstance(); 
		ArrayList<Board> list = service.listS();
		request.setAttribute("list", list);
		
		//(2)Designate view (JSP)
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void input(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("input.jsp");
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//(1) Model 핸들링 (java)
		BoardService service = BoardService.getInstance();
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Board dto = new Board(-1, writer, email, subject, content, null); 
		boolean flag = service.insertS(dto);
		request.setAttribute("flag", flag);
		
		//(2) View 지정 (JSP)
		String view = "insert.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void content(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int seq = getSeq(request);
		ArrayList<Board> content = service.contentS(seq);
		request.setAttribute("content", content);
		//request.setAttribute("seq", seq);
		
		String view = "content.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int seq = getSeq(request);
		service.deleteS(seq);
		
		response.sendRedirect("board.do");
	}

	
	private int getSeq(HttpServletRequest request) {
		int seq = -1;
		String seqStr = request.getParameter("seq");
		if(seqStr != null) {
			seqStr = seqStr.trim();
			if(seqStr.length() != 0) {
				try {
					seq = Integer.parseInt(seqStr);
					return seq;
				}catch(NumberFormatException ne) {
				}
			}
		}
		return seq;
	}

}
