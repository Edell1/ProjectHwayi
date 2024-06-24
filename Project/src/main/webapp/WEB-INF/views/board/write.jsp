<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var='root' value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>문의글 작성</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/write.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="card shadow">
					<div class="card-body">
						<form:form action="${root}board/write_pro" method="post"
							modelAttribute="writeQnABean" enctype="multipart/form-data">
							<div class="form-group">
								<form:label path="content_title">제목</form:label>
								<form:input path="content_title" class='form-control' />
								<form:errors path='content_title' style='color:red' />
							</div>
							<div class="form-group">
								<form:label path="content_subject">내용</form:label>
								<form:textarea path="content_subject" class="form-control"
									rows="10" style="resize:none" />
								<form:errors path='content_subject' style='color:red' />
							</div>
							<%-- <div class="form-group">
								<form:label path="upload_file">첨부 이미지</form:label>
								<form:input type='file' path='upload_file' class="form-control"
									accept="upload/*" />
							</div> --%>
							<div class="form-group">
							     <input type="hidden" name="secret" value="1"/>
								<form:checkbox path="secret" value="1" class="form-check-input" />
								<form:label path="secret" class="form-check-label">비밀글 여부</form:label>
							</div>
							<div class="form-group">
								<form:button class='btn btn-primary'>작성하기</form:button>
							</div>

						</form:form>
					</div>
				</div>
			</div>
			<div class="col-sm-3"></div>
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