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

import board.mvc.model.BoardService;

@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch (m) {
				case "list": list(request, response); break;
				case "content": content(request, response); break;
				case "input": input(request, response); break;
			}
		}else {
			list(request, response);
		}
	}
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		ArrayList<Board> list = service.listS();
		request.setAttribute("list", list);
		
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	public void content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long seq = getSeq(request);
		if(seq != -1) {
			BoardService service = BoardService.getInstance();
			Board board = service.selectS(seq);
			request.setAttribute("board", board);
			
			String view = "content.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			response.sendRedirect("board.do");
		}
	}
	public void input(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("input.jsp");
	}
	
	private long getSeq(HttpServletRequest request){
        long seq = -1;
		String seqStr = request.getParameter("seq");
		if(seqStr != null){
			seqStr = seqStr.trim();
			if(seqStr.length() != 0){
				try{
					seq = Long.parseLong(seqStr);
					return seq;
				}catch(NumberFormatException ne){
				}
			}
		}

		return seq;
	}
}
