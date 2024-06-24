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
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
	$(document).ready(function() {

		IMP.init("imp30001824");
		$('#payButton').click(function() {
			var merchant_uid = $('#code').val();
			var fin_price = $('#fin_price').val();
			console.log(merchant_uid, fin_price);
			IMP.request_pay({
				pg : "kakaopay",
				pay_method : "card",
				amount : fin_price,
				name : 'HWAYI'
			}, function(response) {
				var result = response.error_msg === undefined;
				if (result) {
					submitOrder();
				} else {
				}
			});
		});

		function submitOrder() {
			// 폼 데이터 수집
			var address_id = $('#address-select').val();
			var member_id = $('#code').val();
			var order_price = $('#fin_price').val();
			// AJAX 요청 생성
			$.ajax({
				url : "${root}order/submitOrder",
				type : "POST",
				data : {
					address_id : address_id,
					member_id : member_id,
					order_price : order_price
				},
				success : function(response) {
					submitOrderDetail();
				},
				error : function(xhr, status, error) {
					// 오류 처리, 예: 오류 메시지 표시
					console.error("Order submission failed: ", status, error);
				}
			});
		}
		;

		$('#address-select').change(function() {
			var address_id = $(this).val();
			console.log(address_id);
			$.ajax({
				url : "${root}address/getAddress/" + address_id,
				type : "get",
				success : function(data) {
					console.log(data.member_name);
					$("#member-name").text(data.member_name);
					$("#member-phone").text(data.member_phone);
					$("#address-add").text(data.member_add);
					$("#address-addt").text(data.member_addt);
				},
			});
		});
	});

	function submitOrderDetail() {

		document.getElementById("order-detail-form").submit();

	};
</script>

</head>
<body>
	<div class="top">
		<c:import url="/WEB-INF/views/include/top_menu.jsp" />
		<c:import url="/WEB-INF/views/include/nav_menu.jsp" />
	</div>

	<div class="flex_wrap">
		<c:import url="/WEB-INF/views/include/mypage_nav.jsp" />
		<div class="order-container">
			<div class="tit">주문 / 결제</div>

			<div class="order-details">

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
									src="${root}image/furniture1/${productDetail.furnitureid}.png"
									width="90px" height="90px" /></td>
								<td>${productDetail.furniture_name}</td>
								<td>${productDetail.item_count}개</td>
								<td>${productDetail.furniture_price * productDetail.item_count}원</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form id="order-detail-form" action="${root}order/submitOrderDetail"
					method="post">
					<c:forEach items="${productDetails}" var="products">
						<input type="hidden" name="furnitureid"
							value="${products.furnitureid}" />
						<input type="hidden" name="order_product_stock"
							value="${products.item_count}" />
					</c:forEach>
				</form>
				<table class="table-order">
					<thead>
						<tr>
							<th colspan="2">주문자 정보</th>
						</tr>
					</thead>
					<tr>
						<th>주문자 성함</th>
						<td>${userBean.name }</td>
					</tr>
					<tr>
						<th>주문자 이메일</th>
						<td>${userBean.mail }</td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td>${userBean.phone}</td>
					</tr>
				</table>
			</div>
			<div class="address-list">
				<table class="table-order">
					<tr>
						<th colspan="4">배송지 선택</th>
					</tr>
					<tr>
						<th>배송지 이름</th>
						<td colspan="3"><select id="address-select">
								<c:forEach items="${addLists}" var="obj">
									<option value="${obj.address_id}">${obj.address_name}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th width="25%">수령인</th>
						<td id="member-name">${addLists[0].member_name}</td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td id="member-phone">${addLists[0].member_ph}</td>
					</tr>
					<tr>
						<th>주소</th>
						<td id="address-add" colspan="3">${addLists[0].member_add}</td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td id="address-addt" colspan="3">${addLists[0].member_addt}</td>
					</tr>
				</table>
			</div>
			<div class="pay">
				<table class="table-order">
					<tr>
						<th>상품 금액</th>
						<td>${totalPrice}원<input type="hidden" id="code"
							value="${code}" /> <input type="hidden" id="fin_price"
							value="${finalPrice}" />

						</td>

					</tr>
					<tr>
						<th>배송비</th>
						<td>5000 원</td>
					</tr>
					<tr>
						<th>결제 예정 금액</th>
						<td>${finalPrice}원</td>
					</tr>
					<tr>
						<td colspan="2"><a href="#" id="payButton">결제</a></td>
					</tr>
				</table>
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