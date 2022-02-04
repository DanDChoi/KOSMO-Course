<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, bcm.board.domain.Board, bcm.member.domain.Member"%>

	<meta charset='utf-8'>
	<style>
	table, th, td {
	border: 1px solid black
	border-collapse: collapse;
	}
	th, td {
	padding: 5px;
	}
	a { text-decoration:none }
	</style>
	<center>
	<hr width='600' size='2' noshade>
	<h1>
	Board
	</h1>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='boardclient.do?b=input'>글쓰기</a>
	<hr width='600' size='2' noshade>
	<table border='1' width='600' align='center' cellpadding='3'>

<%		
		Board board = (Board)request.getAttribute("board");
		if(board != null){
%>
			<tr>
			<td width='100' align='center'>글번호</td>
			<td><%=board.getPostNumber()%></td>
			</tr>
			<tr>
			<td align='center'>글쓴이</td>
			<td><%=board.getWriterNickName()%></td>
			</tr>
			<tr>
			<td align='center'>이메일</td>
			<td><%=board.getWriterId()%></td>
			</tr>
			<tr>
			<td align='center'>글제목</td>
			<td><%=board.getPostSubject()%></td>
			</tr>
			<tr>
			<td align='center'>글내용</td>
			<td><%=board.getPostContent()%></td>
			</tr>
			<tr>
			<th width='100' align='center'>날짜</th>
			<td><%=board.getPdate()%></td>
			</tr>
<%			
		}
		Member member = (Member)session.getAttribute("user");
		String sessionId = member.getId();
		int sessionAuthority = member.getAuthority();
		String postId = board.getWriterId();
		boolean updateAuthority = false;
		boolean deleteAuthority = false;
		if(postId.equalsIgnoreCase(sessionId)){
			updateAuthority = true;
		}
		if(postId.equalsIgnoreCase(sessionId) || sessionAuthority==0 || sessionAuthority==1){
			deleteAuthority = true;
		}
%>

</table>
<hr width='600' size='2' noshade>
<b>
<a id="postUpdate" style="display:none;" href='boardclient.do?b=updateList&postNumber=<%=board.getPostNumber()%>'>수정</a>
<a id="postDelete" style="display:none; margin-left:15;" href='boardclient.do?b=delete&postNumber=<%=board.getPostNumber()%>'>삭제</a>
<a style="margin-left:15;" href='boardclient.do?b=list'>목록</a>
</b>
<hr width='600' size='2' noshade>
</center>
	<script language=javascript>
        if(<%=updateAuthority%>){
        	let postUpdate = document.getElementById('postUpdate');
        	postUpdate.style.display = 'inline-block';
    	}
        if(<%=deleteAuthority%>){
        	let postDelete = document.getElementById('postDelete');
        	postDelete.style.display = 'inline-block';
        }
    </script>