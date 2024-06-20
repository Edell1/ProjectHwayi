<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<style>
.filter_dimensions .dimension_list {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.filter_dimensions .dimension_list div {
	display: flex;
	align-items: center;
}

.filter_dimensions .dimension_list div input {
	margin-left: 5px;
	width: 60px; /* 원하는 너비로 조정 가능 */
}
</style>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="furniture_list">
		<nav class="furni_nav">
			<ul>
				<li><a href="${root }furniture/furniture_list?furnitureType=bd">
						<i class="fa-solid fa-bed fa-3x"></i> <span>침대</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=dk">
						<i class="fa-solid fa-book fa-3x"></i> <span>책상/테이블</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=sf">
						<i class="fa-solid fa-couch fa-3x"></i> <span>소파</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=dr">
						<i class="fa-solid fa-inbox fa-3x"></i> <span>서랍장</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=ch">
						<i class="fa-solid fa-chair fa-3x"></i> <span>의자</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=sh">
						<i class="fa-solid fa-pallet fa-3x"></i> <span>선반</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=ca">
						<i class="fa-solid fa-tv fa-3x"></i> <span>TV장/거실장</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=bs">
						<i class="fa-solid fa-book fa-3x"></i> <span>책장</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=cl">
						<i class="fa-solid fa-door-closed fa-3x"></i><span>옷장</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=hg">
						<i class="fa-solid fa-door-closed fa-3x"></i><span>행거</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=pa">
						<i class="fa-solid fa-map fa-3x"></i> <span>파티션</span>
				</a></li>
				<li><a href="${root }furniture/furniture_list?furnitureType=mi">
						<i class="fa-solid fa-neuter fa-3x"></i> <span>거울</span>
				</a></li>

			</ul>
		</nav>

		<form id="filterForm" action="${root}furniture/furniture_list_filter"
			method="get">
			<div class="filter_box">
				<div class="filter_color">
					<div class="tit">색상</div>
					<div class="filter_list">
						<div>
							<input type="radio" name="color" class="color_box cb1" id="cb1"
								value="화이트" /> <label for="cb1"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb2" id="cb2"
								value="그레이" /> <label for="cb2"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb3" id="cb3"
								value="블랙" /> <label for="cb3"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb4" id="cb4"
								value="베이지" /> <label for="cb4"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb5" id="cb5"
								value="브라운" /> <label for="cb5"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb6" id="cb6"
								value="실버" /> <label for="cb6"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb7" id="cb7"
								value="골드" /> <label for="cb7"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb8" id="cb8"
								value="레드" /> <label for="cb8"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb9" id="cb9"
								value="옐로우" /> <label for="cb9"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb10" id="cb10"
								value="그린" /> <label for="cb10"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb11" id="cb11"
								value="오렌지" /> <label for="cb11"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb12" id="cb12"
								value="블루" /> <label for="cb12"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb13" id="cb13"
								value="네이비" /> <label for="cb13"></label>
						</div>
						<div>
							<input type="radio" name="color" class="color_box cb15" id="cb15"
								value="기타" /> <label for="cb15"></label>
						</div>
					</div>
				</div>
				<div class="filter_brand">
					<div class="tit">브랜드</div>
					<div class="filter_list">
						<div>
							<input type="radio" name="brand" id="br1" value="Se001" /> <label
								for="br1">찬흠가구</label>
						</div>
						<div>
							<input type="radio" name="brand" id="br2" value="Se002" /> <label
								for="br2">영민가구</label>
						</div>
						<div>
							<input type="radio" name="brand" id="br3" value="Se003" /> <label
								for="br3">예림가구</label>
						</div>
						<div>
							<input type="radio" name="brand" id="br4" value="Se004" /> <label
								for="br4">선정가구</label>
						</div>
						<div>
							<input type="radio" name="brand" id="br5" value="Se005" /> <label
								for="br5">짱구가구</label>
						</div>
						<div>
							<input type="radio" name="brand" id="br6" value="Se006" /> <label
								for="br6">철수가구</label>
						</div>
						<div>
							<input type="radio" name="brand" id="br7" value="Se007" /> <label
								for="br7">유라가구</label>
						</div>
						<div>
							<input type="radio" name="brand" id="br8" value="Se008" /> <label
								for="br8">훈이가구</label>
						</div>
						<div>
							<input type="radio" name="brand" id="br9" value="Se009" /> <label
								for="br9">맹구가구</label>
						</div>
						<div>
							<input type="radio" name="brand" id="br10" value="Se010" /> <label
								for="10">수지가구</label>
						</div>
					</div>
				</div>
				<!-- 가로, 세로, 높이 입력창 -->
				<div class="filter_dimensions">
					<div class="tit">사이즈</div>
					<div class="dimension_list">
						<div>
							<label for="width">가로: </label> <input type="number" name="width"
								id="width" placeholder="단위:cm" />
						</div>
						<div>
							<label for="length">세로: </label> <input type="number"
								name="length" id="length" placeholder="단위:cm" />
						</div>
						<div>
							<label for="height">높이: </label> <input type="number"
								name="height" id="height" placeholder="단위:cm" />
						</div>
					</div>
				</div>
				<button type="submit">필터 적용</button>
		</form>

		<div class="furni_box">
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