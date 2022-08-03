<%@ page contentType="text/html;charset=utf-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Sp02 Index</title>
		<style>
			a{text-decoration:none}
		</style>
	</head>
	<body style="text-align:center">
		<h1>
			Sp02 for Spring MVC Model 
		</h1>
			
		<p>
		    <a href="address/list.do">주소록</a> <br/>
		    <a href="board/list.do">게시판</a> <br/>
		    <a href="file/list.do">파일리스트</a><br/><br><br/>
		    
		    <a href="board_file/list.do">파일게시판</a> <br/><br/> <!-- 미션 -->
		    
		    <a href="ajax/test01.do">ajax01</a>&nbsp;&nbsp;&nbsp;
		    <a href="ajax/test02.do">ajax02</a>&nbsp;&nbsp;&nbsp;
		    <a href="ajax/test03.do">ajax03</a>&nbsp;&nbsp;&nbsp;
		    <a href="ajax/test04.do">ajax04</a>&nbsp;&nbsp;&nbsp;
		    
		    <h3>Ajax 응용</h3>
		    <a href="file/form_dd.do">Drag&Drop</a>&nbsp;&nbsp;&nbsp;
		    <a href="auto/auto.do">자동완성</a>&nbsp;&nbsp;&nbsp;
		    <a href="chart/chart.do">Google Chart</a><br/><br/>
		    
		    <h3>RestFul(Address) 구축</h3>
            <a href="rest_addr/write.do">rest_addr/write.do</a><br/>
		   
		</p>
	</body>
</html>
