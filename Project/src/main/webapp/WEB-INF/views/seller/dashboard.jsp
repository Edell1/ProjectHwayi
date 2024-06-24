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
							<i class="fas fa-chart-area me-1"></i> 매장 별 판매수익
						</div>
						<div>
							<canvas class="mb-0" id="storeBarChart"></canvas>
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
			<div class="mgMem_inner admin_furn_gp row">
				<div class="tit">매장별 연간 매출 및 가구 비율</div>

				<div>
					<input type="radio" name="tabmenu" id="tab01" checked /> <label
						for="tab01">찬흠가구</label> <input type="radio" name="tabmenu"
						id="tab02" /> <label for="tab02">영민가구</label> <input type="radio"
						name="tabmenu" id="tab03" /> <label for="tab03">예림가구</label> <input
						type="radio" name="tabmenu" id="tab04" /> <label for="tab04">선정가구</label>
					<input type="radio" name="tabmenu" id="tab05" /> <label
						for="tab05">짱구가구</label> <input type="radio" name="tabmenu"
						id="tab06" /> <label for="tab06">철수가구</label> <input type="radio"
						name="tabmenu" id="tab07" /> <label for="tab07">유리가구</label> <input
						type="radio" name="tabmenu" id="tab08" /> <label for="tab08">훈이가구</label>
					<input type="radio" name="tabmenu" id="tab09" /> <label
						for="tab09">맹구가구</label> <input type="radio" name="tabmenu"
						id="tab10" /> <label for="tab10">수지가구</label>

					<div class="cont_wrap admin_furn">
						<div class="conbox con1">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> 1년간 월별 수입
								</div>
								<div>
									<canvas class="mb-0" id="store01BarChart"></canvas>
								</div>
							</div>
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
								</div>
								<div>
									<canvas class="mb-0" id="Store01PieChart"></canvas>
								</div>
							</div>
						</div>
						<div class="conbox con2">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> 1년간 월별 수입
								</div>
								<div>
									<canvas class="mb-0" id="store02BarChart"></canvas>
								</div>
							</div>
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
								</div>
								<div>
									<canvas class="mb-0" id="Store02PieChart"></canvas>
								</div>
							</div>
						</div>
						<div class="conbox con3">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> 1년간 월별 수입
								</div>
								<div>
									<canvas class="mb-0" id="store03BarChart"></canvas>
								</div>
							</div>
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
								</div>
								<div>
									<canvas class="mb-0" id="Store03PieChart"></canvas>
								</div>
							</div>
						</div>
						<div class="conbox con4">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> 1년간 월별 수입
								</div>
								<div>
									<canvas class="mb-0" id="store04BarChart"></canvas>
								</div>
							</div>
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
								</div>
								<div>
									<canvas class="mb-0" id="Store04PieChart"></canvas>
								</div>
							</div>
						</div>
						<div class="conbox con5">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> 1년간 월별 수입
								</div>
								<div>
									<canvas class="mb-0" id="store05BarChart"></canvas>
								</div>
							</div>
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
								</div>
								<div>
									<canvas class="mb-0" id="Store05PieChart"></canvas>
								</div>
							</div>
						</div>
						<div class="conbox con6">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> 1년간 월별 수입
								</div>
								<div>
									<canvas class="mb-0" id="store06BarChart"></canvas>
								</div>
							</div>
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
								</div>
								<div>
									<canvas class="mb-0" id="Store06PieChart"></canvas>
								</div>
							</div>
						</div>
						<div class="conbox con7">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> 1년간 월별 수입
								</div>
								<div>
									<canvas class="mb-0" id="store07BarChart"></canvas>
								</div>
							</div>
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
								</div>
								<div>
									<canvas class="mb-0" id="Store07PieChart"></canvas>
								</div>
							</div>
						</div>
						<div class="conbox con8">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> 1년간 월별 수입
								</div>
								<div>
									<canvas class="mb-0" id="store08BarChart"></canvas>
								</div>
							</div>
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
								</div>
								<div>
									<canvas class="mb-0" id="Store08PieChart"></canvas>
								</div>
							</div>
						</div>
						<div class="conbox con9">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> 1년간 월별 수입
								</div>
								<div>
									<canvas class="mb-0" id="store09BarChart"></canvas>
								</div>
							</div>
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
								</div>
								<div>
									<canvas class="mb-0" id="Store09PieChart"></canvas>
								</div>
							</div>
						</div>
						<div class="conbox con10">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> 1년간 월별 수입
								</div>
								<div>
									<canvas class="mb-0" id="store10BarChart"></canvas>
								</div>
							</div>
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-pie me-1"></i> 가구 별 판매비율
								</div>
								<div>
									<canvas class="mb-0" id="Store10PieChart"></canvas>
								</div>
							</div>
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