<%@ page language="java" contentType="text/html; charset=UTF-8" import="login.mvc.model.LoginConst"%>

<script>
	if(${result} == <%=LoginConst.NO_ID%>){
		alert("아이디가 없습니다");
		location.href="login.do?m=form";
	}else if(${result} == <%=LoginConst.NO_PWD%>){
		alert("비밀번호가 맞지 않습니다");
		location.href="login.do?m=form";
	}else{
		alert("로그인 성공");
		location.href="../";
	}
</script>