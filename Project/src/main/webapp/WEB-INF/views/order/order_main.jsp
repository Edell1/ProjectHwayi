<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>주문페이지</title>
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/cart.css' />" />
<link rel="stylesheet" href="<c:url value='/css/mypage_nav.css' />" />
</head>
<body>
	<div class="top">
		<c:import url="/WEB-INF/views/include/top_menu.jsp" />
		<c:import url="/WEB-INF/views/include/nav_menu.jsp" />
	</div>

	<div class="flex_wrap">
		<c:import url="/WEB-INF/views/include/mypage_nav.jsp" />
		<div class="cart_contain">
			<div class="tit">주문 / 결제</div>
			<div class="top_box">

				<table class="table-order">
					<thead>
						<tr>
							<th colspan="4">주문 상품 목록</th>
						</tr>
						<tr>
							<th>이미지</th>
							<th>상품명</th>
							<th>수량</th>
							<th>가격</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productDetails}" var="productDetail"
							varStatus="proStatus">
							<tr>
								<td><img
									src="${root}image/product/thumb/${productDetail.product_id}_thumb.png"
									width="90px" height="90px" /></td>
								<td>${productDetail.product_name}</td>
								<td>${productDetail.quantity}개</td>
								<td>${productDetail.product_price * productDetail.quantity}원</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="btnBox">
					<a href="#" class="cartBtn delete_btn" onclick="deleteAllItems()">삭제하기</a>
					<a href="${root }order/order_main" class="cartBtn order_btn">주문하기</a>
				</div>
			</div>
		</div>
	</div>

	<button id="topBtn" class="top-button" title="Go to top">Top</button>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />

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

</body>
</html>