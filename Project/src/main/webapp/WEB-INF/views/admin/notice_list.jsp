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
								<th width="50%">제목</th>
								<th>작성일</th>
								<th>조회수</th>
								<th>삭제</th>
							</tr>
						</thead>
						<c:choose>
							<c:when test="${empty noticeList}">
								<tr>
									<td colspan="6" class="text-center align-middle" height="100">등록된
										문의가 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${noticeList}" var="obj">
									<tr>
										<td><a
											href="${root}admin/notice_read?postID=${obj.postID}">${obj.noticeTitle}</a></td>
										<td>${obj.veiwCount}</td>
										<td><a href="${root}admin/notice_delete?postID=${postID}"
											class="btn btn-secondary btn-sm">삭제</a></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
					<div>
						<button class="uploadBtn"
							onclick="location.href='${root}admin/notice_write'">공지 작성</button>
					</div>
				</div>
			</div>
		</div>


	</div>
	<button id="topBtn" class="top-button" title="Go to top">Top</button>
	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />

</body>
</html>