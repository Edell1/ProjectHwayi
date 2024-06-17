<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자</title>

<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/manage_nav.css' />" />
<link rel="stylesheet" href="<c:url value='/css/manage_mem.css' />" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="admin_wrap">

		<c:import url="/WEB-INF/views/include/manage_nav.jsp" />

		<div class="manage_member">
			<div class="mgMem_inner">
				<div class="tit">회원 조회</div>

				<input type="radio" name="tabmenu" id="tab01" checked /> <label
					for="tab01">구매자 목록</label> <input type="radio" name="tabmenu"
					id="tab02" /> <label for="tab02">판매자 목록</label>

				<div class="cont_wrap">
					<div class="conbox con1">
						<h1>[ 구매자 회원 목록 ]</h1>
						<table class="buyer_table">
							<thead>
								<tr>
									<th class="th_column_1">이름</th>
									<th class="th_column_2">아이디</th>
									<th class="th_column_2">주소</th>
									<th class="th_column_3">전화번호</th>
									<th class="th_column_4">정보 수정</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="buyer" items="${buyerlist}">
									<tr>
										<td>${buyer.name}</td>
										<td>${buyer.id}</td>
										<td>${buyer.address}</td>
										<td>${buyer.phone}</td>
										<td><div class="btn_box">
												<button class="updateBtn"
													onclick="location.href='${root}admin/buyer_info?id=${buyer.id}'">정보수정</button>
											</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="conbox con2">
						<h1>[ 판매자 회원 목록 ]</h1>
						<table class="seller_table">
							<thead>
								<tr>
									<th class="th_column_1">이름</th>
									<th class="th_column_2">아이디</th>
									<th class="th_column_2">주소</th>
									<th class="th_column_3">사업자 번호</th>
									<th class="th_column_3">사업자 주소</th>
									<th class="th_column_3">사업자 전화번호</th>
									<th class="th_column_4">정보 수정</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="seller" items="${sellerlist}">
									<tr>
										<td>${seller.name}</td>
										<td>${seller.id}</td>
										<td>${seller.address}</td>
										<td>${seller.strcode}</td>
										<td>${seller.straddress}</td>
										<td>${seller.strtel}</td>
										<td><div class="btn_box">
												<button class="updateBtn"
													onclick="location.href='${root}admin/seller_info?id=${seller.id}'">정보수정</button>
											</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
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