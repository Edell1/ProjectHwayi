<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입 선택</title>

<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/join_choice.css' />" />

</head>
<body>
	<div class="join_container">
		<div class="top_box">
			<h1 class="tit">회원유형 선택</h1>
		</div>

		<div class="join_box" id="contents">
			<div class="join_box_inner">
				<div class="top_var">
					<a href="${root }main" class="home"> <i
						class="fa-solid fa-house"></i>
					</a>
				</div>

				<div class="choice_box">
					<div class="cho_txt">
						<h2>회원가입</h2>
						<p class="title-desc">회원가입을 환영합니다.</p>
					</div>

					<ul class="choice">
						<li><a href="${root }user/join_buyer" id="buyer"> <i
								class="fa-regular fa-face-smile fa-5x"></i> <b>구매자</b>
								<p>구매자인 경우 가입이<br /> 가능합니다.</p>
						</a></li>
						<li><a href="${root }user/join_seller" id="seller"> <i
								class="fa-solid fa-face-smile fa-5x"></i> <b>판매자</b>
								<p>판매자인 경우 가입이<br /> 가능합니다.</p>
						</a></li>
					</ul>
					<p class="tail-desc">해당되는 항목을 선택하여 회원가입을 진행해 주시기 바랍니다.</p>
				</div>
				<!-- e: join -->
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









