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


		<div id="layoutSidenav_content">
			<div class="container-fluid px-4">
				<h1 class="mt-4">공지 관리</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">공지 관리</li>
				</ol>
				<hr />
				<div class="m-3">
					<table class="table table-hover text-center align-middle">
						<thead>
							<tr>
								<th>번호</th>
								<th width="50%">제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>답변</th>
								<th>삭제</th>
							</tr>
						</thead>
						<c:choose>
							<c:when test="${empty askList}">
								<tr>
									<td colspan="6" class="text-center align-middle" height="100">등록된
										문의가 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${askList}" var="obj">
									<tr>
										<td>${obj.rownum}</td>
										<td><a
											href="${root}admin/ask_read?board_id=${obj.board_id}">${obj.board_title}</a></td>
										<td><a
											href="${root}admin/member_info?member_id=${obj.member_id}">${obj.member_id}</a></td>
										<td>${obj.board_date}</td>
										<td><c:choose>
												<c:when test="${obj.isAnswered == 0 }">
													<a
														href="${root}admin/answer_write?board_id=${obj.board_id}"
														class="btn btn-secondary btn-sm">답변하기</a>
												</c:when>
												<c:otherwise>
													<a href="${root}admin/ask_read?board_id=${obj.board_id}"
														class="btn btn-success btn-sm">답변보기</a>
												</c:otherwise>
											</c:choose></td>
										<td><a
											href="${root}admin/ask_delete?board_id=${board_id}"
											class="btn btn-secondary btn-sm">삭제</a></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
					<div class="d-none d-md-block">
						<ul class="pagination justify-content-center">
							<c:choose>
								<c:when test="${pageBean.prevPage <= 0}">
									<li class="page-item disabled"><a href="#"
										class="page-link">이전</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										href="${root}admin/ask?page=${pageBean.prevPage}"
										class="page-link">이전</a></li>
								</c:otherwise>
							</c:choose>

							<c:forEach var="idx" begin="${pageBean.min}"
								end="${pageBean.max}">
								<c:choose>
									<c:when test="${idx == pageBean.currentPage}">
										<li class="page-item active"><a
											href="${root}admin/ask?page=${idx}" class="page-link">${idx}</a>
										</li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a
											href="${root}admin/ask?page=${idx}" class="page-link">${idx}</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${pageBean.max >= pageBean.pageCnt }">
									<li class="page-item disabled"><a href="#"
										class="page-link">다음</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										href="${root}admin/ask?page=${pageBean.nextPage}"
										class="page-link">다음</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</div>
		</div>


	</div>
	<button id="topBtn" class="top-button" title="Go to top">Top</button>
	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />

</body>
</html>