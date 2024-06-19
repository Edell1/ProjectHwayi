<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>구매자 정보</title>
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
</head>
<body>
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />
	<div class="admin_wrap">
		<c:import url="/WEB-INF/views/include/manage_nav.jsp" />
		<div id="layoutSidenav_content">
			<div class="container-fluid px-4">
				<h1 class="mt-4">회원 정보</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">회원 관리</li>
				</ol>
				<hr />
				<div class="container">
					<div class="justify-content-md-center">
						<div class="m-auto mb-3 w-50">
							<form:form action="${root}admin/buyer_modify_pro" method="post"
								modelAttribute="modifyBuyerBean" class="form">
								<table class="table table-bordered text-center align-middle">
									<tr>
										<th colspan="3" class="table-active">기본 정보</th>
									</tr>
									<tr>
										<th colspan="2" width="50%">회원명</th>
										<td><input id="name" name="name"
											value="${modifyBuyerBean.name}" /></td>
									</tr>
									<tr>
										<th colspan="2">아이디</th>
										<td><form:input path="id" disabled="true" /> <form:hidden
												path="id" /></td>
									</tr>
									<tr>
										<th colspan="2">휴대전화</th>
										<td><input id="phone" name="phone"
											value="${modifyBuyerBean.phone}" /></td>
									</tr>
									<tr>
										<th colspan="2">이메일</th>
										<td><input id="mail" name="mail"
											value="${modifyBuyerBean.mail}" /></td>
									</tr>
									<tr>
										<th rowspan="2">주소</th>
										<th>기본주소</th>
										<td><input id="roadAddrPart1" name="address"
											value="${modifyBuyerBean.address}"></td>
									</tr>
									<tr>
										<th>상세주소</th>
										<td><input id="zipNo" name="address2"
											value="${modifyBuyerBean.address2}"></td>
									</tr>
									<tr>
										<td colspan="3">
											<button type="submit" class="btn btn-secondary">완료</button> <a
											href="${root}admin/buyer_info?id=${id}"
											class="btn btn-secondary">취소</a>
										</td>
									</tr>

								</table>
							</form:form>
							<div class="justify-content-center text-center"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>
</html>