<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, team1.togather.domain.GroupTab"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>No.1 취미모임 웹페이지, ToGather!</title>
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
    <script src="../js/main.js" defer></script>
    <script src="../js/splitting.js"></script>
    <script src="../js/typed.js"></script>
  </head>
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
              <a class="nav-link" href="group/groupTab.do?m=groupList">모임 목록</a>
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
	<c:if test="${empty groupList}">
    	모임이 없습니다.
    </c:if>
    
    <section class="py-5">
      <div class="container px-4 px-lg-5 mt-5">
        <div
          class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
        >
        <c:forEach items="${groupList}" var="groupTab">
          <div class="col mb-5">
            <div class="card h-100">
              <!-- Product image-->
              <img class="card-img-top" src="../imgs/hobby1.jpg" alt="..." />
              <!-- Product details-->
              <div class="card-body p-4">
                <div class="text-center">
                  <!-- Product name-->
                  <h6 class="fw-bolder">${groupTab.gLoc}</h6>
                  <h4 class="fw-bolder">${groupTab.gName}</h4>
                  <!-- Product price-->
                  ${groupTab.gIntro}
                </div>
              </div>
              <!-- Product actions-->
              <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                <div class="text-center">
                  <a class="btn btn-outline-dark mt-auto" href="groupTab.do?m=groupInfo&gSeq=${groupTab.gSeq}"
                    >둘러보기</a
                  >
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
</div>
</div>
</section>
</body>
</html>
<hr width='600' size='2' noshade>
