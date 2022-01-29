package board.mvc.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvc.domain.Board;

import java.io.IOException;
import java.util.ArrayList;

import addr.mvc.model.BoardService;

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
				//case "insert" : insert(request, response); break;
				//case "delete" : delete(request, response); break;
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
	private void content(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long seq = getSeq(request);
		if(seq != -1) {
			BoardService service = BoardService.getInstance();
			Board board = service.contentS(seq);
			request.setAttribute("board", board);
			
			String view = "content.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			response.sendRedirect("board.do");
		}
	}
	private long getSeq(HttpServletRequest request) {
		long seq = -1;
		String seqStr = request.getParameter("Seq");
		if(seqStr != null) {
			seqStr = seqStr.trim();
			if(seqStr.length() != 0) {
				try {
					seq = Long.parseLong(seqStr);
					return seq;
				}catch(NumberFormatException ne) {
				}
			}
		}
		return seq;
	}
}
