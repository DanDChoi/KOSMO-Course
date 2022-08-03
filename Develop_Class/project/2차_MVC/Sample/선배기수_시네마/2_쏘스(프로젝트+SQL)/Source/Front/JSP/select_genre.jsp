<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link href="${pageContext.request.contextPath}/css/select_genre.css" rel="stylesheet">
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
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
    
    <div class="container">

      <h1 class="my-4 text-center text-white text-lg-left">장르 세 가지를 선택해 주세요.</h1>
	  
	  <form action="bitcinema.do?page=main" method="post">
      <div class="row text-center text-lg-left">
	  
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/1.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_1" value="1" onchange="toggleCheckBox()">
            <label for="genre_1" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/2.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_2" value="2" onchange="toggleCheckBox()">
            <label for="genre_2" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/3.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_3" value="3" onchange="toggleCheckBox()">
            <label for="genre_3" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/4.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_4" value="4" onchange="toggleCheckBox()">
            <label for="genre_4" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/5.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_5" value="5" onchange="toggleCheckBox()">
            <label for="genre_5" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/6.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_6" value="6" onchange="toggleCheckBox()">
            <label for="genre_6" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/7.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_7" value="7" onchange="toggleCheckBox()">
            <label for="genre_7" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/8.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_8" value="8" onchange="toggleCheckBox()">
            <label for="genre_8" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/9.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_9" value="9" onchange="toggleCheckBox()">
            <label for="genre_9" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/10.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_10" value="10" onchange="toggleCheckBox()">
            <label for="genre_10" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/11.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_11" value="11" onchange="toggleCheckBox()">
            <label for="genre_11" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/12.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_12" value="12" onchange="toggleCheckBox()">
            <label for="genre_12" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/13.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_13" value="13" onchange="toggleCheckBox()">
            <label for="genre_13" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/genre/14.jpg">
		  <div style="position: relative; left: 9rem; top: -2rem;">
            <input name="genre" type="checkbox" id="genre_14" value="14" onchange="toggleCheckBox()">
            <label for="genre_14" class="checkbox heart"></label>
          </div>
        </div>

      </div>
      <div id="ok">
	    <input type="submit" class="btn btn-xl" onclick="return checkedBoxCount()" value="선택 완료">
      </div>
      </form>
    </div>
    
    <footer class="py-3">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; BITCINEMA 2018</p>
      </div>
    </footer>

	<!-- JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Kakao SDK -->
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	
    <script>
      jQuery(document).ready(function($) {
        var toggleCheckBox = true;
    	$('.checkbox').click(function(){
          if(toggleCheckBox == true){
        	  $(this).toggleClass('is-checked');
          }else{
        	  $(this).removeClass('is-checked');
          }
        });
    	$("input[type='checkbox']:checkbox").change(function() {
      	  if(3 == $("input[type='checkbox']:checkbox:checked").length){
      	    $(":checkbox:not(:checked)").prop("disabled", true);
  			toggleCheckBox = false;
      	  }else{
      	    $("input[type='checkbox']:checkbox").prop("disabled", false);
  		    toggleCheckBox = true;
      	  }
      	});
   	  });
    
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
      
      function checkedBoxCount(){
    	var count = $("input[type='checkbox']:checked").length;

    	if(count < 3){
    	  alert('세 가지를 선택해주셔야 합니다!');
    	  return false;
    	}else{
    	  var i = 1;
   	      $("input[type='checkbox']:checkbox").each(function(){
   	         if($(this).is(':checked')){
   	           var value = ($(this).val());
   	           sessionStorage.genre = value;
   	           sessionStorage.setItem('genre_' + i, value);
   	     	   i++;
   	         }
   	      });
    	}
      }
    </script>
  </body>
  
</html>