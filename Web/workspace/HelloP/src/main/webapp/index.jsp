<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HelloP</title>
	</head>
	<body style="text-align: center">
		<h1>Hello Project Index</h1>
		Nice to meet you, eclipse.<br/>
		<a href="addr_dbcp/list.jsp">주소록</a>(DBCP)<br/><br/>
		<a href="board_dbcp/list.jsp">게시판</a>(DBCP)<br/><br/>
		
		<a href="addr_mv/list.jsp">주소록</a>(MV Model)<br/><br/>
		<a href="board_mv/list.jsp">게시판</a>(MV Model)<br/><br/>
		
		<a href="addr/addr.do">주소록</a>(MVC Model)<br/>
		<a href="board/board.do">게시판</a>(MVC Model)<br/>	
	</body>
</html>