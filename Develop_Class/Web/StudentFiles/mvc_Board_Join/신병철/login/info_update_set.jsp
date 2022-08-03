<%@ page contentType="text/html;charset=utf-8"%>

<%
	boolean flag = (Boolean)request.getAttribute("flag");
%>
	<script>
		if(<%=flag%>){
			alert("개인정보 수정완료");
		}else{
			alert("개인정보 수정실패");
		}
		location.href='login.do'
	</script>