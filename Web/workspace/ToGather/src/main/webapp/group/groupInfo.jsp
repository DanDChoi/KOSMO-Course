<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, team1.togather.domain.GroupTab, team1.togather.domain.Gathering, team1.togather.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>ToGather 모임</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../assets/ToGather.ico" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/styles.css" rel="stylesheet" />
    <link href="../css/main.css" rel="stylesheet" />
    <link href="../css/groupList.css" rel="stylesheet" />
    <script src="../js/main.js" defer></script>
    <script src="../js/splitting.js"></script>
    <script src="../js/typed.js"></script>
  </head>
<%
   long gSeq = (Long)request.getAttribute("groupInfo_gSeq");
   System.out.println("groupInfo jsp안 : "+ gSeq);
%>
<body>
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light bg-gray">
      <div class="container px-4 px-lg-5">
        <h1 class="logo">
          <a href="../"
            ><img src="../imgs/topLogo.png" alt="ToGather" title="홈으로 이동"
          /></a>
        </h1>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
            <li class="nav-item">
              <a
                class="nav-link active"
                aria-current="page"
                href="introduce.html"
                >ToGather란?</a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="notice.html">공지사항</a>
            </li>
         <li class="nav-item">
              <a class="nav-link" href="groupTab.do?m=groupList">모임 목록</a>
            </li>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                id="navbarDropdown"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
                >자주하는 질문(Q&A 게시판필요)</a
              >
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li>
                  <a class="dropdown-item" href="FAQ.html">FAQ</a>
                </li>
                <li>
                  <a class="dropdown-item" href="QA.html">Q&A(게시판필요)</a>
                </li>
              </ul>
            </li>
          </ul>
          <form class="d-flex">
            <!-- 로그인시 보이게하기
            <button class="btn btn-outline-success" type="button" onclick="location.href='logout.html'">
              <i class="bi bi-person-check-fill"></i>
              로그아웃
            </button>
          -->
            <button
              class="btn btn-outline-dark"
              type="button"
              onclick="location.href='login.html'"
            >
              <i class="bi bi-person-fill"></i>
              로그인
            </button>
            <button
              class="btn btn-outline-primary"
              type="button"
              onclick="location.href='join.html'"
            >
              <i class="bi bi-person-plus-fill"></i>
              회원가입
            </button>
            <button
              class="btn btn-outline-dark"
              type="button"
              onclick="location.href='wish.html'"
            >
              <i class="bi-cart-fill me-1"></i>
              찜
              <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
            </button>
            <!--회원전용 메뉴. 비로그인시 로그인먼저 하도록 alert 띄우기-->
            <button
              class="btn btn-outline-danger"
              type="button"
              onclick="location.href='groupTab.do?m=groupInput'"
            >
              <i class="bi bi-people-fill"></i>
              모임 만들기
            </button>
          </form>
        </div>
      </div>
    </nav>

   <c:forEach items="${groupInfo}" var="groupTab">

      
     <div class="container">
      <div class="row mb-3" style="background-color: lavender; border-radius: 2ex">
        <div class="text-center my-5">
          <h1 class="fw-bolder">${groupTab.gName}</h1>
          <p class="lead mb-0">${groupTab.gLoc}</p>
        </div>
      </div>
    </div>
    
    <!-- Page content-->
    <div class="container">
      <div class="row">
        <!-- Blog entries-->
        <div class="col-lg-8">
          <!-- Featured blog post-->
          <div class="card mb-4">
            <a href="#!"
              ><img class="card-img-top" src="../imgs/hobby1.jpg" alt="..."
            /></a>
            <div class="card-body">
              <div class="small text-muted">${groupTab.rdate}</div>
              <h5 class="card-title">#모임소개</h5>
              <h3 class="card-text">${groupTab.gIntro}</h3>
            </div>
          </div>
          <!-- Nested row for non-featured blog posts-->

          <!-- Pagination-->
        </div>
        
   </c:forEach>
   
        <!-- Side widgets-->
        <div class="col-lg-4">
          <!-- Search widget-->
          <div class="car mb-4">
            <div class="list-group">
              <li class="list-group-item list-group-item-secondary" style="background-color: lavender">
                <b>정모</b>
              </li>
           <c:forEach items="${gatheringList}" var="gathering">
              <a
                href="groupTab.do?m=gatheringInfo&gSeq=${gathering.gSeq}&ga_seq=${gathering.ga_seq}"
                class="list-group-item list-group-item-action"
                >${gathering.ga_name}</a
              >
              
               </c:forEach>
              <button
                type="button"
                class="list-group-item list-group-item-action active"
                style="text-align: center"
                onclick="location.href='groupTab.do?m=gatheringInput&gSeq=<%=gSeq%>'"
              >
                정모 만들기
              </button>
            </div>
          </div>
          <nav aria-label="Page navigation example">
            <ul
              id="notice_page"
              class="pagination pagination-sm"
              style="justify-content: center"
            >
              <li class="page-item">
                <a class="page-link" href="#"><</a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item">
                <a class="page-link" href="#">></a>
              </li>
            </ul>
          </nav>

          <br />
          <div class="card mb-4">
            <div class="card-header" style="background-color: lavender"><b>모임 멤버(수정 불필요)</b></div>
            <div class="card-body">
                <ul>
                    멤버이름(받아올 값)(목록형식으로 수정해야함)
                  </ul>
                  <ul>
                    멤버이름(받아올 값)(목록형식으로 수정해야함)
                  </ul>
            </div>
          </div>
          <nav aria-label="Page navigation example">
            <ul
              id="notice_page"
              class="pagination pagination-sm"
              style="justify-content: center"
            >
              <li class="page-item">
                <a class="page-link" href="#"><</a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item">
                <a class="page-link" href="#">></a>
              </li>
            </ul>
          </nav>
          <div class="d-grid gap-2 col-6 mx-auto">
            <button class="btn btn-success mb-5 mt-3" type="button" href="gatheringBoard.html">
               게시판
            </button>
          </div>
       
          <div class="d-flex justify-content-center mt-3">
            <button
              type="button"
              class="btn btn-outline-secondary"
              onclick="location.href='groupTab.do?m=groupGetUpdate&gSeq=<%=gSeq%>'"
            >
              모임 정보 수정하기
            </button>
          </div>
          <div class="d-flex justify-content-center mt-3">
	          <button
	              type="button"
	              class="btn btn-outline-secondary"
	              onclick="location.href='groupTab.do?m=groupDelete&gSeq=<%=gSeq%>'"
	            >
              모임 삭제하기(바로 삭제)
            </button>
           </div>
      </div>
    </div>
        </div>
  </body>
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">
        Copyright &copy; Your Website 2021
      </p>

  </footer>
  <!— Bootstrap core JS—>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <!— Core theme JS—>
  <script src="js/scripts.js"></script>
</html>