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
    <link href="${pageContext.request.contextPath}/css/select_director.css" rel="stylesheet">
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

      <h1 class="my-4 text-center text-white text-lg-left">감독 세 명을 선택해 주세요.</h1>
	  
	  <form action="bitcinema.do?page=main" method="post">
      <div class="row text-center text-lg-left">
	  
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/1.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="프랑코 제페렐리">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_0" value="1" onchange="toggleCheckBox();">
            <label for="director_0" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/2.jpg"
          data-toggle="tooltip" data-placement="bottom" title="하라 케이이치">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_2" value="2" onchange="toggleCheckBox();">
            <label for="director_2" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/3.jpg"
          data-toggle="tooltip" data-placement="bottom" title="리 언크리치">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_3" value="3" onchange="toggleCheckBox();">
            <label for="director_3" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/4.jpg"
          data-toggle="tooltip" data-placement="bottom" title="브래드 버드">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_4" value="4" onchange="toggleCheckBox();">
            <label for="director_4" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/5.jpg"
          data-toggle="tooltip" data-placement="bottom" title="엽위신">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_5" value="5" onchange="toggleCheckBox();">
            <label for="director_5" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/6.jpg"
          data-toggle="tooltip" data-placement="bottom" title="조지 로이 힐">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_6" value="6" onchange="toggleCheckBox();">
            <label for="director_6" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/7.jpg"
          data-toggle="tooltip" data-placement="bottom" title="빅터 플레밍">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_7" value="7" onchange="toggleCheckBox();">
            <label for="director_7" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/8.jpg"
          data-toggle="tooltip" data-placement="bottom" title="켄 로치">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_8" value="8" onchange="toggleCheckBox();">
            <label for="director_8" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/9.jpg"
          data-toggle="tooltip" data-placement="bottom" title="커크 드 미코">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_9" value="9" onchange="toggleCheckBox();">
            <label for="director_9" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/10.jpg"
          data-toggle="tooltip" data-placement="bottom" title="크리스 샌더스">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_10" value="10" onchange="toggleCheckBox();">
            <label for="director_10" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/11.jpg"
          data-toggle="tooltip" data-placement="bottom" title="윤가은">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_11" value="11" onchange="toggleCheckBox();">
            <label for="director_11" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/12.jpg"
          data-toggle="tooltip" data-placement="bottom" title="강석범">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_12" value="12" onchange="toggleCheckBox();">
            <label for="director_12" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/13.jpg"
          data-toggle="tooltip" data-placement="bottom" title="야마시타 히로유키">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_13" value="13" onchange="toggleCheckBox();">
            <label for="director_13" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/14.jpg"
          data-toggle="tooltip" data-placement="bottom" title="존 터틀다웁">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_14" value="14" onchange="toggleCheckBox();">
            <label for="director_14" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/15.jpg"
          data-toggle="tooltip" data-placement="bottom" title="쥬세페 토르나토레">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_15" value="15" onchange="toggleCheckBox();">
            <label for="director_15" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/16.jpg"
          data-toggle="tooltip" data-placement="bottom" title="추창민">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_16" value="16" onchange="toggleCheckBox();">
            <label for="director_16" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/17.jpg"
          data-toggle="tooltip" data-placement="bottom" title="야마모토 야스이치로">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_17" value="17" onchange="toggleCheckBox();">
            <label for="director_17" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/18.jpg"
          data-toggle="tooltip" data-placement="bottom" title="로버트 저메키스">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_18" value="18" onchange="toggleCheckBox();">
            <label for="director_18" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/19.jpg"
          data-toggle="tooltip" data-placement="bottom" title="고레에다 히로카즈">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_19" value="19" onchange="toggleCheckBox();">
            <label for="director_19" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/20.jpg"
          data-toggle="tooltip" data-placement="bottom" title="최신규">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_20" value="20" onchange="toggleCheckBox();">
            <label for="director_20" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/51.jpg"
          data-toggle="tooltip" data-placement="bottom" title="크리스토퍼 놀란">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_51" value="51" onchange="toggleCheckBox();">
            <label for="director_51" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/90.jpg"
          data-toggle="tooltip" data-placement="bottom" title="구스 반 산트">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_90" value="90" onchange="toggleCheckBox();">
            <label for="director_90" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/61.jpg"
          data-toggle="tooltip" data-placement="bottom" title="제임스 카메론">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_61" value="61" onchange="toggleCheckBox();">
            <label for="director_61" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/66.jpg"
          data-toggle="tooltip" data-placement="bottom" title="스티븐 스필버그">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_66" value="66" onchange="toggleCheckBox();">
            <label for="director_66" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/73.jpg"
          data-toggle="tooltip" data-placement="bottom" title="리들리 스콧">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_73" value="73" onchange="toggleCheckBox();">
            <label for="director_73" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/74.jpg"
          data-toggle="tooltip" data-placement="bottom" title="피터 잭슨">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_74" value="74" onchange="toggleCheckBox();">
            <label for="director_74" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/76.jpg"
          data-toggle="tooltip" data-placement="bottom" title="뤽 베송">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_76" value="76" onchange="toggleCheckBox();">
            <label for="director_76" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/director/128.jpg"
          data-toggle="tooltip" data-placement="bottom" title="호소다 마모루">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="director" type="checkbox" id="director_128" value="128" onchange="toggleCheckBox();">
            <label for="director_128" class="checkbox heart"></label>
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
    	$('[data-toggle="tooltip"]').tooltip(); // Tooltip
    	 
        var toggleCheckBox = true; // CheckBox
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
   	           sessionStorage.setItem('director_' + i, value);
   	     	   i++;
   	         }
   	      });
    	}
      }
    </script>
  </body>
  
</html>