<%@ page contentType="text/html; charset=utf-8" %>

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
   <h1>로그인</h1>
   
   <a href="member.do?m=signUpForm">회원가입</a>
   
   <form name="f" action="member.do?m=signIn" method="post">
       <table border="1" width="300" height="200">
	      <tr>
		     <td width="30%" colspan="2" align="center"><h2>sign in</h2></td> 
		  </tr>
		  <tr>
		     <th width="30%">ID</th> 
			 <td><input name="id" align="center" size="20" align="center"></td>
		  </tr>
		  <tr>
		     <th width="30%">PassWord</th> 
			 <td><input type="password" name="pwd" size="20" align="center"></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			     <input type="submit" value="로그인"/>
				 <input type="reset" value="다시적기"/>
			 </td> 
		  </tr>
	   </table>
   </form>
</center>
</body>
