<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!-- 마이페이지 왼쪽 메뉴바 -->
<nav>
	<div class="tit">
		마이페이지
	</div>
	
	<div class="left_gnb">
		<ul>
			<li>쇼핑정보</li>
			<li class="border"></li>
			<li><a href="${root}user/mypage">마이페이지</a></li>
			<li><a href="${root}shop/order_info">주문목록/배송조회</a></li>
			<li><a href="#">취소/반품/교환 내역</a></li>
			<li><a href="${root}cart/cart_main">장바구니</a></li>
		</ul>
		<ul>
			<li>혜택관리</li>
			<li class="border"></li>
			<li><a href="#">쿠폰</a></li>
			<li><a href="#">적립금</a></li>
		</ul>
		<ul>
			<li>나의정보</li>
			<li class="border"></li>
			<li><a href="#">정보 관리</a></li>
		</ul>
		<ul>
			<li>고객서비스</li>
			<li class="border"></li>
			<li><a href="${root}customer_center/customer_center_main">FAQ</a></li>
			<li><a href="${root }admin/notice_list" class="sch_store">공지사항</a></li>
		</ul>
	</div>
</nav>