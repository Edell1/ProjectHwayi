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
<link rel="stylesheet" href="<c:url value='/css/furniture_brand.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
</head>
<body>

	<div class="top">
		<c:import url="/WEB-INF/views/include/top_menu.jsp" />
		<c:import url="/WEB-INF/views/include/nav_menu.jsp" />
	</div>

	<div class="brand_wrap">
		<h2>브랜드별로 한 눈에 check! check!</h2>
		<div class="brand_box">
			<a class="cont cont1"
				href="${root}furniture/furniture_list_filter?color=화이트&brand=Se002&width=&length=&height=">
				<div class="img_box">
					<img src="${root}image/brand/furn1.avif" alt="브랜드1" />
					<div class="overlay">
						<div>영민가구</div>
						<div>
							#더욱 넓은 연출<br /> #깨끗함을 느낄 수 있는 거실<br /> #밝고 화사하게 연출되는 침실<br />
							#영민가구
						</div>
					</div>
				</div>
				<div class="txt">
					<h3>영민가구</h3>
					<p>
						거실, 침실 <span>신상</span> 기획전
					</p>
				</div>
			</a> <a class="cont cont2"
				href="${root}furniture/furniture_list_filter?color=그레이&brand=Se001&width=&length=&height=">
				<div class="img_box">
					<img src="${root}image/brand/furn2.avif" alt="브랜드1" />
					<div class="overlay">
						<div>찬흠가구</div>
						<div>
							#기다리던 새학기!<br /> #공부하는 아이들을 위한<br /> #깊은 수면을 할 수 있는 아이방<br />
							#찬흠가구
						</div>
					</div>
				</div>
				<div class="txt">
					<h3>찬흠가구</h3>
					<p>
						새학기 <span>신상</span> 기획전
					</p>
				</div>
			</a> <a class="cont cont3"
				href="${root}furniture/furniture_list_filter?color=브라운&brand=Se004&width=&length=&height=">
				<div class="img_box">
					<img src="${root}image/brand/furn3.avif" alt="브랜드1" />
					<div class="overlay">
						<div>선정가구</div>
						<div>
							#독서의 계절 가을<br /> #책을 위한 공간<br /> #틈새 공간 이용하기<br /> #선정가구
						</div>
					</div>
				</div>
				<div class="txt">
					<h3>선정가구</h3>
					<p>
						선반 <span>신상</span> 기획전
					</p>
				</div>
			</a> <a class="cont cont4" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn4.avif" alt="브랜드1" />
					<div class="overlay">
						<div>예림가구</div>
						<div>
							#차갑고 시크하게<br /> #나의 공간을 바꿔볼 수 있는 기회!<br /> #취미생활을 위한<br />
							#예림가구
						</div>
					</div>
				</div>
				<div class="txt">
					<h3>예림가구</h3>
					<p>
						거실장, 테이블 <span>신상</span> 기획전
					</p>
				</div>
			</a> <a class="cont cont5" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn5.avif" alt="브랜드1" />
					<div class="overlay">
						<div>짱구가구</div>
						<div>
							#서재 꾸미기<br /> #모던한 느낌의 테이블<br /> #다양한 형태<br /> #짱구가구
						</div>
					</div>
				</div>
				<div class="txt">
					<h3>짱구가구</h3>
					<p>
						테이블 <span>신상</span> 기획전
					</p>
				</div>
			</a> <a class="cont cont6" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn6.avif" alt="브랜드1" />
					<div class="overlay">
						<div>맹구가구</div>
						<div>
							#여름맞이<br /> #화사하게 꾸며보는 방<br /> #뜨거운 여름을 대비<br /> #맹구가구
						</div>
					</div>
				</div>
				<div class="txt">
					<h3>맹구가구</h3>
					<p>
						여름맞이 <span>신상</span> 기획전
					</p>
				</div>
			</a> <a class="cont cont7" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn7.avif" alt="브랜드1" />
					<div class="overlay">
						<div>철수가구</div>
						<div>
							#점점 늘어나는 짐<br /> #깔끔하게 정리할 수 있는<br /> #다양한 수납장<br /> #철수가구
						</div>
					</div>
				</div>
				<div class="txt">
					<h3>철수가구</h3>
					<p>
						수납 <span>신상</span> 기획전
					</p>
				</div>
			</a> <a class="cont cont8" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn8.avif" alt="브랜드1" />
					<div class="overlay">
						<div>유리가구</div>
						<div>
							#집을 원하는대로 꾸미자!<br /> #나의 감성에 딱맞는 가구<br /> #감성 가득한<br /> #유리가구
						</div>
					</div>
				</div>
				<div class="txt">
					<h3>유리가구</h3>
					<p>
						감성가구 <span>신상</span> 기획전
					</p>
				</div>
			</a>
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