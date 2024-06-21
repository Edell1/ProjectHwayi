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
<title>주문내역</title>

<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/order_info.css' />" />
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
			<div class="order-info">
				<div class="tit">주문내역조회</div>
				<div class="mid_tit">주문목록/배송조회 (최근 3개월 기준)</div>

				<div class="order_search">
					<input type="date" id="start-date" min="" /> ~ <input type="date"
						id="end-date" max="today" />
					<button type="submit" id="search" class="button">조회</button>
				</div>

				<div class="order">
					주문내역/배송조회 내역 총 0건
					<table class="order_list">
						<tr>
							<th>날짜/주문번호</th>
							<th>상품명</th>
							<th>수량</th>
							<th>상품구매금액</th>
							<th>주문처리상태</th>
							<th>취소/교환/반품</th>
						</tr>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
						</tr>
					</table>
				</div>
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









