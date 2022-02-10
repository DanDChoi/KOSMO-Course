package team1.togather.control;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team1.togather.domain.GroupTab;
import team1.togather.model.GroupTabService;


@WebServlet("/togather/groupTab.do")
public class GroupTabController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if (m != null) {
			switch(m){
				case "groupList": groupList(request, response); break;
				case "groupCreate": groupCreate(request, response); break;
			}
		}else {
			response.sendRedirect("../");
		}
	}
	
	private void groupList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GroupTabService service = GroupTabService.getInstance();
		ArrayList<GroupTab> groupList = service.grouplistS();
		request.setAttribute("groupList", groupList);
		
		String view = "groupList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void groupCreate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		GroupTabService service = GroupTabService.getInstance();
		String gName = request.getParameter("gName");
		String gIntro = request.getParameter("gIntro");
		long mNum = Integer.parseInt(request.getParameter("mNum"));
		String gAddr = request.getParameter("gAddr");
		String time = request.getParameter("time");
		String interest = request.getParameter("interest");
		int limit = Integer.parseInt(request.getParameter("limit"));
		int price = Integer.parseInt(request.getParameter("price"));
		
	
	}
	private long getSeq(HttpServletRequest request) {
		int gSeq = -1;
		String gSeqStr = request.getParameter("gSeq");
		if(gSeqStr != null) {
			gSeqStr = gSeqStr.trim();
			if(gSeqStr.length() != 0) {
				try {
					gSeq = Integer.parseInt(gSeqStr);
					return gSeq;
				}catch(NumberFormatException ne) {
				}
			}
		}
		return gSeq;
	}
}
