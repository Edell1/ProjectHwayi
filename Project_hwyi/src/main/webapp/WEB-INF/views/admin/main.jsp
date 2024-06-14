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
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/manage_nav.css' />" />
<link rel="stylesheet" href="<c:url value='/css/manage_member.css' />" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />


	<div class="admin_wrap">

		<c:import url="/WEB-INF/views/include/manage_nav.jsp" />

		<div class="container" style="margin-top: 100px">
			<input type="radio" name="tabmenu" id="tab01" checked> <input
				type="radio" name="tabmenu" id="tab02">

			<div class="btn">
				<label for="tab01">구매자 목록</label> <label for="tab02">판매자 목록</label>
			</div>

			<div class="conbox con1">
				<h1>구매자 회원 목록입니다.</h1>
				<table class="seller_table">
					<thead>
						<tr>
							<th class="th_column_1">이름</th>
							<th class="th_column_2">아이디</th>
							<th class="th_column_2">주소</th>
							<th class="th_column_3">선호 태그</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="buyerlist" items="${buyerlist}">
							<tr>
								<td>${buyerlist.name}</td>
								<td>${buyerlist.ID}</td>
								<td>${buyerlist.address}</td>
								<td>${buyerlist.favarite}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="conbox con2">
				<h1>판매자 회원 목록입니다.</h1>
				<table class="seller_table">
					<thead>
						<tr>
							<th class="th_column_1">이름</th>
							<th class="th_column_2">아이디</th>
							<th class="th_column_2">주소</th>
							<th class="th_column_3">사업자 번호</th>
							<th class="th_column_3">사업자 주소</th>
							<th class="th_column_3">사업자 전화번호</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="seller" items="${sellerlist}">
							<tr>
								<td>${seller.name}</td>
								<td>${seller.ID}</td>
								<td>${seller.address}</td>
								<td>${seller.strcode}</td>
								<td>${seller.straddress}</td>
								<td>${seller.strtel}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
		</div>

	</div>
	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>

</html>