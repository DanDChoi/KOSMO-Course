<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, mvc.domain.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<center>
<hr width='600' size='2' noshade>
<h2>Simple Board with JSTL+EL</h2>
&nbsp;&nbsp;&nbsp;
<a href='board.do'>글목록</a>
<hr width='600' size='2' noshade>
<c:if test="${empty getupdate}">
	<tr>
		<td colspan="5" style="text-align:center">데이터가 없습니다</td>
	</tr>
</c:if>
<c:forEach items="${getupdate}" var="board">
	<form name='f' method='post' action='board.do?m=update' enctype="multipart/form-data">
		<input type='hidden' name='seq' value='${board.seq}'>
		<input type='hidden' name='writer' value='${board.writer}'>
		<table border='1' width='600' align='center' cellpadding='3' cellspacing='1'>
			<tr>
				<td width='30%' align='center'>글쓴이</td>
				<td align='center'><input type='text' name='aa' size='60' value='${board.writer}' disabled></td>
			</tr>
			<tr>
				<td width='30%' align='center'>이메일</td>
				<td align='center'><input type='text' name='email' size='60' value='${board.email}'></td>
			</tr>
			<tr>
				<td width='30%' align='center'>글제목</td>
				<td align='center'><input type='text' name='subject' size='60' value='${board.subject}'></td>
			</tr>
			<tr>
				<td width='30%' align='center'>글내용</td>
				<td align='center'><textarea name='content' rows='5' cols='53'>${board.content}</textarea></td>
			</tr>
			<tr>
				<td width='30%' align='center'>파일</td>
				<td align='center'>${board.fname}<input type='button' value='파일삭제' onclick="location.href='board.do?m=delfile&seq=${board.seq }';">
				<br/>
				<input type="file" name='fname' value='${board.fname}'></td>
			</tr>
			<tr>
				<td colspan='2' align='center'>
					<input type='submit' value='수정'>
				</td>
			</tr>
		</table>
	</form>
</c:forEach>
</center>
