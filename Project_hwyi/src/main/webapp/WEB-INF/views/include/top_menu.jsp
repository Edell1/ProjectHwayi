<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!-- 상단 메뉴 부분 -->
<div class="top">
	<div class="gnb_bar">
		<a href="${root}main" class="logo">HiF</a>

		<form action="#" class="search">
			<input type="text" class="sch_txt" id="sch_str"
				placeholder="찾으시는 상품을 검색해주세요." />
			<button type="submit" id="sch_sub">검색</button>
		</form>

		<ul class="user_menu">
			<c:choose>
				<c:when test="${loginUserBean.userLogin}">
					<li>${loginUserBean.name }님</li>
					<li class="nav-item"><a href="${root}user/logout"
						class="nav-link">로그아웃</a></li>

					<c:if test="${loginUserBean.userRole == 'admin'}">
						<li><a href="${root}admin/main" class="admin">관리자</a></li>
					</c:if>

					<c:if test="${loginUserBean.userRole == 'seller'}">
						<li><a href="${root}seller/main" class="admin">판매자</a></li>
					</c:if>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a href="${root}user/login_choice"
						class="nav-link">로그인</a></li>
					<li class="nav-item"><a href="${root}user/join_choice"
						class="nav-link">회원가입</a></li>
				</c:otherwise>
			</c:choose>

			<!-- 로그인 상태에 관계없이 항상 표시되는 항목들 -->
			<li><a href="${root}cart/cart_main" class="cart">장바구니</a></li>
			<li><a href="#" class="sch_store">가까운 지점찾기</a></li>
<<<<<<< HEAD
			<li><a href="#" class="login">로그인</a></li>
			<li><a href="${root}user/join_choice" class="join">회원가입</a></li>
			<li><a href="${root}customer_center/customer_center_main" class="customer">고객센터</a></li>
			<li><a href="${root}admin/main" class="admin">관리자</a></li>
=======
			<li><a href="${root}customer_center/customer_center_main"
				class="customer">고객센터</a></li>
>>>>>>> refs/remotes/origin/heumE
		</ul>

	</div>

	<nav class="nav_bar">
		<ul class="nav_menu">
			<li><a href="${root}main" class="home">홈</a></li>
			<li><a href="#" class="home">추천</a></li>
			<li><a href="${root}furniture/furniture_list" class="furniture">가구</a></li>
			<li><a href="#" class="home">브랜드관</a></li>
		</ul>
	</nav>
</div>