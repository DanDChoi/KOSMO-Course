<%@ page language="java" contentType="text/html; charset=UTF-8" import="join.mvc.model.JoinConst"%>

<script>
	if(${result} == <%=JoinConst.EXIST_ID%>){
		alert("이미 존재하는 이메일입니다");
		location.href="join.do?m=form";
	}else if(${result} == <%=JoinConst.EXIST_PHONE%>){
		alert("이미 존재하는 전화번호입니다");
		location.href="join.do?m=form";
	}else{
		alert("회원가입 성공");
		location.href="../";
	}
</script>