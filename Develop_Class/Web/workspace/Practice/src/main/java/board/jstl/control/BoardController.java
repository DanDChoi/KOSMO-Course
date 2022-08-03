package board.jstl.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.mvc.model.BoardService;
import mvc.domain.Board;

@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			switch(m) {
			case "list" : list(request, response); break;
			}
		}else {
			list(request, response);
		}
	}
	
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		BoardService service = BoardService.getInstance();
		ArrayList<Board> list = service.listS();
		request.setAttribute("list", list);
		
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}

}
