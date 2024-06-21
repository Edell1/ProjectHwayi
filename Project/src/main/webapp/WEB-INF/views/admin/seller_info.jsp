<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>판매자 정보</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/manage_nav.css' />" />
<link rel="stylesheet" href="<c:url value='/css/manage_mem.css' />" />
<script
	src="httpsa://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />
	<div class="admin_wrap">
		<c:import url="/WEB-INF/views/include/manage_nav.jsp" />
		<div id="layoutSidenav_content">
			<div class="container-fluid px-4">
				<div class="container">
					<div class="justify-content-md-center">
						<div class="row">
							<div class="m-auto mb-3 w-50 col">
								<c:set var="seller" value="${showSellerBean}" />
								<table class="table table-bordered text-center align-middle">
									<tr>
										<th colspan="3" class="table-active">
											<h1>회원 정보</h1>
										</th>
									</tr>
									<tr>
										<th colspan="2">회원명</th>
										<td>${seller.name}</td>
									</tr>
									<tr>
										<th colspan="2">아이디</th>
										<td>${seller.id}</td>
									</tr>
									<tr>
										<th colspan="2">이메일</th>
										<td>${seller.mail}</td>
									</tr>
									<tr>
										<th colspan="2">휴대전화</th>
										<td>${seller.phone}</td>
									</tr>
									<tr>
										<th rowspan="2">주소</th>
										<th>기본주소</th>
										<td>${seller.address}</td>
									</tr>
									<tr>
										<th>상세주소</th>
										<td>${seller.address2}</td>
									</tr>

									<tr>
										<th colspan="3" class="table-active">
											<h1>회원 정보</h1>
										</th>
									</tr>
									<tr>
										<th colspan="2">매장 이름</th>
										<td>${seller.brand}</td>
									</tr>
									<tr>
										<th colspan="2">사업자 번호</th>
										<td>${seller.strcode}</td>
									</tr>
									<tr>
										<th colspan="2">매장 전화번호</th>
										<td>${seller.strtel}</td>
									</tr>
									<tr>
										<th rowspan="2">주소</th>
										<th>기본주소</th>
										<td>${seller.straddress}</td>
									</tr>
									<tr>
										<th>상세주소</th>
										<td>${seller.straddress2}</td>
									</tr>
									<tr>
										<td><a href="${root}admin/review?key=id&val=${seller.id}"
											class="btn btn-secondary">리뷰</a></td>
										<td><a href="#" class="btn btn-secondary">문의</a></td>
										<td><a class="btn btn-secondary"
											href="${root}admin/seller_modify?id=${seller.id}">정보 수정</a></td>
									</tr>

								</table>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="card shadow">
					<div class="card-body">
						<table class="table table-hover" id='furniture_list'>
							<thead>
								<tr>
									<th colspan="7">
										<h1 class="card-title">가구</h1>
									</th>
								</tr>
								<tr>
									<th class="text-center d-none d-md-table-cell">상품종류</th>
									<th class="text-center d-none d-md-table-cell">상품명</th>
									<th class="text-center d-none d-md-table-cell">상품가격</th>
									<th class="text-center d-none d-md-table-cell">상품개수</th>
									<th class="text-center d-none d-md-table-cell">상품태그</th>
									<th class="text-center d-none d-md-table-cell">승인여부</th>
									<th class="text-center d-none d-md-table-cell">상세정보</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var='obj' items="${furniturelist}">
									<tr>
										<c:if test="${obj.code == seller.code}">
											<td class="text-center d-none d-md-table-cell">${obj.furniture_type }</td>
											<td class="text-center d-none d-md-table-cell">${obj.furniture_name}</td>
											<td class="text-center d-none d-md-table-cell">${obj.furniture_price}</td>
											<td class="text-center d-none d-md-table-cell">${obj.furniture_cnt}</td>
											<td class="text-center d-none d-md-table-cell">${obj.tag}</td>
											<td><c:choose>
													<c:when test="${obj.checked == 1}">
													미승인
													</c:when>
													<c:otherwise>
													승인
													</c:otherwise>
												</c:choose></td>
											<td>
												<div class="text-right">
													<a
														href="${root}admin/furniture_info?furnitureid=${obj.furnitureid }"
														class="btn btn-primary">정보보기</a>
												</div>
											</td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
	</div>
	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>
</html>