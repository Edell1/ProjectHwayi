<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!-- 상단 메뉴 부분 -->
<div class="top">
	<div class="gnb_bar">
		<a href="${root}main" class="logo">HiF</a>

		<form action="${root}furniture/furniture_list" method="get"
			class="search" role="search">
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

					<c:if test="${loginUserBean.userRole == 'buyer'}">
						<li class="nav-item"><a href="${root}user/mypage"
							class="nav-link">마이페이지</a></li>
						<li><a href="${root}cart/cart_main" class="cart">장바구니</a></li>
					</c:if>

					<c:if test="${loginUserBean.userRole == 'seller'}">
						<li><a href="${root}seller/furniture_management" class="admin">판매자</a></li>
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
			<li><a href="${root}customer_center/customer_center_main"
				class="customer">고객센터</a></li>
			<li><a href="${root }admin/notice_list" class="sch_store">공지사항</a></li>
			<li><a href="${root }chat" class="chat">AI ChatBot</a></li>
		</ul>
	</div>
</div>