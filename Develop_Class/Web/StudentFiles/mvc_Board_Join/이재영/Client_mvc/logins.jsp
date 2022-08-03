<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList , NoticeBoardClient.domain.BoardClientMember"%>
		





<%
	ArrayList<BoardClientMember> list = (ArrayList<BoardClientMember>)request.getAttribute("loginJ");
		System.out.println(""+list);
				if(list != null){
					int size = list.size();
						if(size != 0){
							for(BoardClientMember dto : list){
								String id = dto.getCid();
								String password = dto.getCpassword();
								String name = dto.getName();
								int Atu = dto.getAuthority();
								
								session.setAttribute("J_id", id);
								session.setAttribute("J_password", password);
								session.setAttribute("J_name", name);
								session.setAttribute("J_Atu", Atu);
								response.sendRedirect("../addr/boa.do");
							}
					}
			}else{
				response.sendRedirect("../Client_mvc/index.jsp");
			}	
%>
