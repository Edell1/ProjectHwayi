<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자 로그인</title>
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
<link rel="stylesheet" href="<c:url value='/css/join.css' />" />
</head>
<body>
	<div class="join_container">
		<div class="top_box">
			<h1 class="tit">관리자 로그인</h1>
		</div>
		<div class="join_box">
			<div class="join_box_inner">
				<div class="top_var">
					<a href="${root }admin/main" class="home"> <i
						class="fa-solid fa-house"></i>
					</a>
				</div>

				<div class="join_cont">
					<div class="cont_box">
						<form:form action="${root}admin/login_pro" method="post"
							modelAttribute="tempLoginBean">
							<div class="form-group">
								<form:label class="label_txt" path="id">아이디</form:label>
								<form:input path="id" class="form-control" />
								<form:errors class="err_txt" path="id" style='color:red' />
							</div>

							<div class="form-group">
								<form:label class="label_txt" path="pw">비밀번호</form:label>
								<form:password path="pw" class='form-control' />
								<form:errors class="err_txt" path='pw' style='color:red' />
							</div>

							<div class="form-group text-right">
								<form:button class='btn btn-primary'>로그인</form:button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- script -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/4cd100a941.js"
	crossorigin="anonymous"></script>
</html>








