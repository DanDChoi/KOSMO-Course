<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, soo.mv.model.BoardDTO"%>
<jsp:useBean id="boardDAO" class="soo.mv.model.BoardDAO" scope="application"/>
<jsp:useBean id="dto" class="soo.mv.model.BoardDTO"/>
<jsp:setProperty name="dto" property="*"/>

<%
	String seqStr = request.getParameter("seq");
	String writer = request.getParameter("name");
	int seq =  Integer.parseInt(seqStr);
	  ArrayList<BoardDTO> lists = boardDAO.contents(seq);
	if(lists != null){
		int size = lists.size();
		if(size !=0){
			for(BoardDTO dtos : lists){
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
<center>
<hr width='600' size='2' noshade>
<h2>Simple Board with mv</h2>
&nbsp;&nbsp;&nbsp;
<a href='input.jsp'>글쓰기</a>
<hr width='600' size='2' noshade>
<table border='1' width='600' align='center' cellpadding='3'>

<tr>
<td width='100' align='center'>글번호</td>
<td><%=dto.getSeq()%></td>
</tr>
<tr>
<td align='center'>글쓴이</td>
<td><%=dto.getName()%></td>
</tr>
<tr>
<td align='center'>이메일</td>
<td><%=dto.getEmail()%></td>
</tr>
<tr>
<td align='center'>글제목</td>
<td><%=dto.getSubject()%></td>
</tr>
<tr>
<td align='center'>글내용</td>
<td><%=dto.getContent()%></td>
</tr>

</table>
<%
			}
		}
%>
<hr width='600' size='2' noshade>
<b>

<a  href='update.jsp?seq=<%=dto.getSeq()%>'>수정</a>
 | 
<a href='delete.jsp?seq=<%=dto.getSeq()%>'>삭제</a>
	<%} %>
 | 
<a href='list.jsp'>목록</a>
</b>
<hr width='600' size='2' noshade>
</center>
