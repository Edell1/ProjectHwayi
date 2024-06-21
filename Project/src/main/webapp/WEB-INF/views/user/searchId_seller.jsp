<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매자 아이디 찾기</title>
</head>
<body>
	<div class="container" style="margin-top: 100px">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="card shadow">
					<div class="card-body">
						<form:form name="searchId" method="post"
							action="searchSellerIdResult" modelAttribute="userBean">
							<table width="1330px" border="0" height="430px" align="center">
								<tr>
									<td>
										<table width="450px" align="center" border="0"
											style="color: black; background-color: #F6F6F6; font-size: 20px;">
											<tr>
												<td>
													<table width="750px" align="center" border="0"
														style="background-color: white; margin-top: 3%">
														<tr>
															<td>아이디 찾기</td>
															<td><div id="sub-title">| 회원정보에 등록한 정보로 인증.</div></td>
															<td style="width: 300px"></td>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td>
													<table width="600px" height="300px" align="center"
														border="0"
														style="background-color: none; border: dotted 5px none;">
														<tr>
															<td>
																<table width="400px" border="0" style="margin-top: 3%">
																	<tr>
																		<td><div id="middle-title">&nbsp;이름과 핸드폰
																				번호를 입력해주세요.</div></td>
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
															<td>
																<table width="380px" align="center" border="0"
																	style="font-size: 19px">
																	<tr>
																		<td>이름</td>
																		<td><form:input path="name" /></td>
																	</tr>
																	<tr>
																		<td>휴대폰</td>
																		<td><form:input path="phone" style="width: 100px" /></td>
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
															<td>
																<table width="150px" align="center" border="0"
																	style="margin-top: 1%">
																	<tr>
																		<td><input type="submit" name="search" value="찾기"
																			class="btn btn-primary"> <a
																			href="login_seller" class="btn btn-primary">취소</a>
																	</tr>
																</table>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</form:form>
					</div>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>