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
<title>장바구니</title>

<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/cart.css' />" />
<link rel="stylesheet" href="<c:url value='/css/mypage_nav.css' />" />
</head>
<body>
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />
	
	<div class="flex_wrap">
		<c:import url="/WEB-INF/views/include/mypage_nav.jsp" />
		<div class="cart_contain">
			<div class="tit">장바구니</div>
			<div class="top_box">
				<div>
					<input type="checkbox" id="allChk" /> <label for="allChk"><span>전체</span></label>
				</div>
				<div>
					<a href="#" class="cartBtn delete_btn">삭제하기</a> <a href="#"
						class="cartBtn order_btn">주문하기</a>
				</div>
			</div>
			<div class="bottom_box">
				<table class="cart_table">
					<tr>
						<th></th>
						<th>상품</th>
						<th>가격</th>
						<th>수량</th>
						<th>소계</th>
						<th></th>
					</tr>
					<c:forEach var="obj" items="${cartItems}">
						<tr>
							<td><input type="checkbox" class="chk" /></td>
							<td>${obj.furnitureid}</td>
							<td>${obj.price}</td>
							<td>${obj.count}</td>
							<td>${obj.price * obj.count}</td>
							<td><a href="#" class="cart_delete_btn">&nbsp;삭제</a></td>
						</tr>
					</c:forEach>
					<tr>
						<th></th>
						<th></th>
						<th>총액</th>
						<th>${totalPrice}</th>
						<th></th>
						<th></th>
					</tr>
				</table>
				<a href="${root}main?code=${param.code}" class="cartBtn back_btn">쇼핑
					계속하기</a>
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