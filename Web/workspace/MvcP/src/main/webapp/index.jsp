<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MvcP</title>
	</head>
	<body style="text-align: center">
		<h1>Mvc Project Index</h1>
		
		<a href="addr/addr.do">주소록</a>(JSTL+EL)<br/>
		<a href="board/board.do">게시판</a>(JSTL+EL)<br/>	
		
		<br/>
		<a href="">회원가입</a><br/>
		<a href="">로그인</a><br/>
		<!-- 세션접근법 
		   (1) jsp
		        session
		   (2) servlet 
		        HttpSession session = request.getSession(); 
		-->
	</body>
</html>