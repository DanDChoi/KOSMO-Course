<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%	
		boolean flag = (Boolean)request.getAttribute("idCheck");
		
%>
<script>
	
	if(<%= flag %>){
		alert("회원가입이 가능한 아이디입니다. (MVC) ");
	} else{
		alert("존재하는 아이디 입니다. ");
	}
	location.href="clientLoginS?m=joinIndex";
	
</script>