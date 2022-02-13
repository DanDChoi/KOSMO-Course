package team1.togather.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team1.togather.domain.Gathering;
import team1.togather.domain.GroupTab;
import team1.togather.model.GroupTabService;

@WebServlet("/group/groupTab.do")
public class GroupTabController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "groupList": groupList(request, response); break;
				case "groupInfo": groupInfo(request, response); break;
				case "groupInput": groupInput(request, response); break;
				case "groupInsert": groupInsert(request, response); break;
				case "groupGetUpdate": groupGetUpdate(request, response); break;
				case "groupUpdate": groupUpdate(request, response); break;
				case "gatheringList": gatheringList(request, response); break;
				case "gatheringInput": gatheringInput(request, response); break;
				case "gatheringInsert": gatheringInsert(request, response); break;
			}
		}else {
			response.sendRedirect("../");
		}
	}
	private void groupList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GroupTabService service = GroupTabService.getInstance();
		ArrayList<GroupTab> groupList = service.groupListS();
		request.setAttribute("groupList", groupList);
		
		String view = "groupList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void groupInfo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GroupTabService service = GroupTabService.getInstance();
		//long gSeq = getgSeq(request);
		long gSeq = Long.parseLong(request.getParameter("gSeq"));
		request.setAttribute("groupInfo_gSeq", gSeq);
		ArrayList<GroupTab> groupInfo = service.groupInfoS(gSeq);
		request.setAttribute("groupInfo", groupInfo);

		String view = "groupInfo.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void groupInput(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "groupInput.jsp";
		response.sendRedirect(view);
	}
	private void groupInsert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GroupTabService service = GroupTabService.getInstance();
		String gLoc = request.getParameter("gLoc");
		String gName = request.getParameter("gName");
		String gIntro = request.getParameter("gIntro");
		String interest = request.getParameter("interest");
		int limit = getLimit(request);
		GroupTab dto = new GroupTab(-1, gLoc, gName, gIntro, interest, limit, null, 1);
		boolean groupInsert = service.groupInsertS(dto);
		request.setAttribute("groupInsert", groupInsert);
		
		String view = "groupInsert.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void groupGetUpdate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GroupTabService service = GroupTabService.getInstance();
		long gSeq = getgSeq(request);
		ArrayList<GroupTab> groupGetUpdate = service.groupGetUpdateS(gSeq);
		request.setAttribute("groupGetUpdate", groupGetUpdate);
		
		String view = "groupgetupdate.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);	
	}
	private void groupUpdate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GroupTabService service = GroupTabService.getInstance();
		//long gSeq = getgSeq(request);
		long gSeq = Long.parseLong(request.getParameter("gSeq"));
		//request.setAttribute("groupUpdate_gSeq", gSeq);
		
		String gLoc = request.getParameter("gLoc");
		String gName = request.getParameter("gName");
		String gIntro = request.getParameter("gIntro");
		int limit = getLimit(request);
			System.out.println("gSeq(Controller) groupUpdate: " + gSeq);
			System.out.println("gName(Controller) groupUpdate: " + gName);
		
		GroupTab dto = new GroupTab(gSeq, gLoc, gName, gIntro, limit);
		service.groupUpdateS(dto);
		
		response.sendRedirect("groupTab.do?m=groupList");
	}
	private void gatheringInput(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long gSeq =Long.parseLong(request.getParameter("gSeq"));
		request.setAttribute("gatheringInput_gSeq", gSeq);
		String view = "gatheringInput.jsp";
		//response.sendRedirect(view);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void gatheringInsert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long gSeq =Long.parseLong(request.getParameter("gSeq"));
		request.setAttribute("gatheringInsert_gSeq", gSeq);
		
		System.out.println("gatherinsert ¾È gseq:"+ gSeq);
		GroupTabService service = GroupTabService.getInstance();
		String gt_name = request.getParameter("gt_name");
		String gt_date = request.getParameter("gt_date");
		String time = request.getParameter("time");
		String gt_place = request.getParameter("gt_place");
		String price = request.getParameter("price");
		int gt_limit = getGt_Limit(request);
		Gathering dto = new Gathering(-1, gt_name, gt_date, time, gt_place, price, gt_limit, gSeq);
		System.out.println(gt_name + gt_date + time + gt_place+ price+ gt_limit+", gSeq: " + gSeq);
		request.setAttribute("gatheringInsert", dto);
		service.gatheringInsertS(dto);
		
		response.sendRedirect("groupTab.do?m=gatheringList&gSeq=" + gSeq);
		//String view = "gatheringList.jsp";
		//RequestDispatcher rd = request.getRequestDispatcher(view);
		//rd.forward(request, response);
	}
	private void gatheringList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long gSeq =Long.parseLong(request.getParameter("gSeq"));
		System.out.println("gatheringList-gSeq: " + gSeq);
		request.setAttribute("gatheringList_gSeq", gSeq);
		
		GroupTabService service = GroupTabService.getInstance();
		ArrayList<Gathering> gatheringList = service.gatheringListS(gSeq);
		request.setAttribute("gatheringList", gatheringList);
		
		String view = "gatheringList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private long getgSeq(HttpServletRequest request){
		long seq = -1;
		String seqStr = request.getParameter("gSeq");
		System.out.println("gSeq: " + seqStr);
		if(seqStr != null){
			seqStr = seqStr.trim();
			if(seqStr.length() != 0){
				try{
					seq = Long.parseLong(seqStr);
					return seq;
				}catch(NumberFormatException nfe){
				}
			}
		}
		return seq;
	}
	private int getLimit(HttpServletRequest request){
		int limit = -1;
		String limitStr = request.getParameter("limit");
		if(limitStr != null){
			limitStr = limitStr.trim();
			if(limitStr.length() != 0){
				try{
					limit = Integer.parseInt(limitStr);
					return limit;
				}catch(NumberFormatException nfe){
				}
			}
		}
		return limit;
	}
	
	private int getGt_Limit(HttpServletRequest request){
		int gt_limit = -1;
		String gt_limitStr = request.getParameter("gt_limit");
		if(gt_limitStr != null){
			gt_limitStr = gt_limitStr.trim();
			if(gt_limitStr.length() != 0){
				try{
					gt_limit = Integer.parseInt(gt_limitStr);
					return gt_limit;
				}catch(NumberFormatException nfe){
				}
			}
		}
		return gt_limit;
	}
}
