<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HiF 쇼핑몰</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<script src="js/main.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/4cd100a941.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

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
		 <div class="cont1">
            <h2>오늘의 추천 상품</h2>
            <div class="item_box">
                <c:forEach var="product" items="${listOfProducts}">
                    <div class="product_item">
                        <img src="${root}image/${product.filename}" alt="상품사진" />
                        <div class="brand">${product.pBrand}</div>
                        <div class="ptit">${product.pname}</div>
                        <div class="price">${product.pPrice}원</div>
                        <a href="${root}product?id=${product.productId}" class="" role="button">상세보기&raquo;</a>
                    </div>
                </c:forEach>
            </div>
        </div>
	<div class="product_box">
	
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









