<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HelloP</title>
	</head>
	<body style="text-align: center">
		<h1>HelloP Index</h1>
		방갑다. 이클립스!!<br/>
		<a href="addr_dbcp/list.jsp">주소록</a>(withDBCP)<br/>
		<a href="board_dbcp/list.jsp">게시판</a>(withDBCP)<br/><br/> <!-- 미션 -->
		
		<a href="addr_mv/list.jsp">주소록</a>(MV모델)<br/> 
		<a href="board_mv/list.jsp">게시판</a>(MV모델)<br/><br/> <!-- 미션 --> 
		
		<a href="addr/addr.do">주소록</a>(MVC모델)<br/>
		<a href="board/board.do">게시판</a>(MVC모델)<br/><br/> <!-- 미션 -->
		
		<a href="">회원가입</a><br/>
		<a href="">로그인</a><br/><br/> 
		<!-- 세션접근법 
		   (1) jsp
		        session
		   (2) servlet 
		        HttpSession session = request.getSession(); 
		-->
		
	</body>
</html>