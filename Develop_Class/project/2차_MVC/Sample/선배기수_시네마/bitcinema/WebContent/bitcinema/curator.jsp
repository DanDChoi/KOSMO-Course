<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
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
	    <link href="${pageContext.request.contextPath}/css/curator.css" rel="stylesheet">
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
                <a class="btn btn-sm" href="bitcinema.do?page=main">메인</a>
              </li>
              <li class="nav-item">
                <a class="btn btn-sm" href="javascript:signout()">로그아웃</a>
              </li>
            </ul>
          </div>
      </div>
    </nav>
    
    <section class="p-0" id="portfolio">
	<div class="container">
		<div class="card-columns">
			<c:forEach var="dto" items="${curating_board}">
			<div class="card">
	  			<iframe class="card-img-top" src="https://www.youtube.com/embed/${dto.youtubeurl}?controls=1" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen="false" width="480px" height="272px"></iframe>
				<div class="card-body">
	      			<h5 class="card-title">
	      				<a href="#youtubeModal_${dto.curating_no}" data-toggle="modal"><strong>${dto.curating_subject}</strong></a>
	      			</h5>
	      			<p class="card-text">
      				<c:set var="content" value="${dto.curating_content}"/>
                 	<c:choose>
                 		<c:when test="${fn:length(content) ge 300}">${fn:substring(content, 0, 300)} …</c:when>
                 		<c:otherwise>${content}</c:otherwise>
                 	</c:choose>
	      			</p>
	      			<p class="card-text"><small class="text-muted">${dto.curating_writedate}</small></p>
	    		</div>
	  		</div>
	  		</c:forEach>
		</div>
	</div>
	</section>
	
	<c:forEach var="dto_modal" items="${curating_board}">
	<div class="modal fade" id="youtubeModal_${dto_modal.curating_no}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalCenterTitle"></h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	          <iframe id="myVideo" src="https://www.youtube.com/embed/${dto_modal.youtubeurl}?controls=1" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen="false"  height="315px" width="100%"></iframe>
	          <div>
			  <br>${dto_modal.curating_content}
	          </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal">닫기</button>
	      </div>
	    </div>
	  </div>
	</div>
	</c:forEach>
	
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