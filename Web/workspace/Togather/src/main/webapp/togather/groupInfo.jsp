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
	<h2>모임 정보</h2>
	&nbsp;&nbsp;&nbsp;
	<!--  <a href='board.do?m=input'>글쓰기</a>-->
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
			<td colspan="5" style="text-align: center" height="50"><a href="">정모 목록</a></td>
		</tr>
		<tr>
			<td rowspan="4" style="text-align: center">정모날짜</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="4">정모날짜 + 시간</td>
		</tr>
		<tr>
			<td></td>
			<td>정모장소</td>
		</tr>
		<tr>
			<td></td>
			<td>정모가격</td>
		</tr>
		<tr>
			<td colspan="5" style="text-align:center">(특정날짜)정모참석자(n명)</td>
		</tr>
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
		<b>
			<a  href='groupTab.do?m=groupGetUpdate&gSeq=${groupTab.gSeq}'>수정</a>
			 | 
			<a href='groupTab.do?m=del&gSeq=${groupTab.gSeq}'>삭제</a>
			 | 
			<a href='groupTab.do?m=groupList'>목록</a>
		</b>
		<hr width='600' size='2' noshade>
	</c:forEach>
</center>
