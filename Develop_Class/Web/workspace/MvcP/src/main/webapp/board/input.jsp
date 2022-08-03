<%@ page contentType="text/html;charset=utf-8" import="java.sql.*"%>

<html>
  <head>
    <title>간단한 게시판 with JSTL+EL</title>
	<meta charset='utf-8'>
	<script language="javascript">
	   function check()
	   {
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.writer.value == "" || 
	    		  document.input.email.value == "" || 
	    		  document.input.subject.value == "" ||
	    		  document.input.content.value == "")
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
	      <h2>Simple JSTL+EL BOARD</h2>
		  <a href='board.do'>글목록</a>
	   <hr width="600" size="2" noshade>
	</center>
	<form name="input" method="post" action="board.do?m=insert" enctype="multipart/form-data">
	   <table border="1" width="600" align="center"  cellpadding="3" cellspacing="1">
	      <tr>
		     <td width="30%" align="center">글쓴이(필수)</td>
			 <td align="center"><input type="text" name="writer" size="60"></td>
		  </tr>
		  <tr>
		     <td align="center">이메일(필수)</td>
			 <td align="center"><input type="text" name="email" size="60"></td>
		  </tr>
          <tr>
		     <td align="center">글제목(필수)</td>
			 <td align="center"><input type="text" name="subject" size="60"></td>
		  </tr>
		  <tr>
		     <td align="center">글내용(필수)</td>
			 <td align="center"><textarea name="content" rows="5" cols="53"></textarea></td>
		  </tr>
		  <tr>
		     <td align="center">파일업로드</td>
			 <td align="center"><input type="file" name="fname" size="60"></td>
		  </tr>

		  <tr>
		     <td colspan="2" align="center">
			    <input type="button" value="전송" onclick="check()">
				<input type="reset" value="다시입력">
			 </td>
		  </tr>
	   </table>
	   <br>
	   <hr width="600" size="2" noshade>
	</form>
  </body>
</html>