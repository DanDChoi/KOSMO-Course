<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, mvc.domain.Board"%>


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
<h2>Simple Board with MVC</h2>
&nbsp;&nbsp;&nbsp;
<a href="board.do?m=input">글쓰기</a>
&nbsp;&nbsp;&nbsp;
<a href="../">인덱스</a>
<hr width='600' size='2' noshade>
</center>
<table border='1' width='600' align='center' cellpadding='2'>
<tr>
<th align='center' width='10%'>글번호</th>
<th align='center' width='15%'>작성자</th>
<th align='center' width='30%'>이메일</th>
<th align='center' width='30%'>글제목</th>
<th align='center' width='15%'>날짜</th>
</tr>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	if(list != null){
%>
            <tr>
				<td colspan="5" style="text-align:center">서버에 문제발생</td>
			 </tr>
<%
	}else{
		int size = list.size();
		if (size == 0){
%>
            <tr>
				<td colspan="5" style="text-align:center">데이터가 하나도 없네요</td>
			 </tr>
<%    	
		}else{
			for(Board board : list){
%>

			<tr>
				<td align='center'><%=board.getSeq()%></td>
				<td align='center'><%=board.getName()%></td>
				<td align='center'><%=board.getEmail()%></td>
				<td align='center'>
				<a href='board.do?m=content&seq=<%=board.getSeq()%>'><%=board.getSubject()%></a></td>
				<td><%=board.getRdate()%></td>
			</tr>
<%    		
			}
		}
	}

%>

    </table>
<hr width='600' size='2' noshade>