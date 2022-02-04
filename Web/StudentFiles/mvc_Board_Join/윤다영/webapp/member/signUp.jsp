<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>

<%
	boolean flag = (Boolean)request.getAttribute("flag");
%>

<script>
	if(<%= flag %>){
		alert("회원가입에 성공했습니다.");
		//location.href="member.do";
	} else{
		alert("회원가입에 실패했습니다.");
		//location.href="member.do?m=signUp";
	}
	location.href="member.do";
</script>