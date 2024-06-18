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
<title>가구 상세페이지</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet"
	href="<c:url value='/css/furniture_detail.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="furniture_wrap">
		<div class="furniture_detail">
			<div class="furn_img">
				<img src="./image/가구사진.avif" alt="" />
			</div>

			<div class="furn_box">
				<div class="furn_info">
					<ul class="info_detail">
						<li>
							<p>${furnitrueBean.brande}</p>
							<p>${furnitrueBean.id}</p>
							<p>${furnitrueBean.price}</p>
						</li>

						<li>
							<p>배송</p>
							<p>화이배송</p>
							<p>배송비 5000원</p>
						</li>
					</ul>
				</div>

				<div class="furn_choice">
					<div class="choice_tit">상품선택</div>
					<div class="choice_box">
						<div class="furn_name">${furnitrueBean.id}</div>
						<div class="btn_box">
							<button type="button" aria-label="수량 내리기" id="down"
								class="qtybtn" onclick="decrease()">-</button>
							<div class="count_number" id="product_qty">1</div>
							<button type="button" aria-label="수량 올리기" id="up" class="qtybtn"
								onclick="increase()">+</button>
						</div>
						<div class="furn_price">${furnitrueBean.price}원</div>
					</div>
				</div>

				<div class="total_price">
					<p>총 상품금액 :</p>
					<p>${furnitrueBean.price}</p>
					<p>원</p>
				</div>

				<div class="cart_buy">
					<button class="cart" type="button" onclick="addToCart()">
						<span id="go-cart">장바구니 담기</span>
					</button>
					<form id="gobuyForm" action="${root}shop/product_buy" method="post">
						<input type="hidden" name="productId" value="${furnitrueBean.id}" />
						<input type="hidden" name="memberId"
							value="${furnitrueBean.userid}" /> <input type="hidden"
							name="productQty" id="productQtyInput" value="1" />
					</form>
					<button class="buy" type="button" onclick="buy_product()">
						<span id="go-buy">상품 구매하기</span>
					</button>
				</div>
			</div>
		</div>
	</div>

	<div class="furn_nav">
		<ul>
			<li class="moreInfo"><a href="#moreInfoSection"><button
						class="coainer_name" onclick="go_explan()">상품정보</button></a></li>
			<li class="seller"><a href="#sellerSection"><button
						class="coainer_name" onclick="go_seller()">판매정보</button></a></li>
			<li class="review"><a href="#reviewSection"><button
						class="coainer_name" onclick="go_review()">리뷰</button></a></li>
			<li class="QnA"><a href="#QnASection"><button
						class="coainer_name" onclick="go_QnA()">문의</button></a></li>
		</ul>
	</div>

	<div class="detail_box">
		<div class="nav_detail">
			<div class="moreInfo_img" id="moreInfoSection">
				<img alt="상품상세정보이미지"
					src="${root}image/furniture/detail/${furnitrueBean.id}_detail.png" />
			</div>

			<div class="seller_section" id="sellerSection">
				<img alt="상품상세정보이미지"
					src="${root}image/furniture/detail/${furnitrueBean.id}_detail.png" />
			</div>

			<div class="review_section" id="reviewSection">
				<h3 class="sec-title">상품후기</h3>
				<table class="table" id="review_list">
					<thead>
						<tr>
							<th class="text">작성자</th>
							<th class="text">글내용</th>
							<th class="text">작성날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="obj" items="${reviewList }">
							<tr>
								<td class="text-center">${obj.member_id }</td>
								<td class="text-center">${obj.review_contents }</td>
								<td class="text-center">${obj.review_date }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="search-paging">
					<ul class="pagination">
						<c:choose>
							<c:when test="${pageBean.prevPage <= 0 }">
								<li class="page-item disabled"><a href="#"
									class="page-link">이전</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a
									href="${root }product/product_detail?product_id=${oneProductBean.product_id}&page=${pageBean.prevPage}#reviewSection"
									class="page-link">이전</a></li>
							</c:otherwise>
						</c:choose>

						<c:forEach var="idx" begin="${pageBean.min }"
							end="${pageBean.max }">
							<c:choose>
								<c:when test="${idx == pageBean.currentPage }">
									<li class="page-item active"><a
										href="${root }product/product_detail?product_id=${oneProductBean.product_id}&page=${idx}#reviewSection"
										class="page-link">${idx }</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										href="${root }product/product_detail?product_id=${oneProductBean.product_id}&page=${idx}#reviewSection"
										class="page-link">${idx }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:choose>
							<c:when test="${pageBean.max >= pageBean.pageCnt }">
								<li class="page-item disabled"><a href="#"
									class="page-link">다음</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a
									href="${root }product/product_detail?product_id=${oneProductBean.product_id}&page=${pageBean.nextPage}#reviewSection"
									class="page-link">다음</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>

			<div class="QnA_section" id="QnASection">
				<h3 class="sec-title">문의</h3>
				<form:form action="${root}product/product_ask"
					modelAttribute="productaskBean" method="post">
					<div class="form-group">
						<form:label path="board_title">제목</form:label>
						<form:input type="text" path="board_title" class="form-control"
							value="상품문의:${oneProductBean.product_name}" />
					</div>

					<div class="form-group">
						<form:label path="board_contents">내용</form:label>
						<form:textarea path="board_contents" class="form-control"
							rows="10" style="resize: none" />
					</div>

					<div class="form-group">
						<div class="text-right">
							<button type="submit" class="addToBoard">등록하기</button>
						</div>
					</div>
				</form:form>
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