<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, mvc.domain.Address"%>

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
	<h1>
		Address List MVC
	</h1>
	<a href="../">인덱스</a>
	   &nbsp;&nbsp;&nbsp;&nbsp; 
	<a href="addr.do?m=input">입력폼</a>
	<table border='1' cellpadding='7' cellspacing='2' width='50%'>
	    <tr>
		    <th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>
<%
	ArrayList<Address> list = (ArrayList<Address>)request.getAttribute("list");
	if (list != null){
		int size = list.size();
		if(size == 0){
%>
             <tr>
				<td colspan="5" style="text-align:center">데이터가 하나도 없네요</td>
			 </tr>
<%			
		}else{
			for(Address dto : list){
%>
               <tr>
				<td align='center'><%=dto.getSeq()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getAddr()%></td>
				<td><%=dto.getRdate()%></td>
				<td align='center'><a href='addr.do?m=del&seq=<%=dto.getSeq()%>'>삭제</a></td>
			</tr>
<%			
			}
		}
	}
%>
                   
	</table>
</center>