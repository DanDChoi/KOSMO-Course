<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	boolean flag = (Boolean)request.getAttribute("flag");
%>

<script>
	if(<%= flag %>){
		alert("로그인 성공");
		location.href="../board_mvc/board.do?";
	} else{
		alert("id와 password를 확인해주세요.");
		location.href="member.do";
	}
</script>