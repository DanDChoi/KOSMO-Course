<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	
	<title>BIT CINEMA SIGNUP</title>
	
	<!-- Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700&amp;subset=korean" rel="stylesheet">
    
    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/css/signup.css" rel="stylesheet">
  </head>
	
  <body>
  
  	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a href="./"><img src="${pageContext.request.contextPath}/img/logo.png" width="40%" height="auto"></a>
        <div>
          <a class="btn btn-sm" href="bitcinema.do?page=signin">로그인</a>
        </div>
      </div>
    </nav>
    
	<div class="container">
	  <div class="d-flex justify-content-center h-100">
		<div class="card">
		  <div class="card-body" align="center">
			
			<form name="f" action="bitcinema.do?page=signupCheck" method="post">
			  <p align="left">Sign up</p>
			  <div id="form">
			  <input type='text' name='name' placeholder='이름 (2자 이상)' onkeyup='nameCheck(this.value); signupCheck();'>
			  <input type='text' name='email' placeholder='이메일 (example@bitcinema.com)' onkeyup='emailCheck(this.value); signupCheck();'>
			  <input type='password' name='pw' placeholder='비밀번호 (4자 이상)' onkeyup='pwCheck(this.value); signupCheck();'>
			  </div>
			  <hr>
			  <input type='submit' class="btn btn-submit btn-xl" value='가입 완료' disabled>
			</form>
		  </div>
		</div>
	  </div>
	</div>
	
	<!-- JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script>
		var regex_name = /^[가-힣]{2,10}$/;
		var regex_email = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;
		var regex_pw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,16}$/;
		var flag_name = false;
		var flag_email = false;
		var flag_pw = false;
		
		function nameCheck(str){
			if(!regex_name.test(str)){
				$("input[name='name']").css("background-image", "url('${pageContext.request.contextPath}/img/no.png')");
				flag_name = false;
			}else{
				$("input[name='name']").css("background-image", "url('${pageContext.request.contextPath}/img/ok.png')");
				flag_name = true;
			}
		}
		
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
		
		function signupCheck(){
			if(flag_name == true && flag_email == true && flag_pw == true){
				$("input[type=submit]").prop("disabled", false);
			}else{
				$("input[type=submit]").prop("disabled", true);
			}
		}
    </script>
  </body>
  
</html>