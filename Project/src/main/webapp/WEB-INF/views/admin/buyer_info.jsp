<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>구매자 정보</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
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
				<div class="tit pd_30">
					회원 정보 <span>회원 관리</span>
				</div>

				<div class="container flex mw">
					<div class="justify-content-md-center">
						<div class="row">
							<div class="m-auto mb-3 w-50 col">
								<c:set var="buyer" value="${showBuyerBean}" />
								<table class="table table-bordered text-center align-middle">
									<tr>
										<th colspan="3" class="table-active">기본 정보</th>
									</tr>
									<tr>
										<th colspan="2" width="50%">회원명</th>
										<td>${buyer.name}</td>
									</tr>
									<tr>
										<th colspan="2">아이디</th>
										<td>${buyer.id}</td>
									</tr>
									<tr>
										<th colspan="2">이메일</th>
										<td>${buyer.mail}</td>
									</tr>
									<tr>
										<th colspan="2">휴대전화</th>
										<td>${buyer.phone}</td>
									</tr>
									<tr>
										<th rowspan="2">주소</th>
										<th>기본주소</th>
										<td>${buyer.address}</td>
									</tr>
									<tr>
										<th>상세주소</th>
										<td>${buyer.address2}</td>
									</tr>
									<tr>
										<td><a href="${root}admin/review?key=id&val=${buyer.id}"
											class="btn btn-secondary">리뷰</a></td>
										<td><a href="#" class="btn btn-secondary">문의</a></td>
										<td><a class="updateBtn"
											href="${root}admin/buyer_modify?id=${buyer.id}">정보 수정</a></td>
									</tr>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />

</body>

<!-- script -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</html>