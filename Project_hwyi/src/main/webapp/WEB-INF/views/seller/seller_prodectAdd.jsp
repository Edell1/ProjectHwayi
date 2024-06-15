<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}/" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>판매상품 등록</title>
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/seller_productAdd.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="seller_wrap">

		<nav>
			<div class="tit">판매자 페이지</div>

			<div class="left_gnb">
				<ul>
					<li>판매정보</li>
					<li class="border"></li>
					<li><a href="#">주문내역/배송상태</a></li>
					<li><a href="#">취소/반품/교환 내역</a></li>
				</ul>
				<ul>
					<li>판매통계</li>
					<li class="border"></li>
					<li><a href="#">통계</a></li>
					<li><a href="#">판매수익</a></li>
				</ul>
				<ul>
					<li>판매등록</li>
					<li class="border"></li>
					<li><a href="#">상품 등록</a></li>
					<li><a href="#">배너 등록</a></li>
				</ul>
				<ul>
					<li>나의정보</li>
					<li class="border"></li>
					<li><a href="#">정보 관리</a></li>
				</ul>
				<ul>
					<li>고객서비스</li>
					<li class="border"></li>
					<li><a href="#">FAQ</a></li>
					<li><a href="#">공지사항</a></li>
				</ul>
			</div>
		</nav>

		<div class="seller_prodAdd">
			<div class="prodAdd_inner">
				<div class="tit">판매 상품 등록</div>

				<div class="flex_box">
					<form class="prodTable" id="prodAdd">
						<table>
							<tr>
								<th>상품명</th>
								<td><input type="text" name="productName" id="productName" />
								</td>
							</tr>
							<tr>
								<th>가격</th>
								<td><input type="text" name="productPraice"
									id="productPraice" /></td>
							</tr>
							<tr>
								<th>종류</th>
								<td>
									<form action="#">
										<select name="category" id="category">
											<option value="tb">침대</option>
											<option value="tb">소파</option>
											<option value="tb">선반</option>
											<option value="tb">거실장/티비장</option>
											<option value="tb">행거/옷장</option>
											<option value="tb">파티션</option>
											<option value="tb">서랍장</option>
											<option value="tb">거울</option>
											<option value="tb">의자</option>
											<option value="tb">책상/테이블</option>
											<option value="tb">책장</option>
											<option value="tb">커튼/블라인드</option>
										</select>
									</form>
								</td>
							</tr>
							<tr>
								<th>크기</th>
								<td><input type="text" name="productSize" id="productSize" />
								</td>
							</tr>
							<tr>
								<th>색상</th>
								<td>
									<form action="#">
										<select name="color" id="color">
											<option value="black">화이트</option>
											<option value="black">그레이</option>
											<option value="black">블랙</option>
											<option value="black">베이지</option>
											<option value="black">브라운</option>
											<option value="black">실버</option>
											<option value="black">골드</option>
											<option value="black">레드</option>
											<option value="black">옐로우</option>
											<option value="black">그린</option>
											<option value="black">오렌지</option>
											<option value="black">블루</option>
											<option value="black">네이비</option>
											<option value="black">핑크</option>
											<option value="black">기타</option>
										</select>
									</form>
								</td>
							</tr>
							<tr>
								<th>상품 이미지</th>
								<td><input type="file" name="productPhoto1"
									id="productPhoto1" /></td>
							</tr>
							<tr>
								<th>상품상세 이미지</th>
								<td><input type="file" name="productPhoto2"
									id="productPhoto2" /></td>
							</tr>
						</table>
					</form>

					<div class="btn_box">
						<button class="addBtn">등록하기</button>
						<button class="listBtn">목록보기</button>
					</div>
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