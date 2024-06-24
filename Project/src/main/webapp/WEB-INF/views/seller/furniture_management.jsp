<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>판매자 상품관리</title>

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
		<c:import url="/WEB-INF/views/include/seller_nav.jsp" />
		<!-- 게시글 리스트 -->
		<div class="manage_member">
			<div class="mgMem_inner pd_30">
				<div class="tit">가구</div>
				
					<input type="radio" name="tabmenu" id="tab01" checked /> <label
						for="tab01">승인 완료</label> <input type="radio" name="tabmenu"
						id="tab02" /> <label for="tab02">승인 대기 / 거절</label>
					<div class="cont_wrap">
						<div class="conbox con1">
							<h3>[ 승인 완료 ]</h3>
							<table class="table table-hover scrollable-table" id='furniture_list'>
								<thead>
									<tr>
										<th class="text-center d-none d-md-table-cell">상품종류</th>
										<th class="text-center d-none d-md-table-cell">상품명</th>
										<th class="text-center d-none d-md-table-cell">상품가격</th>
										<th class="text-center d-none d-md-table-cell">상품개수</th>
										<th class="text-center d-none d-md-table-cell">상품태그</th>
										<th class="text-center d-none d-md-table-cell">상품 승인 여부</th>
										<th class="text-center d-none d-md-table-cell">등록일자</th>
										<th class="text-center d-none d-md-table-cell">상세정보</th>
									</tr>
								</thead>
								<tbody class="h600">
									<c:forEach var='fun' items="${furnitueListfromSeller}">
										<tr>
											<c:if test="${fun.furniture_checked == '승인완료'}">
												<td class="text-center d-none d-md-table-cell">${fun.furniture_type_text }</td>
												<td class="text-center d-none d-md-table-cell">${fun.furniture_name}</td>
												<td class="text-center d-none d-md-table-cell">${fun.furniture_price}</td>
												<td class="text-center d-none d-md-table-cell">${fun.furniture_cnt}</td>
												<td class="text-center d-none d-md-table-cell">${fun.tag}</td>
												<td class="text-center d-none d-md-table-cell">${fun.furniture_checked}</td>
												<td class="text-center d-none d-md-table-cell">${fun.furniture_date}</td>
												<td>
													<div class="text-right">
														<a
															href="${root}seller/product_info?furnitureid=${fun.furnitureid }"
															class="btn btn-primary">상세보기</a>
													</div>
												</td>
											</c:if>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="conbox con2">
							<h3>[ 승인 대기 / 거절 ]</h3>
							<table class="table table-hover" id='furniture_list'>
								<thead>
									<tr>
										<th class="text-center d-none d-md-table-cell">상품종류</th>
										<th class="text-center d-none d-md-table-cell">상품명</th>
										<th class="text-center d-none d-md-table-cell">상품가격</th>
										<th class="text-center d-none d-md-table-cell">상품개수</th>
										<th class="text-center d-none d-md-table-cell">상품태그</th>
										<th class="text-center d-none d-md-table-cell">상품 승인 여부</th>
										<th class="text-center d-none d-md-table-cell">등록일자</th>
										<th class="text-center d-none d-md-table-cell">상세정보</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var='fun' items="${furnitueListfromSeller}">
										<tr>
											<c:if test="${fun.furniture_checked != '승인완료'}">
												<td class="text-center d-none d-md-table-cell">${fun.furniture_type_text }</td>
												<td class="text-center d-none d-md-table-cell">${fun.furniture_name}</td>
												<td class="text-center d-none d-md-table-cell">${fun.furniture_price}</td>
												<td class="text-center d-none d-md-table-cell">${fun.furniture_cnt}</td>
												<td class="text-center d-none d-md-table-cell">${fun.tag}</td>
												<td class="text-center d-none d-md-table-cell">${fun.furniture_checked}</td>
												<td class="text-center d-none d-md-table-cell">${fun.furniture_date}</td>
												<td>
													<div class="text-right">
														<a
															href="${root}seller/product_info?furnitureid=${fun.furnitureid }"
															class="btn btn-primary">상세보기</a>
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

<script src="${root}js/function.js"></script>
<script
	src="httpsa://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</html>