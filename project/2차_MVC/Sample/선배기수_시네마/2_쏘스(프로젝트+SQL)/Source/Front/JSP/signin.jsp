<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	
	<title>BIT CINEMA SIGNIN</title>
	
	<!-- Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700&amp;subset=korean" rel="stylesheet">
    
    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
  </head>
	
  <body>
  
  	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a href="index.do"><img src="${pageContext.request.contextPath}/img/logo.png" width="40%" height="auto"></a>
        <div>
          <a class="btn btn-sm" href="bitcinema.do?page=signup">회원등록</a>
        </div>
      </div>
    </nav>
    
	<div class="container">
	  <div class="d-flex justify-content-center h-100">
		<div class="card">
		  <div class="card-body" align="center">
			<form name="f" action="bitcinema.do?page=signinCheck" method="post">
			  <p align="left">Sign in</p>
			  <input type='text' name='email' placeholder='이메일 (example@bitcinema.com)' onkeyup='emailCheck(this.value); signinCheck();'>
			  <p></p>
			  <input type='password' name='pw' placeholder='비밀번호 (4자 이상)' onkeyup='pwCheck(this.value); signinCheck();'>
			  <p></p>
			  <input type='submit' class="btn btn-signin btn-xl" value='로그인' disabled>
			  <input type='hidden' name='kakao_email' value='empty'>
			</form>
			<hr>
			<a class="btn btn-signup btn-xl" href="bitcinema.do?page=signup"><img src="${pageContext.request.contextPath}/img/bit.png"> 비트시네마 회원등록</a>
			<p></p>
			<a class="btn btn-kakao btn-xl" href="javascript:loginWithKakao()"><img src="${pageContext.request.contextPath}/img/kakao.png"> 카카오계정으로 시작하기</a>
		  </div>
		</div>
	  </div>
	</div>
	
	<!-- JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- Kakao SDK -->
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	
	<script>
		var regex_email = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;
		var regex_pw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,16}$/;
		var flag_email = false;
		var flag_pw = false;
		
		function emailCheck(str){
			if(!regex_email.test(str)){
				$("input[name='email']").css("background-image", "url('${pageContext.request.contextPath}/img/no.png')");
				flag_email = false;
			}else{
				$("input[name='email']").css("background-image", "url('${pageContext.request.contextPath}/img/ok.png')");
				flag_email = true;
			}
		}
	  
		function pwCheck(str){
			if(!regex_pw.test(str)){
				$("input[name='pw']").css("background-image", "url('${pageContext.request.contextPath}/img/no.png')");
				flag_pw = false;
			}else{
				$("input[name='pw']").css("background-image", "url('${pageContext.request.contextPath}/img/ok.png')");
				flag_pw = true;
			}
		}
		
		function signinCheck(){
			if(flag_email == true && flag_pw == true){
				$("input[type=submit]").prop('disabled', false);
			}else{
				$("input[type=submit]").prop('disabled', true);
			}
		}
		
	    Kakao.init('10018fa82982d92d19877db18c35268f');
	    function loginWithKakao() {
	      Kakao.Auth.loginForm({
	        success: function(authObj) {
	          Kakao.API.request({
	        	url: '/v2/user/me',
	        	success: function(res) {
	        	  alert(res.kakao_account.email + ' (' + res.properties['nickname'] + ') 님 환영합니다.');
	        	  $("input[type='submit']").prop("disabled", false);
	        	  $("input[type='hidden']").val(res.kakao_account.email);
	        	  $("form").submit();
	        	}
	          });
	        },
	        fail: function(err) {
	          alert(JSON.stringify(err));
	        }
	      });
	    };
    </script>
  </body>
  
</html>