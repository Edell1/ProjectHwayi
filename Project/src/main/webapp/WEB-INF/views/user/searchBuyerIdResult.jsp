<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매자 아이디 찾기 결과</title>
</head>
<body>
	<div class="container" style="margin-top: 100px">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="card shadow">
					<div class="card-body">
						<table width="1330px" border="0" height="430px" align="center">
							<tr>
								<td>
									<table width="450px" align="center" border="0"
										style="color: black; background-color: #F6F6F6; font-size: 20px;">
										<tr>
											<td>
												<table width="750px" align="center" border="0"
													style="background-color: white; margin-top: 3%">
													<c:choose>
														<c:when test="${not empty userId}">
															<tr>
																<td>${userName}님의아이디는</td>
															</tr>
															<tr>
																<td><h1>${userId}</h1>입니다.</td>
															</tr>
														</c:when>
														<c:otherwise>
															<tr>
																<td>${userName}님!</td>
															</tr>
															<tr>
																<td><h1>가입정보가 없습니다.</h1></td>
															</tr>
														</c:otherwise>
													</c:choose>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<table width="150px" align="center" border="0"
													style="margin-top: 1%">
													<tr>
														<c:choose>
															<c:when test="${not empty userId}">
																<td><form action="login_buyer" method="get">
																		<input type="submit" name="search" value="로그인하기"
																			class="btn btn-primary">
																	</form></td>
															</c:when>
															<c:otherwise>
																<td><a href="join_buyer"
																	class="btn btn-danger">회원가입</a></td>
																<td><a href="login_buyer"
																	class="btn btn-primary">로그인</a></td>
															</c:otherwise>
														</c:choose>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>