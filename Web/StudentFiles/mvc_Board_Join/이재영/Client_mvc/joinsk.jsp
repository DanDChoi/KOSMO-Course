<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%	
		boolean flag = true;
		
%>
<script>
	
	if(<%= flag %>){
		alert("모든 값 입력 및 비밀번호 확인(MVC)  ");
	} else{
		alert("모든 값 입력 및 비밀번호 확인(MVC) ");
	}
	location.href="../boardk/clientLogin?mesagge=join";
</script>