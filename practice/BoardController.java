import java.io.IOError;
import java.io.IOException;

import javax.lang.model.element.ModuleElement.RequiresDirective;

public class BoardController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String m = request.getParameter("m");
        if(m != null){
            switch(m){
                case "list": list(request, response); break;
                case "input": input(request, response); break;
                case "content": content(request, response); break;
                case "insert": insert(request, response); break;
                case "delete": delete(request, response); break;
                case "update": update(request, response); break;
                case "getupdate": getupdate(request, response); break;
            }
        }else{
            list(request, response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        BoardService service = BoardService.getInstance();
        ArrayList<Board> list = service.listS();
        request.setAttribute("list", list);

        String view = "list.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }
    
    private void input(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.sendRedirect("input.jsp");
    }

    private void content(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        BoardService service = BoardService.getInstance();
        int seq = getSeq(request);
        ArrayList<Board> contetn = service.contentS(seq);
        request.setAttribute("content", content);

        String view = "content.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        BoardService service = BaordService.getInstance();
        String writer = request.getParameter("writer");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        Board dto = new Board(-1, writer, email, subject, content, null);
        boolean flag = service.insertS(dto);
        request.setAttribute("flag", flag);

        String view = "insert.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forawrd(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        BoardService service = BoardService.getInstance();
        int seq = getSeq(request);
        service.deleteS(seq);

        response.sendRedirect("board.do");
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int seq = getSeq(request);
        BoardService service = Board.getInstance();
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        Board dto = new Board(seq, null, email, subject, content, null);
        service.updateS(dto);

        response.sendRedirect("board.do");
    }

    private void getupdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        BoardService service = BoardService.getInstance();
        int seq = getSeq(request);
        ArrayList<Board> getupdate = service.getUpdateS(seq);
        request.setAttribute("getupdate", getupdate);

        String view = "getupdate.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
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
                }catch(NumberFormatException ne){

                }
            }
        }
        return seq;
    }
}
