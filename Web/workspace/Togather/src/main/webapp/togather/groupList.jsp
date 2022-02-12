<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, team1.togather.domain.GroupTab"%>
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
	<h2>모임 목록</h2>
	&nbsp;&nbsp;&nbsp;
	<a href='groupTab.do?m=groupInput'>모임 개설</a>
	&nbsp;&nbsp;&nbsp;
	<a href='../'>인덱스</a>
	<hr width='600' size='2' noshade>
</center>
<table border='1' width='600' align='center' cellpadding='2'>
	<tr>
		<th align='center' width='30%'>모임 이름</th>
		<th align='center' width='30%'>모임 소개</th>
		<th align='center' width='15%'>모임 지역</th>
		<th align='center' width='10%'>모임 정원</th>
	</tr>
	<c:if test="${empty groupList}">
		<tr>
			<td colspan="5" style="text-align: center">모임이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach items="${groupList}" var="groupTab">
		<tr>
			<td align='center'>
			<a href='groupTab.do?m=groupInfo&gSeq=${groupTab.gSeq}'>${groupTab.gName}</a>
			</td>
			<td align='center'>${groupTab.gIntro}</td>
			<td align='center'>${groupTab.gLoc}</td>
			<td align='center'>${groupTab.limit}</td>
		</tr>
	</c:forEach>
</table>
<hr width='600' size='2' noshade>
