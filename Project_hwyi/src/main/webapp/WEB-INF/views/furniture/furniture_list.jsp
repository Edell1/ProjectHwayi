<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}/" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가구 목록</title>

<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/furniture_list.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="furniture_list">
		<nav class="furni_nav">
			<ul>
				<li><a href=""> <i class="fa-solid fa-chair fa-3x"></i> <span>의자</span>
				</a></li>
				<li><a href=""> <i class="fa-solid fa-couch fa-3x"></i> <span>소파</span>
				</a></li>
				<li><a href=""> <i class="fa-solid fa-bed fa-3x"></i> <span>침대</span>
				</a></li>
				<li><a href=""> <i class="fa-solid fa-pallet fa-3x"></i> <span>선반</span>
				</a></li>
				<li><a href=""> <i class="fa-solid fa-tv fa-3x"></i> <span>티비장/거실장</span>
				</a></li>

				<li><a href=""> <i class="fa-solid fa-door-closed fa-3x"></i>
						<span>옷장/행거</span>
				</a></li>
				<li><a href=""> <i class="fa-solid fa-map fa-3x"></i> <span>파티션</span>
				</a></li>
				<li><a href=""> <i class="fa-solid fa-inbox fa-3x"></i> <span>서랍장</span>
				</a></li>
				<li><a href=""> <i class="fa-solid fa-person-booth fa-3x"></i>
						<span>커튼/블라인드</span>
				</a></li>
				<li><a href=""> <i class="fa-solid fa-neuter fa-3x"></i> <span>거울</span>
				</a></li>
				<li><a href=""> <i class="fa-regular fa-lightbulb fa-3x"></i>
						<span>조명</span>
				</a></li>
				<li><a href=""> <i class="fa-solid fa-book fa-3x"></i> <span>책장</span>
				</a></li>
				<li><a href=""> <i class="fa-solid fa-paint-roller fa-3x"></i>
						<span>페인트</span>
				</a></li>
			</ul>
		</nav>
	
		<div class="filter_box">
			<div class="filter_color">
				<div class="tit">색상</div>
				<div class="filter_list">
					<div>
						<input type="checkbox" class="color_box cb1" id="cb1" /> <label
							for="cb1"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb2" id="cb2" /> <label
							for="cb2"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb3" id="cb3" /> <label
							for="cb3"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb4" id="cb4" /> <label
							for="cb4"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb5" id="cb5" /> <label
							for="cb5"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb6" id="cb6" /> <label
							for="cb6"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb7" id="cb7" /> <label
							for="cb7"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb8" id="cb8" /> <label
							for="cb8"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb9" id="cb9" /> <label
							for="cb9"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb10" id="cb10" /> <label
							for="cb10"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb11" id="cb11" /> <label
							for="cb11"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb12" id="cb12" /> <label
							for="cb12"></label>
					</div>
					<div>
						<input type="checkbox" class="color_box cb13" id="cb13" /> <label
							for="cb13"></label>
					</div>
					<div>
						<input type="checkbox" class="cb15" id="cb15" /> <label
							for="cb15">기타</label>
					</div>
				</div>
			</div>
			<div class="filter_brand">
				<div class="tit">브랜드</div>
				<div class="filter_list">
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">선정가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb2" /> <label for="cb2">찬흠가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb3" /> <label for="cb3">예림가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb4" /> <label for="cb4">영민가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb5" /> <label for="cb5">행복가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb6" /> <label for="cb6">종로가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb7" /> <label for="cb7">솔가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb8" /> <label for="cb8">데스크가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb9" /> <label for="cb9">좋은가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb10" /> <label for="cb10">멋진가구</label>
					</div>
				</div>
			</div>
		</div>

		<div class="furni_box">
			<c:forEach var='obj' items="${furniturelist}">
				<div class="furni_cont cont1">
					<a href="${root}furniture/furniture_detail">
						<div class="furni_img">
							<img src="${root}image/bs0202040101.jpg" alt="" />
						</div>
						<div class="desc">
							<p>${obj.brand}</p>
							<p>${obj.furniture_name}</p>
							<p>${obj.furniture_price}</p>
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