<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>상품 등록 관리</title>

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
		
		<div class="container mw" style="margin-top: 100px">
			<div class="card shadow">
				<div class="card-body">
					<h4 class="card-title">가구</h4>
					<table class="table table-hover" id='furniture_list'>
						<thead>
							<tr>
								<th class="text-center d-none d-md-table-cell">상품종류</th>
								<th class="text-center d-none d-md-table-cell">상품명</th>
								<th class="text-center d-none d-md-table-cell">판매자</th>
								<th class="text-center d-none d-md-table-cell">상품가격</th>
								<th class="text-center d-none d-md-table-cell">상품개수</th>
								<th class="text-center d-none d-md-table-cell">상품태그</th>
								<th class="text-center d-none d-md-table-cell">상세정보</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var='obj' items="${furniturelist}">
								<tr>
									<c:choose>
										<c:when test="${obj.checked == 1}">
											<td class="text-center d-none d-md-table-cell">${obj.furniture_type }</td>
											<td class="text-center d-none d-md-table-cell">${obj.furniture_name}</td>
											<td class="text-center d-none d-md-table-cell">${obj.code}</td>
											<td class="text-center d-none d-md-table-cell">${obj.furniture_price}</td>
											<td class="text-center d-none d-md-table-cell">${obj.furniture_cnt}</td>
											<td class="text-center d-none d-md-table-cell">${obj.tag}</td>
											<td>
												<div class="text-right">
													<a
														href="${root}admin/furniture_info?furnitureid=${obj.furnitureid }"
														class="btn btn-primary">정보보기</a>
												</div>
											</td>
										</c:when>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- class="d-block d-md-block" (부트스트랩) -->
					<div class="d-block d-md-block">
						<ul class="pagination justify-content-center">
							<c:choose>
								<c:when test="${pageBean.prevPage <= 0}">
									<li class="page-item disabled"><a href="#"
										class="page-link">이전</a></li>
								</c:when>

								<c:otherwise>
									<li class="page-item"><a
										href="${root }board/main?board_info_idx=${board_info_idx}&page=${pageBean.prevPage}"
										class="page-link">이전</a></li>
								</c:otherwise>
							</c:choose>

							<c:forEach var="idx" begin="${pageBean.min}"
								end="${pageBean.max}">
								<c:choose>
									<c:when test="${idx == pageBean.currentPage }">
										<!--  현재페이지 색변경(active) -->
										<li class="page-item active"><a
											href="${root }board/main?board_info_idx=${board_info_idx}&page=${idx}"
											class="page-link">${idx }</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a
											href="${root }board/main?board_info_idx=${board_info_idx}&page=${idx}"
											class="page-link">${idx }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<!-- Max값이 전체페이지보다 크거나 같으면 비활성화 disabled(부트스트랩) -->
							<c:choose>
								<c:when test="${pageBean.max >= pageBean.pageCnt }">
									<li class="page-item disabled"><a href="#"
										class="page-link">다음</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										href="${root }board/main?board_info_idx=${board_info_idx}&page=${pageBean.nextPage}"
										class="page-link">다음</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
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