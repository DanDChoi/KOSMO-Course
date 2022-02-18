<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
	table, th, td{
		border: 1px solid black;
		border-collapse: collapse;
	}
	th, td{
	padding: 5px;
	}
	a{ text-decoration: none}
</style>

<center>
	<h1>
		Sp01 Address
	</h1>
	<a href="../">인덱스</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="addr.do?m=input">입력폼</a>
	<table border='1' cellpadding='7' cellspacing='2' width='50%'>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>삭제</td>
		</tr>
	</table>
</center>
</body>
</html>