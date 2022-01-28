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
		int size = list.size();
		if (size == 0){
%>
            <tr>
				<td colspan="5" style="text-align:center">데이터가 하나도 없네요</td>
			 </tr>
<%    	
		}else{
			for(Board dto : list){
%>

			<tr>
				<td align='center'><%=dto.getSeq()%></td>
				<td align='center'><%=dto.getName()%></td>
				<td align='center'><%=dto.getEmail()%></td>
				<td align='center'><a href='content.jsp?seq=<%=dto.getSeq()%>'><%=dto.getSubject()%></a></td>
				<td><%=dto.getRdate()%></td>
			</tr>
<%    		
			}
		}
	}

%>

    </table>
<hr width='600' size='2' noshade>