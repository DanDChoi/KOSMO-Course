<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList , ClientTest.domain.ClientMembers"%>
		





<%
	ArrayList<ClientMembers> list = (ArrayList<ClientMembers>)request.getAttribute("loginJ");
		System.out.println(""+list);
				if(list != null){
					int size = list.size();
						if(size != 0){
							for(ClientMembers dto : list){
								String id = dto.getId();
								String password = dto.getPassword();
								String name = dto.getName();
								String power = dto.getPower();
								String nickName = dto.getNickName();
								String email = dto.getEmail();
								session.setAttribute("J_id", id);
								session.setAttribute("J_password", password);
								session.setAttribute("J_name", name);
								session.setAttribute("J_nickName", nickName);
								session.setAttribute("J_email", email);
								session.setAttribute("J_power", power);
								response.sendRedirect("../addr/boa.do");
							}
					}
			}else{
				response.sendRedirect("../ClientTest_mvc/index.jsp");
			}	
%>
