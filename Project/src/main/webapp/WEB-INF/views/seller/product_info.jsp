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
				<h1 class="mt-4">상품 정보</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">상품 관리</li>
				</ol>
				<hr />
				<div class="container">
					<div class="justify-content-md-center">
						<div class="row">
							<div class="m-auto mb-3 w-50 col">
								<form:form action="${root}seller/product_modify" method="post"
									modelAttribute="modifyProductBean" class="form">
									<table class="table table-bordered text-center align-middle">
										<tr>
											<th colspan="3" class="table-active">기본 정보</th>
										</tr>
										<tr>
											<th colspan="2" width="50%">상품명</th>
											<td>${modifyProductBean.furniture_name}</td>
										</tr>
										<tr>
											<th colspan="2">색상</th>
											<td>${modifyProductBean.furniture_color}</td>
										</tr>
										<tr>
											<th colspan="2">재질</th>
											<td>${modifyProductBean.furniture_mat}</td>
										</tr>
										<tr>
											<th rowspan="3">사이즈</th>
											<th>가로</th>
											<td>${modifyProductBean.furniture_width}<label>cm</label></td>
										</tr>
										<tr>
											<th>세로</th>
											<td>${modifyProductBean.furniture_length}<label>cm</label></td>
										</tr>
										<tr>
											<th>높이</th>
											<td>${modifyProductBean.furniture_height}<label>cm</label></td>
										</tr>
										<tr>
											<th colspan="2">가격</th>
											<td>${modifyProductBean.furniture_price}</td>
										</tr>
										<tr>
											<th colspan="2">수량</th>
											<td>${modifyProductBean.furniture_cnt}</td>
										</tr>
										<tr>
											<th colspan="1">상세설명</th>
											<td colspan="2">${modifyProductBean.tag}</td>
										</tr>
										<tr>
											<th colspan="3">이미지</th>
										</tr>
										<tr>
											<td colspan="3"><img
												src="${root}image/furniture1/${modifyProductBean.furniture_img1}.png"
												alt="상품이미지" /></td>
										</tr>


										<tr>
											<td colspan="3" class="text-left">
												<div class="float-start">
													<a
														href="${root}seller/product_modify?furnitureid=${modifyProductBean.furnitureid }"
														class="btn btn-secondary">수정하기</a> <a
														href="${root}seller/product_delete?furnitureid=${modifyProductBean.furnitureid }"
														class="btn btn-secondary">삭제하기</a>
												</div>
											</td>
										</tr>

									</table>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>
</html>