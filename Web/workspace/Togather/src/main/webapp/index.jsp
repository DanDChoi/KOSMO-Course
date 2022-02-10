<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Togather</title>
	</head>
	<body style="text-align: center">
		<section class="center">

			<h2 id="title">Togather</h2>
		<div id ="list">
			<a href="togather/groupTab.do?m=groupList"">모임</a><br/>	
		</div>
			<br/>
		
		</section>

		   
	</body>
</html>

		<!-- 세션접근법 
		   (1) jsp
		        session
		   (2) servlet 
		        HttpSession session = request.getSession(); 
		-->