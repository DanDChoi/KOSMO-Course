<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>BIT CINEMA</title>
    
    <c:if test="${empty signin_dto.email}">
	  <script>
	    alert('로그인이 필요한 서비스입니다.');
	    location.href='bitcinema.do?page=signin';
	  </script>
	</c:if>

    <!-- Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700&amp;subset=korean" rel="stylesheet">

    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet">
    
  </head>

  <body>
  
	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a href="index.do"><img src="${pageContext.request.contextPath}/img/logo.png" width="40%" height="auto"></a>
          <div>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a class="btn btn-sm" href="javascript:signout()">로그아웃</a>
              </li>
            </ul>
          </div>
      </div>
    </nav>
    
    <c:set var="email" value="${signin_dto.email}"/>
    <c:set var="idx" value="${fn:indexOf(email, '@')}"/>
    <header class="text-center text-white">
      <h1 class="text-faded"><font color="#fff">${fn:substring(email, 0, idx)}</font>님 환영합니다.</h1>
      <h2>먼저, 어떤 기준으로 영화를 선택하시는지 알려주세요!</h2>
    </header>

	<div class="container">
      <div class="row">

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card genre">
            <img class="card-img-top" src="${pageContext.request.contextPath}/img/select/genre.jpg">
            <div class="card-body">
              <h3 class="card-title">장르<small><font color="#aaa">Genre</font></small></h3>
              <p class="card-text">드라마, 판타지, 로맨스,<br>스릴러, 코미디 등 …<br>14가지의 선택지들이<br>준비되어 있습니다.<br>선호하는 장르의 영화를 <br>추천받아 보세요!</p>
            </div>
            <div class="card-footer">
              <a href="bitcinema.do?page=select_genre" class="btn btn_select btn-primary"><span>선택하기</span></a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card director">
            <img class="card-img-top" src="${pageContext.request.contextPath}/img/select/director.jpg">
            <div class="card-body">
              <h3 class="card-title">감독<small><font color="#aaa">Director</font></small></h3>
              <p class="card-text">영화에 관한 모든 요소들을<br>총괄하는 핵심!<br>제작자의 작품 세계에<br>주목하는 타입이라면,<br>이쪽을 선택해 보세요!</p>
            </div>
            <div class="card-footer">
              <a href="bitcinema.do?page=select_director" class="btn btn_select btn-primary"><span>선택하기</span></a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card actor">
            <img class="card-img-top" src="${pageContext.request.contextPath}/img/select/actor.jpg">
            <div class="card-body">
              <h3 class="card-title">배우<small><font color="#aaa">Actor</font></small></h3>
              <p class="card-text">영화의 간판이자 얼굴!<br>세계 각국 명배우들의<br>필모그래피를 좇아가 보는 것도<br>영화를 즐기는 방법이겠죠?</p>
            </div>
            <div class="card-footer">
              <a href="bitcinema.do?page=select_actor" class="btn btn_select btn-primary"><span>선택하기</span></a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card materials">
            <img class="card-img-top" src="${pageContext.request.contextPath}/img/select/materials.jpg">
            <div class="card-body">
              <h3 class="card-title">소재<small><font color="#aaa">Materials</font></small></h3>
              <p class="card-text">같은 장르의 영화라도,<br>중심 제재에 따라 천차만별!<br>가족, 마법, 좀비, 미스테리 등…<br>좋아하는 소재의 영화들을<br>골라보는 재미!</p>
            </div>
            <div class="card-footer">
              <a href="bitcinema.do?page=select_materials" class="btn btn_select btn-primary"><span>선택하기</span></a>
            </div>
          </div>
        </div>

      </div>
	</div>
	
	<footer class="py-3">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; BITCINEMA 2018</p>
      </div>
    </footer>
	
	<!-- JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
    
    <!-- Kakao SDK -->
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	
    <script>
      Kakao.init('10018fa82982d92d19877db18c35268f');
      function signout(){
        if(Kakao.Auth.getAccessToken() != null){
    	  Kakao.Auth.logout(function(){
    	    setTimeout(function(){
              location.href="bitcinema.do?page=signout";
           },500);
         });
        }else{
        	location.href="bitcinema.do?page=signout";
        }
      }
    </script>
  </body>
  
</html>