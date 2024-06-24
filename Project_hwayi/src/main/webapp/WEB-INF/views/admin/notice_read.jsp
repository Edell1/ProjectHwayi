<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>문의글 수정하기</title>

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


		<div class="container">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<div class="card shadow">
						<div class="card-body">
							<div class="form-group">
								<label for="postDate">작성날짜</label> <input type="text"
									id="postDate" name="postDate" class="form-control"
									value="${showNoticeBean.postDate }" disabled="disabled" />
							</div>
							<div class="form-group">
								<label for="noticeTitle">제목</label> <input type="text"
									id="noticeTitle" name="noticeTitle" class="form-control"
									value="${showNoticeBean.noticeTitle }" disabled="disabled" />
							</div>
							<div class="form-group">
								<label for="content">내용</label>
								<textarea id="content" name="content"
									class="form-control" rows="10" style="resize: none"
									disabled="disabled">${showNoticeBean.content }</textarea>
							</div>
							<div class="form-group">
								<div class="text-right">
									<a
										href="${root}admin/notice_list"
										class="btn btn-primary">목록보기</a>
									<c:if
										test="${loginUserBean.userRole == 'admin' }">
										<a
											href="${root}admin/notice_delete?postID=${showNoticeBean.postID}"
											class="btn btn-danger">삭제하기</a>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-3"></div>
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