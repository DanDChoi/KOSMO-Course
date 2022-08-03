<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, mvc.domain.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Board update = (Board)request.getAttribute("update");
%>
	<meta charset='utf-8'>
	<style>
	table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	}
	th, td {
	padding: 5px;
	}
	a { text-decoration:none }
	</style>
	<body onload='javascript:document.f.email.focus();'>
	<center>
	<hr width='600' size='2' noshade>
	<h2>Simple Board with JSTL + EL</h2>
	<a href='../board/board.do?m=list'>글목록</a>
	<hr width='600' size='2' noshade>
	</center>
	<form name='f' method='post' action='../board/board.do?m=updatedo'>
	<input type='hidden' name='seq' value='${update.seq}'>
	<input type='hidden' name='writer' value='${update.writer}'>
	<table border='1' width='600' align='center' cellpadding='3' cellspacing='1'><tr>
	<td width='30%' align='center'>글쓴이</td>
	<td align='center'><input type='text' name='writer' size='60' value='${update.writer}' disabled></td>
	</tr>
	<tr>
	<td width='30%' align='center'>이메일</td>
	<td align='center'><input type='text' name='email' size='60' value='${update.email}'></td>
	</tr>
	<tr>
	<td width='30%' align='center'>글제목</td>
	<td align='center'><input type='text' name='subject' size='60' value='${update.subject}'></td>
	</tr>
	<tr>
	<td width='30%' align='center'>글내용</td>
	<td align='center'><textarea name='content' rows='5' cols='53'>${update.content}</textarea></td>
	</tr>
	<tr>
	<td colspan='2' align='center'>
	<input type='submit' value='수정'>
	</td>
	</tr>
	</table>
	</form>
	</body>