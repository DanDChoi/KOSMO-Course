<%@ page contentType="text/html;charset=utf-8" import="bcm.member.domain.Member"%>

<%		
	int i = (Integer)request.getAttribute("message");
	//Member member = (Member)session.getAttribute("user");
%>
	<script>
		switch(<%=i%>){
			case 0: 
				alert("반드시 모든값을 입력해주세요.");
				location.href='login.do?m=loginmenu';
				break;
			case 1: 
				alert("아이디 또는 비밀번호가 잘못되었습니다.");
				location.href='login.do?m=loginmenu';
				break;
			case 2: 
				alert("로그인이 완료 되었습니다.");
				location.href='login.do';
				break;
			default: 
				location.href='login.do?m=loginmenu';
				break;
		}
	</script>