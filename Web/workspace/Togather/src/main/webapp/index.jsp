<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
		<head>
				<link type="text/css" rel="stylesheet" href="./css/7.css">
				<link type="text/css" rel="stylesheet" href="./css/6.css">
				<link type="text/css" rel="stylesheet" href="./css/5.css">
				<meta charset="UTF-8">
				<title>ToGather</title>
				<style>
					header{height: 100px; border: 1px solid #253342; position: fixed;
							width: 100%; z-index: 9999; top: 0; left: 0;}
					h1{line-height: 50px;}
					.menu ul{
						list-style-type:none;
						float:right;
					}
					.menu li{
						display:inline;
					}
					.menu a{
						line-height: 100px; padding: 0 15px; list-style-type:none;
					}
					
					.wrapper{width: 1280px; margin: 0 auto;}
					.clearfix
				</style>
			<div id="warp">
				<div id="hd">
					<div class="hd-navi">
						<div class="container">
							<div class="hd-top">
								<h1 class="logo">
									<a href="togather/groupTab.do"><img src="./imgs/topLogo.png" alt="ToGather" title="인덱스로 이동"></a>
								</h1>
									<ul class="top-menu">
                                                <!-- snap common end -->
        
									<li>
										<a href="로그인링크넣기">LOGIN</a>
									</li>
									<li><a href="회원가입링크넣기">JOIN</a>
										<!-- 회원가입 포인트 -->
										<div id="joinpoint" style="top: 25.7163px;">
											<span class="point">회원가입 :)</span>
				
										</div>
									</li>
                                    <li>
										<a href="찜목록 링크 넣기">찜목록</a>
									</li>
									<li>
										<a href="내정보 링크넣기">MYPAGE</a>
									</li>
								</ul>
								</div>
								<nav>
									<ul class="menu">
										<li><a href="togather/groupTab.do?m=groupList">모임목록</a></li>
										<li><a href="">소개</a></li>
										<li><a href="">공지사항</a></li>
										<li><a href="">고객센터</a></li>
									</ul>
								</nav>
							</div>
							<div class="hd-icon-box">
                            <div class="hd-search">
                                <form action="" method="post" name="search">							
                                	<fieldset>
                                        <legend>상품 검색 폼</legend>
                                        <input name="search" onkeydown="CheckKey_search();" value="" class="MS_search_word input-keyword">								
                                        <a href="javascript:search_submit();"><img src="" alt="검색" title="검색"></a>
                                    </fieldset>
                                </form>
								<div class="icon-menu-box">
									<ul class="icon">
										<li class="btn_menu"><a href="">전체메뉴</a></li>
									</ul>
								</div>
								</div>
                    </div>
                </div>
            </div>
            <div id="hd_sitemap">
                <div class="container">
                    <div>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=127" class="point-color">세일 ~90%</a></dt>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=057">BEST</a></dt>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=112">NEW 7%</a></dt>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=133">총알배송</a></dt>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=075">1+1 기획전</a></dt>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=124">CODI SET</a></dt>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=161">BIG SIZE</a></dt>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=119">원마일룩</a></dt>
                            <dd><a href="/shop/shopbrand.html?xcode=119&amp;mcode=001">세트</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=119&amp;mcode=002">상의</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=119&amp;mcode=003">하의</a></dd>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=156">T-SHIRTS</a></dt>
                            <dd><a href="/shop/shopbrand.html?xcode=156&amp;mcode=004">반팔</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=156&amp;mcode=005">나시/민소매</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=156&amp;mcode=001">긴팔티</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=156&amp;mcode=003">맨투맨</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=156&amp;mcode=002">후드티</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=156&amp;mcode=006">니트</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=156&amp;mcode=007">폴라</a></dd>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=134">PANTS</a></dt>
                            <dd><a href="/shop/shopbrand.html?xcode=134&amp;mcode=005">반바지</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=134&amp;mcode=002">슬랙스</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=134&amp;mcode=007">카고/조거팬츠</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=134&amp;mcode=001">데님</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=134&amp;mcode=006">면바지</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=134&amp;mcode=004">밴딩팬츠</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=134&amp;mcode=003">트레이닝팬츠</a></dd>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=142">SHIRTS</a></dt>
                            <dd><a href="/shop/shopbrand.html?xcode=142&amp;mcode=002">베이직/데님</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=142&amp;mcode=004">반팔/7부셔츠</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=142&amp;mcode=001">체크/스트라이프</a></dd>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=003">OUTER</a></dt>
                            <dd><a href="/shop/shopbrand.html?xcode=003&amp;mcode=003">자켓/블레이저</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=003&amp;mcode=002">가디건</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=003&amp;mcode=001">코트</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=003&amp;mcode=006">점퍼/집업</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=003&amp;mcode=005">패딩</a></dd>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=103">SHOES</a></dt>
                            <dd><a href="/shop/shopbrand.html?xcode=103&amp;mcode=004">샌들/쪼리</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=103&amp;mcode=001">스니커즈/슬립온</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=103&amp;mcode=006">키높이신발</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=103&amp;mcode=003">로퍼/구두</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=103&amp;mcode=002">워커</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=103&amp;mcode=007">깔창</a></dd>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=002">ACC &amp; BAG</a></dt>
                            <dd><a href="/shop/shopbrand.html?xcode=002&amp;mcode=017">모자</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=002&amp;mcode=008">양말</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=002&amp;mcode=002">벨트</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=002&amp;mcode=006">쥬얼리/시계</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=002&amp;mcode=014">안경/선글라스</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=002&amp;mcode=009">라이프</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=002&amp;mcode=015">머플러/장갑</a></dd>
                            <dd><a href="/shop/shopbrand.html?xcode=002&amp;mcode=010">가방</a></dd>
                        </dl>
                        <dl>
                            <dt><a href="/shop/shopbrand.html?xcode=010">SUIT</a></dt>
                        </dl>
                    </div>
                    <div>
                        <dl>
                            <dt class="no-link">커뮤니티</dt>
                            <dd><a href="/board/board.html?code=superstari_board10">공지사항</a></dd>
                            <dd><a href="/board/board.html?code=superstari">고객센터</a></dd>
                            <dd><a href="/board/board.html?code=superstari_image12">상품리뷰</a></dd>
        
                        </dl>
                    </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</head>
	<body>
	</body>
</html>