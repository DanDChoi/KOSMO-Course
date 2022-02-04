<%@ page contentType="text/html;charset=utf-8"  import="java.util.ArrayList, bcm.member.domain.Member" %>


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
		<a href='boardclient.do?m='>글목록</a>
		<hr width='600' size='2' noshade>
		<form name='f' method='post' action='login.do?m=infoUpdateSet'>
<%
		Member member = (Member)request.getAttribute("member");
		if(member != null){
%>
			<input type='hidden' name='clientNember' value='<%=member.getClientNumber()%>'>
			<input type='hidden' name='infoId' value='<%=member.getId()%>'>
			<input type='hidden' name='infoName' value='<%=member.getNickName()%>'>
			<table border='1' width='600' align='center' cellpadding='3' cellspacing='1'><tr>
			<tr>
			<td width='30%' align='center'>ID</td>
			<td align='center'><input type='text' name='ii' size='60' value='<%=member.getId()%>' disabled></td>
			</tr>
			<tr>
			<td width='30%' align='center'>PASSWORD</td>
			<td align='center'><input type='text' name='infoPassword' size='60' value='<%=member.getPassword()%>'></td>
			</tr>
			<tr>
			<td width='30%' align='center'>닉네임</td>
			<td align='center'><input type='text' name='infoNickName' size='60' value='<%=member.getNickName()%>'></td>
			</tr>
			<tr>
			<td width='30%' align='center'>이름</td>
			<td align='center'><input type='text' name='in' size='60' value='<%=member.getName()%>' disabled></td>
			</tr>
			<tr>
			<td width='30%' align='center'>휴대폰번호</td>
			<td align='center'><input type='text' name='infoPhoneNumber' size='60' value='<%=member.getPhoneNumber()%>'></td>
			</tr>
			<tr>
			<td width='30%' align='center'>주소</td>
			<td align='center'><input type='text' name='infoAddress' size='60' value='<%=member.getAddress()%>'></td>
			</tr>
			<tr>
			<td width='30%' align='center'>가입날짜</td>
			<td align='center'><input type='text' name='infoCdate' size='60' value='<%=member.getCdate()%>'></td>
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