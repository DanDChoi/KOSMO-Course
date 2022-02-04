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
		<h1>MvcP Index</h1>
		
		<a href="addr/addr.do">주소록</a>(JSTL+EL)<br/>
		 
		<a href="board/board.do">게시판</a>(JSTL+EL)<br/> <!-- 미션 -->
		
		<br/>
		
		<a href="">회원가입</a><br/><br/>
		
		<c:choose>
		   <c:when test="${empty loginOkUser}">
		      <a href="login/login.do?m=form">로그인</a>
		   </c:when>
		   <c:otherwise>
		      <font style="color:green">${loginOkUser.name}</font>님 환영합니다<br/>
		      <a href="login/login.do?m=logout">로그아웃</a>
		   </c:otherwise>
		</c:choose>
		
		
	</body>
</html>