<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, team1.togather.domain.GroupTab"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>ToGather 모임 수정</title>
	<meta charset='utf-8'>
	<script language="javascript">
	   function check()
	   {
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.gName.value == "" || 
	    		  document.input.gIntro.value == "" || 
	    		  document.input.gLoc.value == "" ||
	    		  document.input.limit.value == "")
			  {
			     alert("필수입력란이 비었습니다.");
			     return false;
			  }
		   }
		   document.input.submit();
       }
	</script>
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
  </head>
  <body onload="input.name.focus()">
    <center>
	   <hr width="600" size="2" noshade>
	      <h2>ToGather 모임 수정</h2>
		  <a href='groupTab.do?m=groupList'>모임 목록</a>
	   <hr width="600" size="2" noshade>

<c:forEach items="${groupGetUpdate}" var="groupTab">
	<form name="f" method="post" action="groupTab.do?m=groupUpdate">
		<input type='hidden' name='gSeq' value='${groupTab.gSeq}'>
		<input type="hidden" name='interest' value='${groupTab.interest}'>
	   <table border="1" width="600" align="center"  cellpadding="3" cellspacing="1">
	   	  <tr>
			 <p align="center"><input type="text" name="interest" value='${groupTab.interest}' placeholder="모임의 관심사(*)" size="60" disabled></p>
		  </tr>
	      <tr>
		    <p align="center"><input type="text" name="gName" value='${groupTab.gName}' placeholder="모임 이름(*)" size="60"></p>
		  </tr>
		  <tr>
			 <p align="center">&#128172;<textarea name="gIntro" rows="5" cols="53">${groupTab.gIntro}</textarea></p>
		  </tr>
          <tr>
			<p align="center">&#128205;<input type="text" name="gLoc" value='${groupTab.gLoc}' placeholder="모임 지역(*)"size="60"></p>
		  </tr>
		  <tr>
			 <p align="center">&#128101;<input type="number" id="quantity" name="limit" min="2" max="100" value='${groupTab.limit}' placeholder="(2~100)"></p>		
		  </tr>
		  <tr>
		     <p colspan="2" align="center">
			    <input type="submit" value="수정">
				<input type="reset" value="다시입력">
			 </p>
		  </tr>
	   </table>
	   <br>
	   <hr width="600" size="2" noshade>
	</form>
	</c:forEach>
</center>
  </body>
</html>
