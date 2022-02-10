package team1.togather.control;

import java.io.IOException;
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

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "groupList": groupList(request, response); break;
				case "groupInfo": groupInfo(request, response); break;
				case "groupInput": groupInput(request, response); break;
				case "groupCreate": groupCreate(request, response); break;
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
		long gSeq = getSeq(request);
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
	private void groupCreate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GroupTabService service = GroupTabService.getInstance();
		String gName = request.getParameter("gName");
		String gIntro = request.getParameter("gIntro");
		String gAddr = request.getParameter("gAddr");
		String time = request.getParameter("time");
		String interest = request.getParameter("interest");
		int limit = getLimit(request);
		int price = getPrice(request);
		System.out.println("price: " + price);
		GroupTab dto = new GroupTab(-1, gName, gIntro, 1, gAddr, time, interest, limit, price, null);
		boolean gCreate = service.groupCreateS(dto);
		request.setAttribute("gCreate", gCreate);
		
		String view = "groupInsert.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private long getSeq(HttpServletRequest request){
		long seq = -1;
		String seqStr = request.getParameter("gSeq");
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
	private int getPrice(HttpServletRequest request){
		int price = -1;
		String priceStr = request.getParameter("price");
		if(priceStr != null){
			priceStr = priceStr.trim();
			if(priceStr.length() != 0){
				try{
					price = Integer.parseInt(priceStr);
					return price;
				}catch(NumberFormatException nfe){
				}
			}
		}
		return price;
	}
	
	private void gatheringUpdate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GatheringService service = GatheringService.getInstance();
		String gName = request.getParameter("gName");
		String gIntro = request.getParameter("gIntro");
		String gAddr = request.getParameter("gAddr");
		String time = request.getParameter("time");
		String interest = request.getParameter("interest");
		int limit = getLimit(request);
		int price = getPrice(request);
		System.out.println("price: " + price);
		GroupTab dto = new GroupTab(-1, gName, gIntro, 1, gAddr, time, interest, limit, price, null);
		boolean gCreate = service.groupCreateS(dto);
		request.setAttribute("gCreate", gCreate);
		
		String view = "groupInsert.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
