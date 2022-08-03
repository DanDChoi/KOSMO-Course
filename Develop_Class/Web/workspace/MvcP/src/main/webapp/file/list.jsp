<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset='utf-8'>

<center>
	<h1>
		File List MVC  
	</h1>
	<table border='1' cellpadding='7' cellspacing='2' width='50%'>
	    <tr>
		    <th>파일이름</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${kids}" var="kid">
	        <tr>
			    <th><a href="file.do?m=download&fname=${kid.name}">${kid.name}</a></th>
				<th><a href="file.do?m=del&fname=${kid.name}">삭제</a></th>
			</tr>
		</c:forEach>
		
    </table>
    <br/>
    <a href="file.do?m=form">업로드 폼</a>
    &nbsp;&nbsp;&nbsp;
    <a href="../">인덱스</a>
</center>	