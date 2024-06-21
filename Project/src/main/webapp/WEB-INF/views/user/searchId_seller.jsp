<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 아이디 찾기</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/join.css' />" />
<link rel="stylesheet" href="<c:url value='/css/search_login.css' />" />
</head>
<body>
	<div class="join_container">
		<div class="top_box">
			<h1 class="tit">아이디 찾기</h1>
		</div>

		<div class="join_box" id="contents">
			<div class="join_box_inner">
				<div class="top_var">
					<a href="${root }main" class="home"> <i
						class="fa-solid fa-house"></i>
					</a>
				</div>

				<div class="search_box">
					<div class="search_box">
						<h2>이름과 핸드폰 번호를 입력해주세요.</h2>
					</div>

					<div class="join_cont">
						<div class="cont_box">
							<form:form name="searchId" method="post"
								action="searchSellerIdResult" modelAttribute="userBean">
								<div class="form-group">
									<form:label class="label_txt" path="name">이름</form:label>
									<form:input path="name" class="form-control" />
								</div>
								<div class="form-group">
									<form:label class="label_txt" path="phone">핸드폰번호</form:label>
									<form:input path="phone" class="form-control" />
								</div>

								<div class="login_flex_box">
									<input type="submit" name="search" value="찾기"
										class="btn btn-primary" style="vertical-align: middle;">
									<a href="login_seller"
										class="btn btn-primary">취소</a>
								</div>
							</form:form>
						</div>
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