package file.mvc.control;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import file.mvc.model.FileSet;

@WebServlet("/file/file.do")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch (m) {
					case "list": list(request, response); break;		
					case "form": form(request, response); break;
					case "upload": upload(request, response); break;
					case "del": del(request, response); break;
					case "download": download(request, response); break;
				}
		}else {
			list(request, response);
		}

	}

	private void form(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "form.jsp";
		response.sendRedirect(view);
	}
	private void upload(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//ServletContext application = getServletcontext();
		//String saveDir = application.getRealPath("/file/aaa"); 이렇게도 할 수 있지만 파일 경로가 너무 깊음
		String saveDir = FileSet.FILE_DIR;
		File fSaveDir = new File(saveDir); //file이 없는경우 file을 만듦
		if(!fSaveDir.exists()) fSaveDir.mkdirs(); //file이 없는경우 file을 만듦
		
		int maxPostSize = 1*1024*1024; //최대 파일업로드 가능 용량 지정
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest (request,
					saveDir,
					maxPostSize, //최대 파일업로드 가능 용량 지정
					"utf-8",
					policy);
		}catch(IOException ie) {
			System.out.println("업로드 실패: " + ie);
		}
		String writer = mr.getParameter("writer");
		String fname = mr.getFilesystemName("fname");
		String ofname = mr.getOriginalFileName("fname");
		System.out.println("업로드된 파일의 정보: writer:"+writer+", fname:"+fname+", ofname: "+ofname );
		
		String view = "file.do";
		response.sendRedirect(view);
	}
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String saveDir = FileSet.FILE_DIR;
		File fSaveDir = new File(saveDir);
		File kids[] = fSaveDir.listFiles();
		request.setAttribute("kids", kids);
		
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void del(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String saveDir = FileSet.FILE_DIR;
		String fname = request.getParameter("fname");
		File f = new File(saveDir, fname);
		if(f.exists()) f.delete();
		
		String view = "file.do";
		response.sendRedirect(view);
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
}