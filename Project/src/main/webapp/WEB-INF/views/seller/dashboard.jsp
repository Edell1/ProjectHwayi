<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value='${pageContext.request.contextPath}/' />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>관리자 판매통계</title>

<link href="${root}css/admin_styles.css" rel="stylesheet" />
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/dash.css' />" />
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="admin_wrap">

		<c:import url="/WEB-INF/views/include/seller_nav.jsp" />

		<div class="manage_member">
			<div class="mgMem_inner admin_furn_gp">
				<div style="width: 650px">
					<div class="tit">
						<h2>종합 월간 매출 및 가구판매 비율</h2>
					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-chart-area me-1"></i> 월별 판매수익
						</div>
						<div>
							<canvas class="mb-0" id="myAreaChart"></canvas>
						</div>
					</div>
				</div>
				<div style="width: 650px">
					<div class="tit">
						<h2>.</h2>
					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
						</div>
						<div>
							<canvas class="mb-0" id="furniturePieChart"></canvas>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<button id="topBtn" class="top-button" title="Go to top">Top</button>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script src="${root}js/admin_scripts.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
	crossorigin="anonymous"></script>
<script src="${root}js/admin/chart-area-demo.js"></script>
<script src="${root}js/admin/chart-bar-admin.js"></script>
<script src="${root}js/admin/chart-pie-admin.js"></script>
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</html>