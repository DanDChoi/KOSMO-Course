<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<script>
	if(${flag}){
		alert("입력성공(mv)")
	}else{
		alert("입력실패(mv)")
	}
	location.href='../addr/addr.do?m=list'
	</script>
