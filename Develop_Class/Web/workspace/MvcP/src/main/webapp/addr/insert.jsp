<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <script>
        if(${flag}){
            alert("입력 성공(with JSTL + EL)");
        }else {
        	alert("입력 실패(with JSTL + EL)");
        }
        location.href='addr.do';
	</script>