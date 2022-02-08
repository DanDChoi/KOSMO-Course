<%@ page contentType="text/html;charset=utf-8" %>
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
	<link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap-responsive.css" rel="stylesheet">
	
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700&amp;subset=korean" rel="stylesheet">

    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/css/film_detail.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  </head>

  <body>

	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a href="index.do"><img src="${pageContext.request.contextPath}/img/logo.png" width="40%" height="auto"></a>
          <div>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <input type="text" id="search" name="search" value="영화 검색　" onkeypress="if(window.event.keyCode == 13){javascript:search(this.value);}">
              </li>
              <li class="nav-item">
                <a class="btn btn-sm" href="bitcinema.do?page=curator">큐레이터</a>
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

    <div class="container">

      <div class="row top">
        <div class="col-md-5">
          <img class="img-fluid" src="${pageContext.request.contextPath}/img/poster/${film_detail.get(0).film_poster}" width="400px" height="500px">
        </div>
		
        <div class="col-md-7">
            <h3 class="my-3"><strong><font color="white">${film_detail.get(0).film_title}</font></strong><br>
            <sub class="text-faded">${film_detail.get(0).film_title_eng}</sub></h3>
            <hr>
              <p id="grade"><font color="white">네이버 영화 평점 : ★ ${film_detail.get(0).film_grade_naver}　|　비트시네마 평점 : ★ ${film_detail.get(0).film_grade_bit}</font></p>
            <hr>
            <p><strong>장르</strong> : ${film_detail.get(0).genre_name}　|　<strong>소재 / 키워드</strong> : ${film_detail.get(0).material_name}</p>
            <p><strong>상영시간</strong> : ${film_detail.get(0).running_time}분</p>
            <p><strong>감독</strong> : ${film_detail.get(0).director_name}</p>
            <p><strong>주연</strong> : ${film_detail.get(0).actor_name1}, ${film_detail.get(0).actor_name2}, ${film_detail.get(0).actor_name3}</p> 
            <p><strong>줄거리</strong> :</p>
            <p>${film_detail.get(0).film_content}</p>
        </div>
      </div>

      <h3 id="h3_1" class="my-4"><strong>제작진 / 배우<font color="#aaa"><small> Staff / Actor</small></font></strong></h3>
      <div class="row bottom">
        <div class="col-md-2 col-sm-6 mb-4">
            <a href="" title="" class="tx_people"><img class="img-fluid" src="${pageContext.request.contextPath}/img/director/${film_detail.get(0).director_id}.jpg"><br>
            <dl>
              <dt class="dir_main">감독</dt>
              <dt class="dir_sub">${film_detail.get(0).director_name}</dt>
            </dl>
            </a>
        </div>
		
        <div class="col-md-2 col-sm-6 mb-4">
            <a href="" title="" class="tx_people"><img class="img-fluid" src="${pageContext.request.contextPath}/img/actor/${film_detail.get(0).actor_id1}.jpg"><br>
            <dl class="staff">
              <dt class="staff_main">출연</dt>
              <dt class="staff_sub">${film_detail.get(0).actor_name1}</dt>
            </dl>
            </a>
        </div>
				
        <div class="col-md-2 col-sm-6 mb-4">
            <a href="" title="" class="tx_people"><img class="img-fluid" src="${pageContext.request.contextPath}/img/actor/${film_detail.get(0).actor_id2}.jpg"><br>
            <dl class="staff">
              <dt class="staff_main">출연</dt>
              <dt class="staff_sub">${film_detail.get(0).actor_name2}</dt>
            </dl>
            </a>
        </div>

        <div class="col-md-2 col-sm-6 mb-4">
            <a href="" title="" class="tx_people"><img class="img-fluid" src="${pageContext.request.contextPath}/img/actor/${film_detail.get(0).actor_id3}.jpg"><br>
            <dl class="staff">
              <dt class="staff_main">출연</dt>
              <dt class="staff_sub">${film_detail.get(0).actor_name3}</dt>
            </dl>
            </a>
        </div>
      </div>

      <h3 id="h3_2"><strong><font color="#fff">리뷰<font color="#aaa"><small> Review</small></font></font></strong></h3>
      <br>
      <form action="bitcinema.do?page=reviewInsert" name="star_rating" class="rating" method="post">
		<div class="container">
		  <div class="row">
	  		<div class="rating">
		      <input type="radio" id="star5" name="review_grade" value="10.0" /><label class = "full" for="star5" data-toggle="tooltip" data-placement="top" title="10점"></label>
		      <input type="radio" id="star4half" name="review_grade" value="9.0" /><label class="half" for="star4half" data-toggle="tooltip" data-placement="top" title="9점"></label>
		      <input type="radio" id="star4" name="review_grade" value="8.0" /><label class = "full" for="star4" data-toggle="tooltip" data-placement="top" title="8점"></label>
		      <input type="radio" id="star3half" name="review_grade" value="7.0" /><label class="half" for="star3half" data-toggle="tooltip" data-placement="top" title="7점"></label>
		      <input type="radio" id="star3" name="review_grade" value="6.0" /><label class = "full" for="star3" data-toggle="tooltip" data-placement="top" title="6점"></label>
		      <input type="radio" id="star2half" name="review_grade" value="5.0" /><label class="half" for="star2half" data-toggle="tooltip" data-placement="top" title="5점"></label>
		      <input type="radio" id="star2" name="review_grade" value="4.0" /><label class = "full" for="star2" data-toggle="tooltip" data-placement="top" title="4점"></label>
		      <input type="radio" id="star1half" name="review_grade" value="3.0" /><label class="half" for="star1half" data-toggle="tooltip" data-placement="top" title="3점"></label>
		      <input type="radio" id="star1" name="review_grade" value="2.0" /><label class = "full" for="star1" data-toggle="tooltip" data-placement="top" title="2점"></label>
		      <input type="radio" id="starhalf" name="review_grade" value="1.0" /><label class="half" for="starhalf" data-toggle="tooltip" data-placement="top" title="1점"></label>
	        </div>
			
            <div class="col-md-auto"> 
              <textarea name="review_content" class="span6" rows="1" cols="80" placeholder=" 나만의 영화평을 작성해 보세요"></textarea>
            </div>
            <div class="col">
              <input type="hidden" name="film_id" value="${film_detail.get(0).film_id}">
              <input type="hidden" name="review_writer" value="${signin_dto.email}">
              <input type="submit" class="btn btn-primary" value="등록">
            </div>
            
          </div>
        </div>
      </form>
	</div>
	
	<br><br>
	<div class="container">
	  <hr class="list">
	  <c:forEach var="dto" items="${reviewList}" varStatus="status">
	  <c:if test="${status.count >= 2}"><hr class="sub_list"></c:if>
	  <div class="review_list">
	    <div class="star_score">
	      <span class="star">${dto.review_grade / 2}</span><label for="star">　${dto.review_grade}점<c:if test="${dto.review_grade ne 10.0}">&nbsp;</c:if></label>
	    </div>
	    <div class="review_content">
	      <p>${dto.review_content}</p>
	      <p><font color="#aaa">${dto.review_writer}　|　${dto.review_writedate}</font></p>
	    </div>
	    <div class="review_delete">
	      <form action="bitcinema.do?page=reviewDelete" name="delete" method="post">
	        <input type="hidden" name="film_id" value="${film_detail.get(0).film_id}">
            <input type="hidden" name="review_writer" value="${signin_dto.email}">
	        <c:if test="${dto.review_writer eq signin_dto.email}"><button class="btn btn-xs" onclick="return delete_confirm()">삭제</button></c:if>
	      </form>
	    </div>
	  </div>
	  </c:forEach>
	  <hr class="list">
	</div>
	
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
      $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
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
      
      function delete_confirm(){
    	if(confirm('삭제된 영화평은 복구할 수 없습니다.\n정말로 삭제하시겠습니까?')){
    	  $("form[name='delete']").submit();
    	}else{
    	  return false;
    	}
      }
      
      $.fn.generateStars = function(){
        return this.each(function(i,e){$(e).html($('<span/>').width($(e).text() * 20));});
      };
      $('.star').generateStars();
      
      $("input[type='radio']").click(function(){
    	  var score = $(this).val();
    	  $(this).next().next().append(score);
      });
      
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