<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<script>
	alert('상품 정보가 수정되었습니다.');
	location.href = '${root}seller/furniture_management?seller_code=${code}';
</script>