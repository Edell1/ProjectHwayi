<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>마이페이지</title>

<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/mypage.css' />" />
<link rel="stylesheet" href="<c:url value='/css/mypage_nav.css' />" />
</head>
<body>
	<div class="top">
		<c:import url="/WEB-INF/views/include/top_menu.jsp" />
		<c:import url="/WEB-INF/views/include/nav_menu.jsp" />
	</div>

	<div class="flex_wrap">

		<c:import url="/WEB-INF/views/include/mypage_nav.jsp" />

		<div class="mypage_main">
			<div class="top_box">
				<div class="profile">
					<div class="memberPhoto">
						<img src="../image/memberPhoto.png" />
					</div>
					<div class="nickName">${loginUserBean.name} 님!</div>
				</div>

				<div class="couponBox">
					<div class="half-container left">
						<div class="icon_box">
							<img src="../image/reserve.png" class="reserve" />
							<div>
								<p>적립금</p>
								<p>3000원</p>
							</div>
						</div>
					</div>
					<div class="vertical-line"></div>
					<div class="half-container right">
						<div class="icon_box">
							<img src="../image/coupon.png" class="coupon" />
							<div>
								<p>쿠폰</p>
								<p>3장</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="orderInfo">
				<div class="tit">최근 주문 정보</div>

				<table class="order_table">
					<tr>
						<th>주문번호</th>
						<th>날짜</th>
						<th>상품명</th>
						<th>주문금액</th>
					</tr>
					<tr>
						<td>od01062601</td>
						<td>2024-06-26</td>
						<td>상품이름</td>
						<td>가격</td>
					</tr>
				</table>
			</div>
		</div>
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