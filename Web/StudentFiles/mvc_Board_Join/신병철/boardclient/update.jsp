<%@ page contentType="text/html;charset=utf-8"  import="java.util.ArrayList, bcm.board.domain.Board" %>


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
		<h2>Board</h2>
		&nbsp;&nbsp;&nbsp;
		<a href='boardclient.do'>글목록</a>
		<hr width='600' size='2' noshade>
		<form name='f' method='post' action='boardclient.do?b=update'>

<%
		Board board = (Board)request.getAttribute("board");
		if(board != null){
%>
			<input type='hidden' name='postNumber' value='<%=board.getPostNumber()%>'>
			<input type='hidden' name='writerId' value='<%=board.getWriterId()%>'>
			<input type='hidden' name='writerNickName' value='<%=board.getWriterNickName()%>'>
			<table border='1' width='600' align='center' cellpadding='3' cellspacing='1'><tr>
			<td width='30%' align='center'>글쓴이</td>
			<td align='center'><input type='text' name='wnn' size='60' value='<%=board.getWriterNickName()%>' disabled></td>
			</tr>
			<tr>
			<td width='30%' align='center'>글제목</td>
			<td align='center'><input type='text' name='postSubject' size='60' value='<%=board.getPostSubject()%>'></td>
			</tr>
			<tr>
			<td width='30%' align='center'>글내용</td>
			<td align='center'><textarea name='postContent' rows='5' cols='53'><%=board.getPostContent()%></textarea></td>
			</tr>
<%
		}else{
%>
			<tr>
				<td colspan="5" style="text-align:center">데이터가 하나도 없어요</td>
			</tr>
<%
		}
%>
	<tr>
	<td colspan='2' align='center'>
	<input type='submit' value='수정'>
	</td>
	</tr>
	</table>
	</form>
	</table>