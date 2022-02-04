<%@ page contentType="text/html;charset=utf-8" %>

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
   <h1>회원가입</h1>
   <form name="f" action="member.do?m=signUp" method="post">
       <table border="1" width="600" height="200">
	      <tr>
		     <td width="20%" colspan="3" align="center"><h2>sign up</h2></td> 
		  </tr>
		  <tr>
		     <th width="20%">ID</th> 
			 <td width="35%"><input name="id" align="center" size="20" align="center"></td>
			 <td><span id="idCheck">id 중복확인<span>&nbsp;<input type="button" value="중복확인" name="id" size="20" onclick="location.href='member.do?m=idcheck'"></td>
		  </tr> <!-- js함수로 만들어서 컨츠롤러호출 -->
		  <tr>
		     <th width="20%">PassWord</th> 
			 <td width="35%"><input name="pwd" size="20" align="center"></td>
		  </tr>
		  <tr>
		     <th width="20%">Email</th> 
			 <td width="35%"><input name="email" align="center" size="20" align="center"></td>
			 <td><span id="emailCheck">email 중복확인<span>&nbsp;<input type="button" value="중복확인" name="email" size="20" onclick="location.href='member.do'"></td>
		  </tr>
		  <tr>
		     <th width="20%">NickName</th> 
			 <td width="35%"><input name="nickname" size="20" align="center"></td>
			 <td><span id="nicknameCheck">nickname 중복확인<span>&nbsp;<input type="button" value="중복확인" name="nickname" size="20" onclick="location.href='member.do'"></td>
		  </tr>
		  <tr>
		     <td colspan="3" align="center">
			     <input type="submit" value="회원가입"/>
				 <input type="reset" value="다시적기"/>
			 </td> 
		  </tr>
	   </table>
   </form>
</center>
</body>
