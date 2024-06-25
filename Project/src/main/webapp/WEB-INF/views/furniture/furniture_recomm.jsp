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
			<div class="main_cont mcont1">
				<h2>
					<span>${loginUserBean.name}</span> 님께 추천드리는 상품
				</h2>

				<div class="furni_box">
					<div class="furni_cont cont1">
						<a
							href="${root }furniture/furniture_detail?furnitureid=dr1601000512">
							<div class="furni_img">
								<img src="${root}image/furniture1/dr1601000512.png" alt="상품이미지" />
								<div class="overlay"></div>
							</div>
							<div class="desc">
								<p>
								<p>미니 이동식 서랍장</p>
								<p>69,900 원</p>
							</div>
						</a>
					</div>

					<div class="furni_cont cont2">
						<a
							href="${root }furniture/furniture_detail?furnitureid=ca0102000501">
							<div class="furni_img">
								<img src="${root}image/furniture1/ca0102000501.png" alt="상품이미지" />
								<div class="overlay"></div>
							</div>
							<div class="desc">
								<p>
								<p>루버린 화이트 모던 티비다이</p>
								<p>624,000 원</p>
							</div>
						</a>
					</div>

					<div class="furni_cont cont3">
						<a
							href="${root }furniture/furniture_detail?furnitureid=hg0402030201">
							<div class="furni_img">
								<img src="${root}image/furniture1/hg0402030201.png" alt="상품이미지" />
								<div class="overlay"></div>
							</div>
							<div class="desc">
								<p>
								<p>3단 조절봉 철제 행거</p>
								<p>99,000 원</p>
							</div>
						</a>
					</div>

					<div class="furni_cont cont4">
						<a
							href="${root }furniture/furniture_detail?furnitureid=bs0306010320">
							<div class="furni_img">
								<img src="${root}image/furniture1/bs0306010320.png" alt="상품이미지" />
								<div class="overlay"></div>
							</div>
							<div class="desc">
								<p>
								<p>트루디 철제 매거진 랙 책꽂이 수납 진열대</p>
								<p>159,000 원</p>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>

		<div class="main_cont mcont2">
			<h2>
				<span>남성</span> 분들이 많이 찾는 상품이에요!
			</h2>

			<div class="furni_box">
				<div class="furni_cont cont1">
					<a
						href="${root }furniture/furniture_detail?furnitureid=ch0308000529">
						<div class="furni_img">
							<img src="${root}image/furniture1/ch0308000529.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>마블 게이밍의자 리클라이너 블랙팬서</p>
							<p>149,000 원</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont2">
					<a
						href="${root }furniture/furniture_detail?furnitureid=ca0303001001">
						<div class="furni_img">
							<img src="${root}image/furniture1/ca0303001001.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>네오 골드캐슬 거실장</p>
							<p>287,000 원</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont3">
					<a
						href="${root }furniture/furniture_detail?furnitureid=sf1212010927">
						<div class="furni_img">
							<img src="${root}image/furniture1/sf1212010927.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>딥블루 미니싱글 1인 리클라이너</p>
							<p>1,085,500 원</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont4">
					<a
						href="${root }furniture/furniture_detail?furnitureid=dr1206000213">
						<div class="furni_img">
							<img src="${root}image/furniture1/dr1206000213.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>케비넷 2단 서랍장</p>
							<p>69,900 원</p>
						</div>
					</a>
				</div>
			</div>
		</div>

		<div class="main_cont mcont3">
			<h2>
				<span>20대</span> 분들이 많이 찾는 상품이에요!
			</h2>

			<div class="furni_box">
				<div class="furni_cont cont1">
					<a
						href="${root }furniture/furniture_detail?furnitureid=mi1207000306">
						<div class="furni_img">
							<img src="${root}image/furniture1/mi1207000306.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>웨이브 전신거울</p>
							<p>107,500 원</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont2">
					<a
						href="${root }furniture/furniture_detail?furnitureid=dr0906000314">
						<div class="furni_img">
							<img src="${root}image/furniture1/dr0906000314.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>로티 회전 서랍장</p>
							<p>110,000 원</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont3">
					<a
						href="${root }furniture/furniture_detail?furnitureid=pa0501000406">
						<div class="furni_img">
							<img src="${root}image/furniture1/pa0501000406.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>타공판 파티션</p>
							<p>95,400 원</p>
						</div>
					</a>
				</div>

				<div class="furni_cont cont4">
					<a
						href="${root }furniture/furniture_detail?furnitureid=bs0102030328">
						<div class="furni_img">
							<img src="${root}image/furniture1/bs0102030328.png" alt="상품이미지" />
							<div class="overlay"></div>
						</div>
						<div class="desc">
							<p>
							<p>타워장식장 레고 피규어 장식장</p>
							<p>125,000 원</p>
						</div>
					</a>
				</div>
			</div>
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