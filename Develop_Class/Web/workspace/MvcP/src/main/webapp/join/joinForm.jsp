<%@ page contentType="text/html;charset=utf-8"%>

<meta charset="utf-8">

<script src="../js/trim.js"></script>
<script language="javascript"> 
    function check(){
		var nameval = f.name.value;
		nameval = trim(nameval);
		if(nameval.length == 0){
			alert("이름을 넣어주세요");
			f.name.value = "";
			f.name.focus();
			return false;
		}else{
			pass = checkByteLen(nameval, 30);
			if(!pass){
				alert("이름이 너무 길어요");
				f.name.focus();
				return false;
			}
		}
		
		var idval = f.id.value;
		idval = trim(idval);
		if(idval.length == 0){
			alert("아이디를 넣어주세요");
			f.id.value = "";
			f.id.focus();
			return false;
		}else{
			pass = checkByteLen(idval, 50);
			if(!pass){
				alert("아이디가 너무 길어요");
				f.id.focus();
				return false;
			}
		}
		
		var pwdval = f.pwd.value;
		pwdval = trim(pwdval);
		if(pwdval.length == 0){
			alert("비번을 넣어주세요");
			f.pwd.value = "";
			f.pwd.focus();
			return false;
		}else{
			pass = checkByteLen(pwdval, 30);
			if(!pass){
				alert("비번이 너무 길어요");
				f.pwd.focus();
				return false;
			}
		}

		var phoneval = f.phone.value;
		phoneval = trim(phoneval);
		if(phoneval.length == 0){
			alert("전화번호를 넣어주세요");
			f.phone.value = "";
			f.phone.focus();
			return false;
		}else{
			pass = checkByteLen(phoneval, 30);
			if(!pass){
				alert("전화번호가 너무 길어요");
				f.phone.focus();
				return false;
			}
		}

		f.submit();
	}

    function checkByteLen(str, size){
        var byteLen = getByteLen(str);
		if(byteLen <= size){
			return true;
		}else{
			return false;
		}
	}
	function getByteLen(str){
	   return str.replace(/[\0-\x7f]|([0-\u07ff]|(.))/g,"$&$1$2").length;
    }
	
	function enterCheck(elm){
		if(event.keyCode == 13){
			if(elm == f.id){
				f.pwd.focus();
			}else{
				check();
			}
		}
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
<body onload="document.f.id.focus()">
<center>
   <h1>
		회원가입
   </h1>
   <form name="f" action="join.do?m=check" method="post">
       <table border="1" width="400" height="500">
	      <tr>
		     <td width="20%" height="20%" colspan="2" align="center"><h2>입력폼</h2></td> 
		  </tr>
		  <tr>
		     <th width="20%">아이디<br/>(Email)</th> 
			 <td><input name="id" align="center" size="30" align="center" onkeydown="enterCheck(this)"></td>
		  </tr>
		  <tr>
		     <th width="30%">비밀번호</th> 
			 <td><input name="pwd" size="30" align="center" type="password" onkeydown="enterCheck(this)"></td>
		  </tr>
		  <tr>
		     <th width="30%">비밀번호확인</th> 
			 <td><input name="pwdcheck" size="30" align="center" type="password" onkeydown="enterCheck(this)"></td>
		  </tr>
		  <tr>
		     <th width="20%">이름</th> 
			 <td><input name="name" align="center" size="30" align="center" onkeydown="enterCheck(this)"></td>
		  </tr>		  
		  <tr>
		     <th width="25%">전화번호</th> 
			 <td><input name="phone" align="center" size="30" align="center" onkeydown="enterCheck(this)"></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			     <input type="button" value="가입하기" onclick="check()"/>
				 <input type="reset" value="취소" onclick="location.href='../'">
			 </td> 
		  </tr>
	   </table>
   </form>
</center>
</body>
