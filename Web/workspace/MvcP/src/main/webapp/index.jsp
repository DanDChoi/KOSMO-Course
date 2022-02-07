<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<link rel="stylesheet" href="css/style.css">
		<title>Mvc Project</title>
	</head>
	<body style="text-align: center">
		<section class="center">
		<div>
			<h1 id="clock">00:00:00</h1>
		</div>
			<h2 id="title">Mvc Project Index</h2>
		<div id ="list">
			<a href="addr/addr.do" style="text-decoration:none;">주소록</a>(JSTL+EL)<br/>
			<br/>
			<a href="board/board.do" style="text-decoration:none;">게시판</a>(JSTL+EL)<br/>
			<br/>
			<a href="file/file.do" style="text-decoration:none;">파일리스트</a><br/>	
		</div>
			<br/>
				
			<a id="join" href="join/join.do?m=joinForm" style="text-decoration:none;,">회원가입</a><br/><br/>
		<c:choose>
			<c:when test="${empty loginOkUser}">
				<a id="login" href="login/login.do?m=form"style="text-decoration:none;">로그인</a>
			</c:when>
			<c:otherwise>
				<a id="welcome">
				<font style="color:cornsilk"><b>${loginOkUser.name}</b></font> 님 환영합니다 :)<br/>
				</a>
				<a id="logout" href="login/login.do?m=logout" style="text-decoration:none;">로그아웃</a>
			</c:otherwise>					
		</c:choose>
		
		</section>
		    <script src="js/clock.js"></script>
		    <script src="js/background.js"></script>
		   
	</body>
</html>

		<!-- 세션접근법 
		   (1) jsp
		        session
		   (2) servlet 
		        HttpSession session = request.getSession(); 
		-->