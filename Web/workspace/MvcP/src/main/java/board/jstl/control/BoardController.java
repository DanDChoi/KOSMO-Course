package board.jstl.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;


import mvc.domain.Board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import board.mvc.model.BoardService;
import file.mvc.model.FileSet;

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
				case "update" : update(request, response); break;
				case "getupdate" : getupdate(request, response); break;
				case "download": download(request, response); break;
				case "delfile": delfile(request, response); break;
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
		
		String saveDir = FileSet.FILE_DIR;
		File fSaveDir = new File(saveDir);
		if(!fSaveDir.exists()) fSaveDir.mkdirs();
		
		int maxPostSize = 1*1024*1024;
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mr =null; 
		//MultipartRequest를 사용하면 모두 mr로 받아와야함. html from에 enctype="multipart/form-data" 반드시 추가할것
		try {
			mr = new MultipartRequest (request, saveDir, maxPostSize, "utf-8", policy);
		}catch(IOException ie) {
			System.out.println("업로드 실패: " + ie);
		}
		String writer = mr.getParameter("writer");
		String email = mr.getParameter("email");
		String subject = mr.getParameter("subject");
		String content = mr.getParameter("content");
		String fname = mr.getFilesystemName("fname");
		String ofname = mr.getOriginalFileName("fname");
		
		Board dto = new Board(-1, writer, email, subject, content, null, fname, ofname); 
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
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int seq = getSeq(request);
			System.out.println("seq: "+seq);
		String saveDir = FileSet.FILE_DIR;
		
		String fname = request.getParameter("fname"); //fname을 content.jsp에서 seq와 같이 받아옴
			System.out.println("fname: "+fname);
		File f = new File(saveDir, fname);
		if(f.exists()) f.delete();
		
		service.deleteS(seq);
		
		response.sendRedirect("board.do");
	}
	
	private void getupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		int seq = getSeq(request);
		ArrayList<Board> getupdate = service.getupdateS(seq);
		request.setAttribute("getupdate", getupdate);
		
		String view = "getupdate.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);	
	}
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardService service = BoardService.getInstance();
		
		String saveDir = FileSet.FILE_DIR;
		File fSaveDir = new File(saveDir);
		if(!fSaveDir.exists()) fSaveDir.mkdirs();
		
		int maxPostSize = 1*1024*1024;
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mr =null;
		try {
			mr = new MultipartRequest (request, saveDir, maxPostSize, "utf-8", policy);
		}catch(IOException ie) {
			System.out.println("업로드 실패: " + ie);
		}
		
		int seq = Integer.parseInt(mr.getParameter("seq"));
		//int seq = getSeq(request);
		System.out.println("seq: " + seq);
		
		String email = mr.getParameter("email");
		String subject = mr.getParameter("subject");
		String content = mr.getParameter("content");
		String fname = mr.getFilesystemName("fname");
		String ofname = mr.getOriginalFileName("fname");
		
		Board dto = new Board(seq, null, email, subject, content, null, fname, ofname);
		service.updateS(dto);
		
		response.sendRedirect("board.do");
	}
	
	private void download(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String saveDir = FileSet.FILE_DIR;
		String fname = request.getParameter("fname");
		File f = new File(saveDir, fname);
		
		response.setContentType("application/octet-stream"); //브라우저에게 다운로드 준비요청
		String Agent=request.getHeader("USER-AGENT");
		if( Agent.indexOf("MSIE") >= 0 ){
			int i = Agent.indexOf( 'M', 2 );
			String IEV = Agent.substring( i + 5, i + 8 );
			if( IEV.equalsIgnoreCase("5.5") ){
				response.setHeader("Content-Disposition", "filename=" + new String( fname.getBytes("utf-8"), "8859_1") );
			}else{
				response.setHeader("Content-Disposition", "attachment;filename="+new String(fname.getBytes("utf-8"),"8859_1"));
			}
		}else{
			response.setHeader("Content-Disposition", "attachment;filename=" + new String( fname.getBytes("utf-8"), "8859_1") );
		}

		if(f.exists() && f.isFile()) {
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			OutputStream os = null;
			try {
				fis = new FileInputStream(f); //data source (서버측파일)
				bis = new BufferedInputStream(fis, 2048);
				os = response.getOutputStream();//data destination (클라이언트)
				bos = new BufferedOutputStream(os, 2048);

				int count = 0;
				byte b[] = new byte[1024];
				while((count = bis.read(b)) != -1) {
					bos.write(b, 0, count);
				}
				bos.flush();
			}catch(IOException ie) {
			}finally {
				try {
					if(bos != null) bos.close();
					if(bis != null) bis.close();
					if(fis != null) fis.close();
					if(os != null) os.close();
				}catch(IOException ie) {}
			}
		}
	}
	private void delfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		
		String saveDir = FileSet.FILE_DIR;
		String fname = request.getParameter("fname");
			System.out.println("fname: "+fname);
		File f = new File(saveDir, fname);
		if(f.exists()) f.delete();
		
		int seq = getSeq(request);
			System.out.println("seq: "+seq);
		ArrayList<Board> delfile = service.delfileS(seq);
		request.setAttribute("delfile", delfile);
		
		String view = "getupdate.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);	
		
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
