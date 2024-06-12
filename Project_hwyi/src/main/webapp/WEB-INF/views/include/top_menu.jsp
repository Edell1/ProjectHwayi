<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!-- 상단 메뉴 부분 -->
<div class="top">
	<div class="gnb_bar">
		<a href="${root }main" class="logo">HiF</a>

		<form action="#" class="search">
			<input type="text" class="sch_txt" id="sch_str"
				placeholder="찾으시는 상품을 검색해주세요." />
			<button type="submit" id="sch_sub">검색</button>
		</form>

		<ul class="user_menu">
			<li><a href="${root}shopping/cart" class="cart">장바구니</a></li>
			<li><a href="#" class="sch_store">가까운 지점찾기</a></li>
			<li><a href="#" class="login">로그인</a></li>
			<li><a href="${root}user/join_choice" class="join">회원가입</a></li>
			<li><a href="${root}customer_center/customer_center_main" class="customer">고객센터</a></li>
		</ul>
	</div>

	<nav class="nav_bar">
		<ul class="nav_menu">
			<li><a href="${root}main" class="home">홈</a></li>
			<li><a href="#" class="home">추천</a></li>
			<li><a href="#" class="home">가구</a></li>
			<li><a href="#" class="home">인테리어</a></li>
			<li><a href="#" class="home">브랜드관</a></li>
		</ul>
	</nav>
</div>