<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>판매자</title>

<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/seller_nav.css' />" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="seller_wrap">

		<nav>
			<div class="tit">판매자 페이지</div>

			<div class="left_gnb">
				<ul>
					<li>판매정보</li>
					<li class="border"></li>
					<li><a href="#">주문내역/배송상태</a></li>
					<li><a href="#">취소/반품/교환 내역</a></li>
				</ul>
				<ul>
					<li>판매통계</li>
					<li class="border"></li>
					<li><a href="#">통계</a></li>
					<li><a href="#">판매수익</a></li>
				</ul>
				<ul>
					<li>판매등록</li>
					<li class="border"></li>
					<li><a href="#">상품 등록</a></li>
					<li><a href="#">배너 등록</a></li>
				</ul>
				<ul>
					<li>나의정보</li>
					<li class="border"></li>
					<li><a href="#">정보 관리</a></li>
				</ul>
				<ul>
					<li>고객서비스</li>
					<li class="border"></li>
					<li><a href="#">FAQ</a></li>
					<li><a href="#">공지사항</a></li>
				</ul>
			</div>
		</nav>

		<div class="seller_main"></div>

	</div>

	<button id="topBtn" class="top-button" title="Go to top">Top</button>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>

<!-- script -->
<script src="${root}js/function.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/4cd100a941.js"
	crossorigin="anonymous"></script>
</html>