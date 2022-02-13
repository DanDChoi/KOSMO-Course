<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, team1.togather.domain.GroupTab, team1.togather.domain.Gathering, team1.togather.*"%>
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
<%
	long gSeq = (Long)request.getAttribute("groupInfo_gSeq");
	System.out.println("groupInfo jsp안 : "+ gSeq);
%>
<center>
	<hr width='600' size='2' noshade>
	<h2>모임 정보</h2>
	<a href='groupTab.do?m=groupGetUpdate&gSeq=<%=gSeq%>'>모임 정보수정</a>
	&nbsp;&nbsp;&nbsp;
	<a href='groupTab.do?m=groupList'>모임 목록</a>
	<hr width='600' size='2' noshade>
	
	<table border='1' width='600' align='center' cellpadding='3'>
	<c:if test="${empty groupInfo}">
		<tr>
			<td colspan="5" style="text-align: center">데이터가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach items="${groupInfo}" var="groupTab">
		<tr>
			<td colspan="5" style="text-align: center" height="50">${groupTab.gName}</td>
		</tr>
		<tr>
			<td colspan="5" style="text-align: left" height="200">${groupTab.gIntro}</td>
		</tr>
		<tr>
			<td colspan="5" style="text-align: center" height="50"><a href="groupTab.do?m=gatheringList&gSeq=${groupTab.gSeq}">정모 목록</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" style="text-align: left" height="50">모임 멤버(n명)</td>
		</tr>
		<tr>
			<td colspan="5" style="text-align: left; border-bottom: hidden">멤버이름 갖고오기1</td>
		</tr>
		<tr>
			<td colspan="5" style="text-align: left; border-bottom: hidden">멤버이름 갖고오기2</td>
		</tr>
		<tr>
			<td colspan="5" style="text-align: left">멤버이름 갖고오기3</td>
		</tr>
	</table>
		<hr width='600' size='2' noshade>	
</center>
