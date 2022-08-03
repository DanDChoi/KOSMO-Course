<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>BIT CINEMA MAIN</title>

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
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
  </head>

  <body>
  
	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a href="bitcinema.do?page=main"><img src="${pageContext.request.contextPath}/img/logo.png" width="40%" height="auto"></a>
          <div>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <input type="text" id="search" name="search" value="영화 검색　" onkeypress="if(window.event.keyCode == 13){javascript:search(this.value);}">
              </li>
              <li class="nav-item">
                <a class="btn btn-sm" href="bitcinema.do?page=curator">큐레이터</a>
              </li>
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
      <h1><font color="#fff"><strong>${fn:substring(email, 0, idx)}</strong></font>님의 취향 분석 결과 :</h1>
      <h2>이 영화, 어떠세요?</h2>
    </header>
    
    <section class="p-0" id="portfolio">
      <div class="container-fluid p-0">
        <div class="row no-gutters popup-gallery">
        
          <c:forEach var='dto' items='${result}'>
	         <div class="col-md-4 col-sm-6">
	           <a class="portfolio-box" onClick='move("${dto.film_id}")'>
	           <img class="img-fluid" src="${pageContext.request.contextPath}/img/poster/${dto.film_poster}" width="325px" height="470px">
	             <div class="portfolio-box-caption">
	               <div class="portfolio-box-caption-content">
	                 <div class="project-name">
	                 ${dto.film_title}
	                 </div>
	                 <div class="project-category text-faded">
	                 ${dto.film_title_eng}
	                 </div>
	                 <hr>
	                 <div class="project-info text-faded">
	                 네이버 평점 : ${dto.film_grade_naver} | 비트 평점 : <fmt:formatNumber value="${dto.film_grade_bit}" pattern=".0"></fmt:formatNumber><br>
	                 장르 : ${dto.genre_name} | 상영시간 : ${dto.running_time}분<br>
	                 감독 : ${dto.director_name}<br>
	                 주연 : ${dto.actor_name1}, ${dto.actor_name2}, ${dto.actor_name3}<br>
	                 키워드 : ${dto.material_name}
	                 </div>
	                 <hr>
	                 <div class="project-content">
	                 	<c:set var="content" value="${dto.film_content}"/>
	                 	<c:choose>
	                 		<c:when test="${fn:length(content) ge 100}">${fn:substring(content, 0, 100)} …</c:when>
	                 		<c:otherwise>${content}</c:otherwise>
	                 	</c:choose>
	                 </div>
	               </div>
	             </div>
	           </a>
	         </div>
          </c:forEach>
          
		  <c:set var="emptyCount" value="${3 - fn:length(result)}"/>
	  	  <c:forEach begin="1" end="${emptyCount}">
	  	    <div class="col-md-4 col-sm-6">
	          <a class="portfolio-box" href="${pageContext.request.contextPath}/img/poster/empty.jpg" >
	          <img class="img-fluid" src="${pageContext.request.contextPath}/img/poster/empty.jpg" width="325px" height="470px">
	          </a>
	        </div>
	  	  </c:forEach>
	  	  
        </div>
      </div>
    </section>
    
    <footer class="py-3">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; BITCINEMA 2018</p>
      </div>
    </footer>

	<!-- JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/creative.min.js"></script>
    
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
      
      function move(code){
    	  location.href='bitcinema.do?page=film_detail&code=' + code;
      }
      
      $("#search").autocomplete({
        source : function(request, response) {
          $.ajax({
            url : "<c:url value='bitcinema.do?page=search'/>",
            type : 'post',
            dataType : 'json',
            data: "&keyword=" + $("#search").val(),
            success : function(data) {
              var result = data;
              response(result);
            },
            error : function(data) {
              alert("검색 중 문제가 발생하였습니다.");
            }
          });
        },
        autoFocus: false,
        minLength: 2
      });
      
      function search(keyword){
  		var regex = /\s/;
  		if(keyword == null || keyword == "" || keyword == " "){
  			alert('검색어를 입력해 주세요!');
  			return;
  		}else{
  			location.href='bitcinema.do?page=search_convert&title=' + keyword;
  	  	}
      }
    </script>
  </body>
  
</html>