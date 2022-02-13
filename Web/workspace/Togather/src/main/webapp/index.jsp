<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
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
	</head>
	<body>
		<div id="hd">
			<div class="hd-navi">
				<div class="container">
					<div class="hd-top">
						<h1 class="logo">
							<a href="group/groupTab.do"><img src="imgs/topLogo.png" alt="ToGather" title="인덱스로 이동"></a>
							</h1>
						<nav>
							<ul class="menu">
								<li><a href="group/groupTab.do?m=groupList">모임목록</a></li>
								<li><a href="">소개</a></li>
								<li><a href="">공지사항</a></li>
								<li><a href="">고객센터</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>