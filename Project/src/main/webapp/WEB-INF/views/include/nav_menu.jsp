<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!-- 상단 메뉴 부분 -->

<nav class="nav_bar">
	<ul class="nav_menu">
		<li><a href="${root}main" class="home">홈</a></li>
		<li><a href="${root}furniture/furniture_recomm" class="recomm">추천</a></li>
		<li><a href="${root}furniture/furniture_list" class="furniture">가구</a></li>
		<li><a href="${root}furniture/furniture_brand" class="brand">브랜드관</a></li>
	</ul>
</nav>