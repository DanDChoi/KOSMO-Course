<%@ page contentType="text/html;charset=utf-8" import="java.sql.*"%>
<jsp:useBean id="pool" class="soo.db.connectionPoolBean" scope="application"/>

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
<h2>Simple Board with jsp</h2>
&nbsp;&nbsp;&nbsp;
<a href='input.jsp'>글쓰기</a>
&nbsp;&nbsp;&nbsp;
<a href='../'>인덱스</a>
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
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from board order by seq desc";
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				Date rdate = rs.getDate(6);
%>
				<tr>
					<td align='center'><%=seq%></td>
					<td align='center'><%=name%></td>
					<td align='center'><%=email%></td>
					<td align='center'><a href='content.jsp?seq=<%=seq%>'><%=subject%></a></td>
					<td><%=rdate%></td>
				</tr>
<%
			}
		} catch (SQLException se) {
			System.out.println("#service() se: " + se);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
%>
    </table>
<hr width='600' size='2' noshade>