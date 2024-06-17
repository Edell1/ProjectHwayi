<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>구매자 정보</title>

<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/manage_nav.css' />" />
</head>
<body>
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />
	<div class="admin_wrap">
		<c:import url="/WEB-INF/views/include/manage_nav.jsp" />

		<div id="layoutSidenav_content">
			<div class="container-fluid px-4">
				<h1 class="mt-4">회원 정보</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">회원 관리</li>
				</ol>
				<hr />
				<div class="container">
					<div class="justify-content-md-center">
						<div class="row">
							<div class="m-auto mb-3 w-50 col">
								<c:set var="buyer" value="${showBuyerBean}" />
								<table class="table table-bordered text-center align-middle">
									<tr>
										<th colspan="3" class="table-active">기본 정보</th>
									</tr>
									<tr>
										<th colspan="2" width="50%">회원명</th>
										<td>${buyer.name}</td>
									</tr>
									<tr>
										<th colspan="2">아이디</th>
										<td>${buyer.id}</td>
									</tr>
									<tr>
										<th colspan="2">이메일</th>
										<td>${buyer.mail}</td>
									</tr>
									<tr>
										<th colspan="2">휴대전화</th>
										<td>${buyer.phone}</td>
									</tr>
									<tr>
										<th rowspan="2">주소</th>
										<th>기본주소</th>
										<td>${buyer.address}</td>
									</tr>
									<tr>
										<th>상세주소</th>
										<td>${buyer.address2}</td>
									</tr>
									<tr>
										<td colspan="3" class="text-left">
											<div class="float-start">
												<a href="${root}admin/review?key=id&val=${buyer.id}"
													class="btn btn-secondary">리뷰</a> <a href="#"
													class="btn btn-secondary">문의</a>
											</div>
											<button class="updateBtn"
												onclick="location.href='${root}admin/buyer_modify?id=${buyer.id}'">정보수정</button>
										</td>
									</tr>

								</table>
							</div>
							<%-- <div class="col">
								<div class="m-auto mb-3">
									<table class="table table-bordered text-center align-middle">
										<tr>
											<th colspan="4" class="table-active">기타 정보</th>
										</tr>
										<tr>
											<th width="25%">등급</th>
											<td width="25%">${obj.member_grade}</td>
											<th width="25%">관리자 여부</th>
											<td width="25%"><c:choose>
													<c:when test="${obj.member_ad == 1}">
													관리자
												</c:when>
													<c:otherwise>
													일반 회원
												</c:otherwise>
												</c:choose></td>
										</tr>
										<tr>
											<th>구독</th>
											<td></td>
											<th>접근</th>
											<td><c:choose>
													<c:when test="${obj.member_status == 1}">
													허용
												</c:when>
													<c:otherwise>
													차단
												</c:otherwise>
												</c:choose></td>
										</tr>
										<tr>
											<th>구매 횟수</th>
											<td>${obj.order_count}</td>
											<th>총구매금액</th>
											<td>${obj.purchase_amount}</td>
										</tr>
									</table>
								</div>
								<div class="m-auto mb-3">
									<table class="table table-sm text-center align-middle">
										<tr>
											<th colspan="3" class="table-active">배송지 목록</th>
										</tr>

										<tr>
											<th width="10%">번호</th>
											<th width="70%">배송지 이름</th>
											<th>보기</th>
										</tr>
										<c:forEach items="${addrList}" var="obj">
											<tr>
												<td>${obj.rownum}</td>
												<td>${obj.address_name}</td>
												<td>
													<button type="button" class="btn btn-secondary btn-sm"
														onclick="address_info('${obj.address_id}')">자세히
														보기</button>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
							<div class="m-auto mb-3">
								<table
									class="table table-sm table-hover text-center align-middle">
									<thead>
										<tr>
											<th colspan="5" class="table-active">주문 내역</th>
										</tr>
										<tr>
											<th>번호</th>
											<th>주문 ID</th>
											<th>주문 일자</th>
											<th>결제 방법</th>
											<th>주문 총액</th>
										</tr>
									</thead>
									<c:if test="${empty membersOrderBean}">
										<tr>
											<td colspan="5">주문이 없습니다.</td>
										</tr>
									</c:if>
									<c:forEach items="${membersOrderBean}" var="orderList">
										<tr
											onclick="location.href='${root}admin/order_info?order_id=${orderList.order_id}'">
											<td>${orderList.rownum}</td>
											<td>${orderList.order_id}</td>
											<td>${orderList.order_date}</td>
											<td>${orderList.order_method}</td>
											<td>${orderList.order_price}</td>
										</tr>
									</c:forEach>
								</table>
							</div> --%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>
</html>