<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 아이디 찾기 결과</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/join.css' />" />
<link rel="stylesheet" href="<c:url value='/css/login_result.css' />" />
</head>
<body>

	<div class="join_container">
		<div class="top_box">
			<h1 class="tit">판매자 아이디 찾기 결과</h1>
		</div>

		<div class="join_box" id="contents">
			<div class="join_box_inner">
				<div class="top_var">
					<a href="${root }main" class="home"> <i
						class="fa-solid fa-house"></i>
					</a>
				</div>

				<div class="search_box">
					<table class="result_table">
						<c:choose>
							<c:when test="${not empty userId}">
								<tr>
									<td>${userName}님의 아이디는</td>
								</tr>
								<tr>
									<td><h1>${userId}</h1>입니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td>${userName}님!</td>
								</tr>
								<tr>
									<td><h1>가입정보가 없습니다.</h1></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
					<table class="result_table btn_table">
						<tr>
							<c:choose>
								<c:when test="${not empty userId}">
									<td>
										<form action="login_seller" method="get">
											<input type="submit" name="search" value="로그인하기"
												class="btn btn-primary">
										</form>
									</td>
								</c:when>
								<c:otherwise>
									<td><a href="join_seller" class="btn btn-primary">회원가입</a></td>
									<td><a href="login_seller" class="btn btn-primary">로그인</a></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>