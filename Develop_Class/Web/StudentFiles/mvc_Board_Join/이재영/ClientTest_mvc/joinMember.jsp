<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	boolean flags = (Boolean)request.getAttribute("joinMember");
%>
<script>
	
	if(<%= flags %>){
		alert("회원가입 성공. (MVC) ");
		location.href="../ClientTest_mvc";
	} else{
		alert("회원가입 실패. (MVC) ");
		location.href="clientLoginS?m=joinIndex";
	}
</script>