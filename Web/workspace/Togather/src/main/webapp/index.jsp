<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*, java.util.ArrayList,team1.togather.domain.GroupTab"%>
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
    <link rel="icon" type="image/x-icon" href="assets/ToGather.ico" />
        <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    <link href="css/main.css" rel="stylesheet" />
    <script src="js/main.js" defer></script>
    <script src="js/splitting.js"></script>
    <script src="js/typed.js"></script>
  </head>
  <%! 	
  		Connection conn=null; 
  		Statement stmt = null;
  		ResultSet rs = null;
  		
  		String url="jdbc:oracle:thin:@localhost:1521:JAVA";
  		String user="togather";
  		String pwd="java";
  		String sql = "select * from GROUPTAB order by GSEQ desc";
  %>
  <% 
  try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, pwd);
		stmt = conn.prepareStatement(sql);
	}catch(ClassNotFoundException cnfe){
		System.out.println("#Oracle driver loading failed");
	}catch(SQLException se){
		System.out.println("#init() se: " + se);
	}
		ArrayList<GroupTab> groupList = new ArrayList<GroupTab>();
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("들어옴");
				long gSeq = rs.getLong(1);
				String gLoc = rs.getString(2);
				String gName = rs.getString(3);
				System.out.println(gName);
				String gIntro = rs.getString(4);
				String interest = rs.getString(5);
				int limit = rs.getInt(6);
				Date rdate = rs.getDate(7);
				long mNum = rs.getLong(8);	
				String fname = rs.getString(9);
				groupList.add(new GroupTab(gSeq, gLoc, gName, gIntro, interest, limit, rdate, mNum, fname));
			}
			
		}catch(SQLException se) {
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException se) {}
		}
	
  %>
  
  <body>
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light bg-gray">
      <div class="container px-4 px-lg-5">
        <h1 class="logo">
          <a href="index.html"
            ><img src="imgs/topLogo.png" alt="ToGather" title="홈으로 이동"
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
              onclick="location.href='group/groupTab.do?m=groupInput'"
            >
              <i class="bi bi-people-fill"></i>
              모임 만들기
            </button>
          </form>
        </div>
      </div>
    </nav>
    <!-- Header-->

    <header class="header">
      <div class="wrap">
        <div id="intro">
          <div class="typing">
            <span class="txt"></span>
          </div>
          <div class="video">
            <video
              source
              src="videos/background.mp4"
              type="video/mp4"
              autoplay
              loop
              muted
            ></video>
          </div>
        </div>
      </div>
    </header>

    <!--

            <div class="container px-4 px-lg-5 my-5">
                
                <div class="text-center text-white">
                    <a href="index.html"><img src="imgs/topLogoBig.png" alt="ToGather" title="홈으로 이동"/></a>
                    <h1 class="display-4 fw-bolder">ToGather에서 <br>자기개발과 취미생활을 <br>시작해보세요</h1>
                </div>
            </div>
    -->
    <!-- Section-->
   
    
    <section class="py-5">
      <div class="container px-4 px-lg-5 mt-5">
        <div
          class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
        >
        <% 
       	 for(GroupTab dto :groupList){
    	%>
          <div class="col mb-5">
            <div class="card h-100" style="overflow:hidden">
              <div
                class="badge bg-danger text-white position-absolute"
                style="top: 0.5rem; right: 0.5rem"
              >
                HOT
              </div>
              <!-- Product image-->
              <img class="card-img-top" style="width: 100%; height: 200px" src="upload_imgs/<%=dto.getFname()%>" alt="..." />
              <!-- Product details-->
              <div class="card-body p-4">
                <div class="text-center">
                  <!-- Product name-->
                  <h6 class="fw-bolder"><%=dto.getgLoc()%></h6>
                  <h4 class="fw-bolder"><%=dto.getgName()%></h4>
                  <!-- Product price-->
                  <%=dto.getgIntro()%>
                </div>
              </div>
              <!-- Product actions-->
              <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                <div class="text-center">
                  <a class="btn btn-outline-dark mt-auto" href="group/groupTab.do?m=groupInfo&gSeq=<%=dto.getgSeq()%>"
                    >둘러보기</a
                  >
                </div>
              </div>
            </div>
          </div>
        <%
        }
        %>
    </section>
  </body>
    <!-- Footer-->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">
          Team 1 &copy; 김진운 김지수 조현기 송보석 박범수 최대현
        </p>
      </div>
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
</html>
