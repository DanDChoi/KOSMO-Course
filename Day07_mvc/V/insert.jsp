<%@ page contentType="text/html;charset=utf-8"%>



<%
	boolean flag = (Boolean)request.getAttribute("flag");
%>
    <script>
        if(<%=flag%>){
            alert("입력 성공(mvc)");
        }else {
        	alert("입력 실패(mvc)");
        }
        location.href='../addr/addr.do';
	</script>