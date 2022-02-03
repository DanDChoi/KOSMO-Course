package addr.jstl.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.domain.Board;

import java.io.IOException;
import java.util.ArrayList;

import addr.mvc.model.BoardService;

@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if (m != null) {
			m = m.trim();
			switch (m) {
			case "list":
				list(request, response);
				break;
			case "input":
				input(request, response);
				break;
			case "insert":
				insert(request, response);
				break;
			case "content":
				content(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "update":
				update(request, response);
				break;
			case "updatedo":
				updatedo(request, response);
				break;

			}
		} else {
			list(request, response);
		}
	}

	protected void input(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("input.jsp");
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1)Model 핸들링(java)
		BoardService service = BoardService.getInstance();
		ArrayList<Board> list = service.listS();
		request.setAttribute("list", list); // list란 객체로 등록

		// 2)View지정(jsp)
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		String name = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Board dto = new Board(-1, name, email, subject, content, null);
		boolean insert = service.insertS(dto);
		request.setAttribute("insert", insert);

		String view = "insert.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int seq = getSeq(request);
		service.delS(seq);
		
		response.sendRedirect("board.do");
	}
	
	private int getSeq(HttpServletRequest request){
		int seq = -1;
		String seqStr = request.getParameter("seq");
		if(seqStr != null){
			seqStr = seqStr.trim();
			if(seqStr.length() != 0){
				try{
				seq = Integer.parseInt(seqStr); 
					return seq;
					}catch(NumberFormatException ne){}	
			}
		}
			return seq;
	}
	
	public void content(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int seq = getSeq(request);
		Board content = service.contentS(seq);
		request.setAttribute("content", content);
		
		String view = "content.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int seq = getSeq(request);
		Board update = service.updateS(seq);
		request.setAttribute("update", update);
		
		String view = "update.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	public void updatedo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int seq = getSeq(request);
		String name = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Board dto = new Board(seq, name, email, subject, content, null);
		service.updatedoS(dto);
		
		response.sendRedirect("board.do");
	}
}
