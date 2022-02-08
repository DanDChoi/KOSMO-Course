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
    <link href="${pageContext.request.contextPath}/css/select_actor.css" rel="stylesheet">
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

      <h1 class="my-4 text-center text-white text-lg-left">배우 세 명을 선택해 주세요.</h1>
	  
	  <form action="bitcinema.do?page=main" method="post">
      <div class="row text-center text-lg-left">
	  
	  	<div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/31.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="김래원">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_31" value="31" onchange="toggleCheckBox()">
            <label for="actor_31" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/64.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="이범수">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_64" value="64" onchange="toggleCheckBox()">
            <label for="actor_64" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/77.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="제니퍼 코넬리">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_77" value="77" onchange="toggleCheckBox()">
            <label for="actor_77" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/88.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="잭 호킨스">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_88" value="88" onchange="toggleCheckBox()">
            <label for="actor_88" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/99.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="다니엘 레드클리프">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_99" value="99" onchange="toggleCheckBox()">
            <label for="actor_99" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/102.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="알 파치노">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_102" value="102" onchange="toggleCheckBox()">
            <label for="actor_102" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/108.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="원빈">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_108" value="108" onchange="toggleCheckBox()">
            <label for="actor_108" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/114.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="하정우">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_114" value="114" onchange="toggleCheckBox()">
            <label for="actor_114" class="checkbox heart"></label>
          </div>
        </div>
	  	<div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/120.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="주성치">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_120" value="120" onchange="toggleCheckBox()">
            <label for="actor_120" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/132.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="설경구">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_132" value="132" onchange="toggleCheckBox()">
            <label for="actor_132" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/144.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="레오나르도 디카프리오">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_144" value="144" onchange="toggleCheckBox()">
            <label for="actor_144" class="checkbox heart"></label>
          </div>
        </div>   
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/147.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="클린트 이스트우드">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_147" value="147" onchange="toggleCheckBox()">
            <label for="actor_147" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
		  <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/1.jpg"
		  data-toggle="tooltip" data-placement="bottom" title="레너드 위팅">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_1" value="1" onchange="toggleCheckBox()">
            <label for="actor_1" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/2.jpg"
          data-toggle="tooltip" data-placement="bottom" title="올리비아 핫세">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_2" value="2" onchange="toggleCheckBox()">
            <label for="actor_2" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/3.jpg"
          data-toggle="tooltip" data-placement="bottom" title="존 맥에너리">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_3" value="3" onchange="toggleCheckBox()">
            <label for="actor_3" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/163.jpg"
          data-toggle="tooltip" data-placement="bottom" title="파티마 사나 셰이크">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_163" value="163" onchange="toggleCheckBox()">
            <label for="actor_163" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/58.jpg"
          data-toggle="tooltip" data-placement="bottom" title="한석규">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_58" value="58" onchange="toggleCheckBox()">
            <label for="actor_58" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/183.jpg"
          data-toggle="tooltip" data-placement="bottom" title="키아누 리브스">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_183" value="183" onchange="toggleCheckBox()">
            <label for="actor_183" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/75.jpg"
          data-toggle="tooltip" data-placement="bottom" title="러셀 크로우">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_75" value="75" onchange="toggleCheckBox()">
            <label for="actor_75" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/135.jpg"
          data-toggle="tooltip" data-placement="bottom" title="주진우">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_135" value="135" onchange="toggleCheckBox()">
            <label for="actor_135" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/85.jpg"
          data-toggle="tooltip" data-placement="bottom" title="비비안 리">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_85" value="85" onchange="toggleCheckBox()">
            <label for="actor_85" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/106.jpg"
          data-toggle="tooltip" data-placement="bottom" title="김꽃비">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_106" value="106" onchange="toggleCheckBox()">
            <label for="actor_106" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/212.jpg"
          data-toggle="tooltip" data-placement="bottom" title="휴 잭맨">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_212" value="212" onchange="toggleCheckBox()">
            <label for="actor_212" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/127.jpg"
          data-toggle="tooltip" data-placement="bottom" title="오드리 헵번">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_127" value="127" onchange="toggleCheckBox()">
            <label for="actor_127" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/13.jpg"
          data-toggle="tooltip" data-placement="bottom" title="견자단">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_13" value="13" onchange="toggleCheckBox()">
            <label for="actor_13" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/14.jpg"
          data-toggle="tooltip" data-placement="bottom" title="임달화">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_14" value="14" onchange="toggleCheckBox()">
            <label for="actor_14" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/15.jpg"
          data-toggle="tooltip" data-placement="bottom" title="슝다이린">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_15" value="15" onchange="toggleCheckBox()">
            <label for="actor_15" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/16.jpg"
          data-toggle="tooltip" data-placement="bottom" title="폴 뉴먼">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_16" value="16" onchange="toggleCheckBox()">
            <label for="actor_16" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/17.jpg"
          data-toggle="tooltip" data-placement="bottom" title="로버트 레드포드">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_17" value="17" onchange="toggleCheckBox()">
            <label for="actor_17" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/18.jpg"
          data-toggle="tooltip" data-placement="bottom" title="로버트 쇼">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_18" value="18" onchange="toggleCheckBox()">
            <label for="actor_18" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/19.jpg"
          data-toggle="tooltip" data-placement="bottom" title="주디 갈랜드">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_19" value="19" onchange="toggleCheckBox()">
            <label for="actor_19" class="checkbox heart"></label>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
          <img class="img-fluid img-thumbnail" src="${pageContext.request.contextPath}/img/actor/20.jpg"
          data-toggle="tooltip" data-placement="bottom" title="프랭크 모건">
		  <div style="position: relative; left: 7.5rem; top: -2.75rem;">
            <input name="actor" type="checkbox" id="actor_20" value="20" onchange="toggleCheckBox()">
            <label for="actor_20" class="checkbox heart"></label>
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
   	           sessionStorage.setItem('actor_' + i, value);
   	     	   i++;
   	         }
   	      });
    	}
      }
    </script>
  </body>
  
</html>