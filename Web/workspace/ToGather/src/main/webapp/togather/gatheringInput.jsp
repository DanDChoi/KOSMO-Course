<%@ page contentType="text/html;charset=utf-8" import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>ToGather 모임 만들기</title>
	<meta charset='utf-8'>
	<script language="javascript">
	   function check()
	   {
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.gt_name.value == "" || 
	    		  document.input.gt_date.value == "" || 
	    		  document.input.time.value == "" ||
	    		  document.input.gt_place.value == "" ||
	    		  document.input.price.value == "" ||
	    		  document.input.gt_limit.value == "")
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
	      <h2>ToGather 모임 만들기</h2>
	 	 <a href='groupTab.do?m=groupList'>모임 목록</a>
	   <hr width="600" size="2" noshade>
	</center>
	<%
		//long gSeq= Long.parseLong(request.getParameter("gSeq"));
		long gSeq=(Long)request.getAttribute("gatheringInput_gSeq");
	    System.out.println("gthering jsp안 : "+ gSeq);
		
	%>
	<form name="input" method="post" action="groupTab.do?m=gatheringInsert&gSeq=<%=gSeq%>">
	   <table border="1" width="600" align="center"  cellpadding="3" cellspacing="1">
	   	  <tr>
			 <p align="center"><input type="text" name="gt_name" placeholder="정모 이름(*)" size="60"></p>
		  </tr>
	      <tr>
		    <p align="center"><input type="date" name="gt_date" placeholder="정모 날짜(*)" size="60"></p>
		  </tr>
		  <tr>
		    <p align="center"><input type="time" name="time" placeholder="정모 시간(*)" size="60"></p>
		  </tr>
          <tr>
			<p align="center">&#128205;<input type="text" name="gt_place" placeholder="정모 장소(*)"size="60"></p>
		  </tr>
		  <tr>
			 <p align="center"><input type="text" name="price" placeholder="식사비 15000원(*)" size="60"></p>
		  </tr>
		  <tr>
			 <p align="center">정원<input type="number" id="quantity" name="gt_limit" min="2" max="100" placeholder="(2~100)"></p>		
		  </tr>
		  <tr>
		     <p colspan="2" align="center">
			    <input type="submit" value="전송">
				<input type="reset" value="다시입력">
			 </p>
		  </tr>
	   </table>
	   <br>
	   <hr width="600" size="2" noshade>  
	</form>
	
  </body>
</html>