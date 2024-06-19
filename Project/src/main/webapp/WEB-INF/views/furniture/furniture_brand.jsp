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
<link rel="stylesheet"
	href="<c:url value='/css/furniture_brand.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="brand_wrap">
		<div class="brand_box">
			<a class="cont cont1" href="${root}furniture/furniture_list?furnitureType=bd">
				<div class="img_box">
					<img src="${root}image/brand/furn1.avif" alt="브랜드1" />
					<div class="overlay">
						<div>영민가구</div>
					</div>
				</div>
				<div class="txt">
					<h3>영민가구</h3>
					<p>
						거실, 침실 <span>신상</span> 기획전
					</p>
				</div>
			</a>
			<a class="cont cont2" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn2.avif" alt="브랜드1" />
					<div class="overlay">
						<div>찬흠가구</div>
					</div>
				</div>
				<div class="txt">
					<h3>찬흠가구</h3>
					<p>
						새학기 <span>신상</span> 기획전
					</p>
				</div>
			</a>
			<a class="cont cont3" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn3.avif" alt="브랜드1" />
					<div class="overlay">
						<div>선정가구</div>
					</div>
				</div>
				<div class="txt">
					<h3>선정가구</h3>
					<p>
						선반 <span>신상</span> 기획전
					</p>
				</div>
			</a>
			<a class="cont cont4" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn4.avif" alt="브랜드1" />
					<div class="overlay">
						<div>예림가구</div>
					</div>
				</div>
				<div class="txt">
					<h3>예림가구</h3>
					<p>
						거실장, 테이블 <span>신상</span> 기획전
					</p>
				</div>
			</a>
			<a class="cont cont5" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn5.avif" alt="브랜드1" />
					<div class="overlay">
						<div>행복가구</div>
					</div>
				</div>
				<div class="txt">
					<h3>행복가구</h3>
					<p>
						테이블 <span>신상</span> 기획전
					</p>
				</div>
			</a>
			<a class="cont cont6" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn6.avif" alt="브랜드1" />
					<div class="overlay">
						<div>솔가구</div>
					</div>
				</div>
				<div class="txt">
					<h3>솔가구</h3>
					<p>
						여름맞이 <span>신상</span> 기획전
					</p>
				</div>
			</a>
			<a class="cont cont7" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn7.avif" alt="브랜드1" />
					<div class="overlay">
						<div>데스크가구</div>
					</div>
				</div>
				<div class="txt">
					<h3>데스크가구</h3>
					<p>
						수납 <span>신상</span> 기획전
					</p>
				</div>
			</a>
			<a class="cont cont8" href="${root}furniture/furniture_list">
				<div class="img_box">
					<img src="${root}image/brand/furn8.avif" alt="브랜드1" />
					<div class="overlay">
						<div>좋은가구</div>
					</div>
				</div>
				<div class="txt">
					<h3>좋은가구</h3>
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
<script>
	function decrease() {
		let quantityElement = document.getElementById('product_qty');
		let currentQuantity = parseInt(quantityElement.textContent);

		if (currentQuantity > 1) {
			quantityElement.textContent = currentQuantity - 1;
			document.getElementById('productQtyInput').value = currentQuantity - 1;
		}
	}

	function increase() {
        let quantityElement = document.getElementById('product_qty');
        let currentQuantity = parseInt(quantityElement.textContent);
        
        quantityElement.textContent = currentQuantity + 1;
        document.getElementById('productQtyInput').value = currentQuantity + 1;
    }
	
	function addToCart() {
	    document.getElementById('addToCartForm').submit();
	}

	document.addEventListener('DOMContentLoaded', function() {
		const navLinks = document.querySelectorAll('.furn_nav ul li a');

		navLinks.forEach(function(link) {
			link.addEventListener('click', function(e) {
				e.preventDefault();
				const sectionId = this.getAttribute('href').substring(1); // 링크의 href에서 # 제거
				const section = document.getElementById(sectionId); // 해당 섹션 요소 가져오기
				if (section) {
					section.scrollIntoView({
						behavior : 'smooth'
					}); // 부드러운 스크롤
				}
			});
		});
	});
</script>
</html>