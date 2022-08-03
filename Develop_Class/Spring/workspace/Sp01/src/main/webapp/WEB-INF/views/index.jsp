<%@ page contentType="text/html;charset=utf8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Sp01 Index</title>
	</head>
	<body style="text-align: center">
		<h1>
			Sp01 for Spring MVC Controller  
		</h1>
		
		<P>  
			<a href="/test">m01</a> 
			<a href="/test/base1">m02</a>
			<a href="/test/base2">m03</a>
			<a href="/test/base3">m04</a>  
			<a href="/test/form">폼</a>
		</P>
		<p>
			<a href="test/param1?na=홍길동&age=30">m5</a>
			<a href="test/param2?name=이순신&age=40">m6</a>
			<a href="test/param3?names=강감찬&names=이순신&names=유관순">m7</a>
			<a href="test/param4?ns=강감찬&ns=이순신&ns=유관순">m8</a>
			<a href="test/param5?names=강감찬&names=이순신&names=유관순">m9</a>
		</p>
		<p>
			<!--
			<a href="test/param6?list[0].name=이순신&list[0].age=40&list[1].name=홍길동&list[1].age=30">m10</a>
			 [ -> %5B
			 ] -> %5D
			  --> 
			 <a href="test/param6?list%5B0%5D.name=이순신&list%5B0%5D.age=40&list%5B1%5D.name=홍길동&list%5B1%5D.age=30&dump=KOSMO">m10</a>
			 <a href="test/param7?name=강강찬&age=25&dump=장군&s=10">m11</a>
			 <a href="test/param8?subject=크리스마스&cdate=2022/12/24 18:30:40">m12</a>
		</p>
		<p>
			<a href="addr/addr.do">주소록</a> <!-- 미션 -->
		</p>
	</body>
</html>
