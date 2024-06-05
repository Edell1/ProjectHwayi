<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>회원가입 - 유형선택</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value='/css/test.css' />" />
<link href="/ko/pc/css/notosanskr.css" rel="stylesheet">
<link href="https://use.typekit.net/kqw3ruj.css" rel="stylesheet">
<link rel="stylesheet" href="/css/style.min.css" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,500,600,700"
	rel="stylesheet">
</head>
<body class="">
	<!-- top_menu -->
	<%-- <c:import url="/WEB-INF/views/include/top_menu.jsp" /> --%>
	
	<div class="ly-container hub">
		<div class="ly-body">
			<div class="container" id="contents">
				<!-- s: sub-visual -->
				<div class="sub-visual">
					<h1 class="header-1">회원유형 선택</h1>
				</div>
				<!-- e: sub-visual -->
				<div class="sub-contents">
					<!-- s: location -->
					<div class="location-row">
						<div class="inner">
							<a href="${root }main" class="home">홈 바로가기</a>

						</div>
					</div>
					<!-- e: location -->
					<!-- s: join -->
					<div class="member-jogin step-01">
						<h2>회원가입</h2>
						<p class="title-desc">
							<b>회원가입</b>을 환영합니다.
						</p>
						<ul class="list">
							<li><a href="${root }user/join" id="buyer"> <b>구매자</b>
									<p>구매자인 경우 가입이 가능합니다.</p>
							</a></li>
							<li><a href="${root }user/join_seller" id="seller"> <b>판매자</b>
									<p>판매자인 경우 가입이 가능합니다.</p>
							</a></li>
						</ul>
						<p class="tail-desc">해당되는 항목을 선택하여 회원가입을 진행해 주시기 바랍니다.</p>
					</div>
					<!-- e: join -->
				</div>
			</div>
		</div>
	</div>

	<script src="/ko/pc/js/lib/jquery-3.3.1.min.js" type="text/javascript"></script>
	<script src="/ko/pc/js/lib/TweenMax.min.js" type="text/javascript"></script>
	<script src="/ko/pc/js/dev.js"></script>
	<script src="/ko/pc/js/common.js"></script>
</body>
</html>