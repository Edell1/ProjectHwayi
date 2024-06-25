<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>브랜드관</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/furniture_comm.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
</head>
<body>

	<div class="top">
		<c:import url="/WEB-INF/views/include/top_menu.jsp" />
		<c:import url="/WEB-INF/views/include/nav_menu.jsp" />
	</div>

	<div class="brand_wrap">
		<div class="comm_tit">
			<i class="fa-solid fa-hand-holding-heart fa-3x"></i>
			<h2>HiF에서 추천하는 가구를 둘러보세요!</h2>
			<i class="fa-solid fa-hand-holding-heart fa-3x"></i>
		</div>

		<div class="furni_box">
			<h3>솔데스크 님이 좋아하실만한 가구를 가져왔어요~</h3>
			
			<c:forEach var='obj' items="${checkedfurniturelist}">
				<div class="furni_cont cont1">
					<a
						href="${root }furniture/furniture_detail?furnitureid=${obj.furnitureid}">
						<div class="furni_img">
							<img src="${root}image/furniture1/${obj.furniture_img1}.png"
								alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>${obj.brand}</p>
							<p>${obj.furniture_name}</p>
							<p>${obj.furniture_price}원</p>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<button id="topBtn" class="top-button" title="Go to top">Top</button>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />

</body>

<!-- scripts -->
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