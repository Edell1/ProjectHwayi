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
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
				<li><a href=""> <img src="${root}image/memberPhoto.png"
						alt="" /> <span>선반</span>
				</a></li>
			</ul>
		</nav>
		<div class="filter_box">
			<div class="filter_color">
				<div class="tit">색상</div>
				<div class="filter_list">
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">빨</label>
					</div>
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">빨</label>
					</div>
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">빨</label>
					</div>
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">빨</label>
					</div>
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">빨</label>
					</div>
				</div>
			</div>
			<div class="filter_brand">
				<div class="tit">브랜드</div>
				<div class="filter_list">
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">영민가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">영민가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">영민가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">영민가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">영민가구</label>
					</div>
					<div>
						<input type="checkbox" id="cb1" /> <label for="cb1">영민가구</label>
					</div>
				</div>
			</div>
		</div>
		<div class="furni_box">
		<c:forEach var='obj' items="${furniturelist}">
			<div class="furni_cont cont1">
				<a href="">
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
<script src="${root }js/function.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/4cd100a941.js"
	crossorigin="anonymous"></script>
</html>