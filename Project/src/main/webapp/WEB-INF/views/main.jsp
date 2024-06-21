<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HiF 쇼핑몰 메인</title>

<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/main_style.css' />" />
</head>

<body>
	<div class="top">
		<c:import url="/WEB-INF/views/include/top_menu.jsp" />
		<c:import url="/WEB-INF/views/include/nav_menu.jsp" />
	</div>

	<div class="slide_wrap">
		<div class="slider_box">
			<ul class="slider">
				<li><img src="./image/img1.avif" alt="배너1" /></li>
				<li><img src="./image/img2.avif" alt="배너2" /></li>
				<li><img src="./image/img3.avif" alt="배너3" /></li>
				<li><img src="./image/img4.avif" alt="배너4" /></li>
			</ul>
		</div>

		<div class="arrow">
			<a href="#" class="prev"><i class="fa-solid fa-arrow-left fa-3x"></i></a>
			<a href="#" class="next"><i class="fa-solid fa-arrow-right fa-3x"></i></a>
		</div>
	</div>

	<div class="main_wrap">
		<div class="main_cont mcont1">
			<h2>오늘의 추천 상품</h2>

			<div class="furni_box">
				<div class="furni_cont cont1">
					<a
						href="${root }furniture/furniture_detail?furnitureid=${obj.furnitureid}">
						<div class="furni_img">
							<img src="${root}image/furniture1/bs1402020224.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>파스텔 선반 아치형 수납장</p>
							<p>159,000 원</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont2">
					<a
						href="${root }furniture/furniture_detail?furnitureid=${obj.furnitureid}">
						<div class="furni_img">
							<img src="${root}image/furniture1/ch0204000520.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>좌식의자 리클라이너 생활방수</p>
							<p>36,800 원</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont3">
					<a
						href="${root }furniture/furniture_detail?furnitureid=${obj.furnitureid}">
						<div class="furni_img">
							<img src="${root}image/furniture1/bs0402020722.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>주방 거실 오브제 진열장 홈카페</p>
							<p>284,900 원</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont4">
					<a
						href="${root }furniture/furniture_detail?furnitureid=${obj.furnitureid}">
						<div class="furni_img">
							<img src="${root}image/furniture1/dk0102020316.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>제로 게이밍 컴퓨터 책상</p>
							<p>97,000 원</p>
						</div>
					</a>
				</div>
			</div>
		</div>

		<div class="main_cont mcont2">
			<h2>올 여름엔 이거!</h2>

			<div class="furni_box">
				<div class="furni_cont cont1">
					<a
						href="${root }furniture/furniture_detail?furnitureid=${obj.furnitureid}">
						<div class="furni_img">
							<img src="${root}image/furniture1/bs1402020224.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>파스텔 선반 아치형 수납장</p>
							<p>159000</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont2">
					<a
						href="${root }furniture/furniture_detail?furnitureid=${obj.furnitureid}">
						<div class="furni_img">
							<img src="${root}image/furniture1/ch0204000520.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>좌식의자 리클라이너 생활방수</p>
							<p>36800</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont3">
					<a
						href="${root }furniture/furniture_detail?furnitureid=${obj.furnitureid}">
						<div class="furni_img">
							<img src="${root}image/furniture1/bs0402020722.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>주방 거실 오브제 진열장 홈카페</p>
							<p>284900</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont4">
					<a
						href="${root }furniture/furniture_detail?furnitureid=${obj.furnitureid}">
						<div class="furni_img">
							<img src="${root}image/furniture1/dk0102020316.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>제로 게이밍 컴퓨터 책상</p>
							<p>97000</p>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>

	<button id="topBtn" class="top-button" title="Go to top">Top</button>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />

</body>

<!-- script -->
<script src="js/main.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/4cd100a941.js"
	crossorigin="anonymous"></script>

</html>
