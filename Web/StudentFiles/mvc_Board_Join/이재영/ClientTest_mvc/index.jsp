<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta charset="utf-8">
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
<body onload="document.f.name.focus()">

<center>
   <h1>
		Logins~ MVC
   </h1>
   
   <form name="f" action="../boardk/clientLoginS?m=logins" method="post">
       <table border="1" width="300" height="200">
	      <tr>
		     <td width="30%" colspan="2" align="center"><h2>로그인</h2></td> 
		  </tr>
		  <tr>
		     <th width="30%">아이디</th> 
			 <td><input name="id" align="center" size="20" align="center" placeholder="id"></td>
		  </tr>
		  <tr>
		     <th width="30%">비밀번호</th> 
			 <td><input type="password" name="password" size="20" align="center" placeholder="password"></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			     <input type="submit" value="전송"/>
				 <input type="reset" value="취소"/>
			 </td> 
		  </tr>
	   </table>
   </form>
   <a href='../boardk/clientLoginS?m=joinIndex'>회원가입</a>
</center>
</body>