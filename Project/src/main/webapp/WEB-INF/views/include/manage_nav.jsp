<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!-- 마이페이지 왼쪽 메뉴바 -->
<nav>
	<div class="tit">
		<a href="${root}admin/main">관리자 페이지</a>
	</div>

	<div class="left_gnb">
		<ul>
			<li>고객정보</li>
			<li class="border"></li>
			<li><a href="${root}admin/main">고객 관리</a></li>
		</ul>
		<ul>
			<li>등록관리</li>
			<li class="border"></li>
			<li><a href="#">가구점 등록 관리</a></li>
			<li><a href="${root}admin/furniture_admin">상품 등록 관리</a></li>
			<li><a href="#">배너 등록 관리</a></li>
		</ul>
		<ul>
			<li>판매통계</li>
			<li class="border"></li>
			<li><a href="${root}admin/dashboard">판매 통계</a></li>
		</ul>
		<ul>
			<li>공지등록/답변</li>
			<li class="border"></li>
			<li><a href="#">공지사항</a></li>
			<li><a href="#">QnA 답변</a></li>
		</ul>
	</div>
</nav>