<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>고객센터</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet"
	href="<c:url value='/css/customer_center_main.css' />" />
</head>
<body>
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />
	<div class="customer_center_top">
		<div class="FAQ_box">
			<h2>자주 묻는 질문</h2>
			<div class="frequently_question">
				<input type="checkbox" id="answer01" /> <label for="answer01">
					<i class="fa-solid fa-q fa-2x"></i> <span>배송은 얼마나 걸리나요?</span> <i
					class="fa-solid fa-angle-down"></i> <i class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						상품 배송 기간은 배송 유형에 따라 출고 일자 차이가 있습니다.<br />자세한 사항은 구매하신 상품의 상세
						페이지에서 확인 가능하며,<br />배송 유형 별 기본 출고 기간은 아래와 같습니다.<br />∙ 일반 택배 /
						화물 택배 : 결제 후 1~3 영업일 이내 출고됩니다. <br />∙ 업체 직접 배송 : 배송 지역에 따라 배송
						일자가 상이할 수 있으므로<br /> 상품 상세 페이지에서 확인 해주세요. <br />※ 영업일은 주말, 공휴일을
						제외한 기간입니다. <br />※ 제조사의 사정에 따라 출고일은 지연될 수 있는 점 양해 부탁드립니다.
					</p>
				</div>
				<input type="checkbox" id="answer02" /> <label for="answer02">
					<i class="fa-solid fa-q fa-2x"></i> <span>주문 취소는 어떻게 하나요?</span> <i
					class="fa-solid fa-angle-down"></i> <i class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						판매처에서 주문을 확인하기 전이라면 언제든 취소하실 수 있으며,<br /> [나의 쇼핑 > 주문배송내역 조회 >
						주문상세보기]에서 직접 주문취소하실 수 있습니다. <br />※ 이미 판매처에서 상품을 확인해 준비 중이라면, 직접
						취소가 어렵습니다.<br /> 상세 페이지에 확인되는 판매자 연락처 또는 오늘의집 고객센터로 문의 부탁드립니다.
					</p>
				</div>
				<input type="checkbox" id="answer03" /> <label for="answer03">
					<i class="fa-solid fa-q fa-2x"></i> <span>제품의 자세한 정보를 알고
						싶어요.</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						각 제품의 상세 페이지에서 확인 가능하며, 더욱 자세한 정보는<br /> 제품상세페이지 내 문의하기를 통해 판매 업체
						문의 가능합니다.
					</p>
				</div>
				<input type="checkbox" id="answer04" /> <label for="answer04">
					<i class="fa-solid fa-q fa-2x"></i> <span>제품이 불량일 때는?</span> <i
					class="fa-solid fa-angle-down"></i> <i class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						업체(브랜드)마다 발송처 및 반품절차가 다릅니다. <br />- 우측 상단 프로필 사진을 클릭 후 [나의쇼핑]
						페이지에서 원하는 주문의 상세보기 버튼을<br /> 클릭 후 교환/반품 접수 후 진행 할수 있습니다. 교환/반품 접수
						없이 임의로 반송한 경우에는 처리가 늦어질 수 있습니다. <br />- 교환/반품 접수 시 원활한 처리를 위해 불량
						사진이 필요하오니, 가급적 사진을 첨부하여<br /> 주시기 바랍니다. <br />단, 구매확정 이후 교환/반품을
						원하시는 경우 판매 업체에 교환/반품 가능 여부를<br /> 먼저 문의 부탁드립니다.
					</p>
				</div>
				<input type="checkbox" id="answer05" /> <label for="answer05">
					<i class="fa-solid fa-q fa-2x"></i> <span>카카오 계정으로 로그인하면 이미
						가입되었다고 합니다.</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						휴대전화 번호를 변경하셨거나 카카오톡 계정을 탈퇴하고 새로 가입하신 경우<br /> 이런 문제가 발생할 수 있습니다.<br />이
						경우 새로운 정보가 반영될 수 있도록 번거로우시더라도 고객센터로 문의 부탁드립니다. <br />오늘의집 고객센터
						1670-0876 (운영 시간 : 평일 09:00~18:00)<br /> - 마이페이지 > 나의 쇼핑 > 고객센터 >
						1:1 카톡 상담하기 - 카카오 플러스친구 '오늘의집 고객센터'로 문의
					</p>
				</div>
			</div>
		</div>
		<div class="QNA_box">
			<h2>QnA</h2>
			<a href="${root}customer_center/main" class="btn btn-primary">QnA</a>
		</div>
	</div>
	<div class="bott_box">
		<div class="">
			<input type="radio" name="tabmenu" id="tab01" checked /> <input
				type="radio" name="tabmenu" id="tab02" /> <input type="radio"
				name="tabmenu" id="tab03" /> <input type="radio" name="tabmenu"
				id="tab04" /> <input type="radio" name="tabmenu" id="tab05" />
			<div class="btn">
				<label for="tab01">주문/결제</label> <label for="tab02">취소/환불</label> <label
					for="tab03">반품/교환</label> <label for="tab04">로그인/회원정보</label> <label
					for="tab05">서비스/기타</label>
			</div>
			<div class="conbox con1">
				<input type="checkbox" id="que01" /> <label for="que01"> <i
					class="fa-solid fa-q fa-1x"></i> <span>주문 내역은 어떻게 확인할 수 있나요?</span>
					<i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>우측 상단 프로필 사진을 클릭 후 [나의쇼핑]을 통해 확인 가능합니다.</p>
				</div>
				<input type="checkbox" id="que02" /> <label for="que02"> <i
					class="fa-solid fa-q fa-1x"></i> <span>결제 방법은 어떤 것이 있나요?</span> <i
					class="fa-solid fa-angle-down"></i> <i class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>신용카드 및 체크카드, 무통장 입금, 휴대폰 소액결제, 네이버페이를 이용해 결제 가능합니다.</p>
				</div>
				<input type="checkbox" id="que03" /> <label for="que03"> <i
					class="fa-solid fa-q fa-1x"></i> <span>비회원 주문 및 전화 주문이
						가능한가요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						전화주문은 준비중에 있습니다.<br /> 비회원 주문은 가능하지만 일부 상품에 한해 제한되어있습니다.
					</p>
				</div>
				<input type="checkbox" id="que04" /> <label for="que04"> <i
					class="fa-solid fa-q fa-1x"></i> <span>신용카드 무이자 할부가 되나요?</span> <i
					class="fa-solid fa-angle-down"></i> <i class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>각 카드사 별로 상이하며, 카드사를 통해 확인 가능합니다.</p>
				</div>
				<input type="checkbox" id="que05" /> <label for="que05"> <i
					class="fa-solid fa-q fa-1x"></i> <span>주문 후 결제 방법을 변경하고 싶은데
						어떻게 해야 하나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						결제 후 결제 정보 변경은 불가능 합니다.<br />단, 입금 대기 및 결제 완료 단계에서는 취소 후 재주문을 통해
						변경 가능합니다.
					</p>
				</div>
				<input type="checkbox" id="que06" /> <label for="que06"> <i
					class="fa-solid fa-q fa-1x"></i> <span>결제 시 에러 메시지가 나오는 경우
						어떻게해야 하나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>우측 상단 프로필 사진을 클릭 후 [나의쇼핑 > 고객센터 > 1:1 카톡 상담하기]를 통해 문의
						부탁드립니다.</p>
				</div>
				<input type="checkbox" id="que07" /> <label for="que07"> <i
					class="fa-solid fa-q fa-1x"></i> <span>신용카드 안전결제(ISP)는
						무엇인가요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						국민카드, BC카드는 인터넷 안전결제(ISP)로 결제가 진행됩니다.<br />결제진행시 나타나는 안내에 따라 결제하실
						카드번호와 사용하시는 이메일 및 비밀번호를 입력하여 인터넷 안전결제(ISP)등록 후 결제를 진행해 주시면 됩니다.<br />
						단, 30만원 이상 결제 시에는 공인인증서가 필요합니다.
					</p>
				</div>
			</div>
			<div class="conbox con2">
				<input type="checkbox" id="que08" /> <label for="que08"> <i
					class="fa-solid fa-q fa-1x"></i> <span>주문 취소는 어떻게 하나요?</span> <i
					class="fa-solid fa-angle-down"></i> <i class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						판매처에서 주문을 확인하기 전이라면 언제든 취소하실 수 있으며, [나의 쇼핑 > 주문배송내역 조회 > 주문상세보기]에서
						직접 주문취소하실 수 있습니다.<br /> ※ 이미 판매처에서 상품을 확인해 준비 중이라면, 직접 취소가 어렵습니다.
						상세 페이지에 확인되는 판매자 연락처 또는 오늘의집 고객센터로 문의 부탁드립니다.
					</p>
				</div>
				<input type="checkbox" id="que09" /> <label for="que09"> <i
					class="fa-solid fa-q fa-1x"></i> <span>취소 후 환불은 언제되나요?</span> <i
					class="fa-solid fa-angle-down"></i> <i class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						신용카드 및 체크카드의 경우 카드사에서 확인 절차를 거치는 관계로 평균 3~7일 영업일 이내 환불처리가 완료됩니다.<br />
						무통장 입금의 경우 평균 5영업일 이내 요청 하신 계좌로 환불됩니다.<br />휴대폰 소액결제의 경우 평균 3영업일
						이내 환불 또는 취소 처리가 완료됩니다.
					</p>
				</div>
				<input type="checkbox" id="que10" /> <label for="que10"> <i
					class="fa-solid fa-q fa-1x"></i> <span>여러 개의 상품을 주문했는데, 일부만
						취소할 수도 있나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						신용카드 및 체크카드 또는 무통장 입금의 경우 배송 상태에 따라 결제후 부분 취소가 가능하며,배송상태에 따른 취소 가능
						여부는 아래와 같습니다.<br /> - 입금대기 및 결제완료 단계: 우측 상단 프로필 사진을 클릭 후 [나의쇼핑 >
						주문배송내역 조회]에서 즉시취소가능합니다.<br /> - 배송준비중: 우측 상단 프로필 사진을 클릭 후 [나의쇼핑 >
						고객센터 > 1:1 카톡 상담하기]로 취소 가능 여부 문의 부탁드립니다.<br /> - 배송중 : 주문 취소가
						불가능합니다. 수령후 반품 처리 부탁드립니다.<br />※ 단, 가상계좌로 입금 전이라면 부분 취소처리가 불가능하므로
						재주문 부탁드립니다.
					</p>
				</div>
			</div>
			<div class="conbox con3">
				<input type="checkbox" id="que11" /> <label for="que11"> <i
					class="fa-solid fa-q fa-1x"></i> <span>제품이 불량입니다. 반품 혹은 교환은
						어떻게 하나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						업체(브랜드)마다 발송처 및 반품절차가 다릅니다.<br /> - 우측 상단 프로필 사진을 클릭 후 [나의쇼핑]
						페이지에서 원하는 주문의 상세보기 버튼을 클릭 후 교환/반품 접수 후 진행 할수 있습니다.<br /> 교환/반품 접수
						없이 임의로 반송한 경우에는 처리가 늦어질 수 있습니다.<br /> - 교환/반품 접수 시 원활한 처리를 위해 불량
						사진이 필요하오니, 가급적 사진을 첨부하여 주시기 바랍니다.<br /> 단, 구매확정 이후 교환/반품을 원하시는 경우
						판매 업체에 교환/반품 가능 여부를 먼저 문의 부탁드립니다.
					</p>
				</div>
				<input type="checkbox" id="que12" /> <label for="que12"> <i
					class="fa-solid fa-q fa-1x"></i> <span>제품의 교환 또는 반품을 할 수
						있나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						상품을 수령하신 후 7일 이내에 교환, 반품이 가능하며, 고객님의 변심에 의한 교환/반품의 경우 배송비용이 부과될 수
						있습니다.<br /> ※ 단, 아래의 경우 교환/반품이 불가능합니다.<br /> - 고객님의 책임 사유로 인해 상품
						등이 멸실 또는 훼손된 경우<br /> - 개봉 및 포장이 훼손으로 상품가치가 현저히 상실된 경우<br /> -
						시간 경과에 의해 재판매가 어려울정도로 상품 가치가 현저히 저하된 경우<br /> - 고객주문 확인 후 상품제작에
						들어가는 주문 제작 상품<br /> - 직접 조립하는(DIY) 상품을 조립 한 경우
					</p>
				</div>
				<input type="checkbox" id="que13" /> <label for="que13"> <i
					class="fa-solid fa-q fa-1x"></i> <span>제품의 교환 또는 반품은 어떻게 신청
						할 수 있나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						업체(브랜드)마다 발송처 및 반품절차가 다릅니다.<br /> - 우측 상단 프로필 사진을 클릭 후 [나의쇼핑 > 주문
						상세보기] 페이지에서 원하는 주문의 상세보기 버튼을 클릭 후 교환/반품 접수 후 진행 할수 있습니다.<br />
						교환/반품 접수 없이 임의로 반송한 경우에는 처리가 늦어질 수 있습니다.<br /> - 반품을 보내실때는 제품이
						훼손되지 않도록 안전하게 충분히 포장 부탁드립니다.<br /> 단, 구매확정 이후 교환/반품을 원하시는 경우 판매
						업체에 교환/반품 가능 여부를 먼저 문의 부탁드립니다.
					</p>
				</div>
				<input type="checkbox" id="que14" /> <label for="que14"> <i
					class="fa-solid fa-q fa-1x"></i> <span>반품 시, 사은품도 같이 반품해야
						하나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>사은품도 같이 동봉하여 반품해 주셔야 반품처리가 완료됩니다.</p>
				</div>
				<input type="checkbox" id="que15" /> <label for="que15"> <i
					class="fa-solid fa-q fa-1x"></i> <span>주문한 것과 다른 상품이 왔습니다.
						어떻게 해야 하나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>우측 상단 프로필 사진을 클릭 후 [나의쇼핑 > 고객센터 > 1:1 카톡 상담하기]를 통해 문의 주시면 확인
						도움드리겠습니다.</p>
				</div>
			</div>
			<div class="conbox con4">
				<input type="checkbox" id="que16" /> <label for="que16"> <i
					class="fa-solid fa-q fa-1x"></i> <span>화니처에 가입한 적이 없는데 이미
						가입된 이메일이라고 나와요. 어떻게 하나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						현재 오늘의집은 회원 가입 시 이메일 인증 절차를 거치므로 이러한 문제가 발생되지 않지만 인증 절차 도입 전 다른
						고객님께서 이메일을 잘못 입력하신 경우 '이미 가입한 이메일'이란 메시지가 노출될 수 있습니다.<br /> 이는
						고객님의 정보가 노출된 것이 아니니 걱정하지 마시고, 번거로우시겠지만 고객센터로 문의 부탁드립니다.<br />
						오늘의집 고객센터 1670-0876 (운영 시간 : 평일 09:00~18:00) - 마이페이지 > 나의 쇼핑 >
						고객센터 > 1:1 카톡 상담하기 - 카카오 플러스친구 '오늘의집 고객센터'로 문의
					</p>
				</div>
				<input type="checkbox" id="que17" /> <label for="que17"> <i
					class="fa-solid fa-q fa-1x"></i> <span>비밀번호 변경은 어떻게 하나요?</span> <i
					class="fa-solid fa-angle-down"></i> <i class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>우측 상단 프로필 사진을 클릭 후 [마이홈 > 설정 > 비밀번호 변경] 페이지에서 비밀번호 변경이
						가능합니다.</p>
				</div>
				<input type="checkbox" id="que18" /> <label for="que18"> <i
					class="fa-solid fa-q fa-1x"></i> <span>회원탈퇴 후 재가입이 가능한가요?</span> <i
					class="fa-solid fa-angle-down"></i> <i class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>오늘의 집 재가입은 언제든지 가능합니다.</p>
				</div>
				<input type="checkbox" id="que19" /> <label for="que19"> <i
					class="fa-solid fa-q fa-1x"></i> <span>회원정보를 수정하고 싶은데 어떻게
						해야하나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>우측 상단 프로필 사진을 클릭 후 [마이홈 > 설정 > 회원정보수정] 페이지에서 회원 정보 수정이
						가능합니다.</p>
				</div>
				<input type="checkbox" id="que20" /> <label for="que20"> <i
					class="fa-solid fa-q fa-1x"></i> <span>회원탈퇴는 어떻게 하나요?</span> <i
					class="fa-solid fa-angle-down"></i> <i class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						화니처 pc웹사이트에서 가능합니다.<br /> PC 웹사이트: 우측 상단 프로필 사진 클릭 후 [마이페이지 > 설정
						> 회원정보수정] 상단의 탈퇴하기 버튼 클릭해주세요.<br /> 모바일 앱: [마이페이지 > 설정 > 프로필 수정]
						하단의 탈퇴하기 버튼을 클릭해주세요.<br /> 전문가 회원은 이메일 ji4642@gmail.com으로 문의해주시면
						감사하겠습니다.
					</p>
				</div>
			</div>
			<div class="conbox con5">
				<input type="checkbox" id="que21" /> <label for="que21"> <i
					class="fa-solid fa-q fa-1x"></i> <span>제품의 자세한 정보는 어떻게 알 수
						있나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>각 제품의 상세 페이지에서 확인 가능하며, 더욱 자세한 정보는 제품상세페이지 내 문의하기를 통해 판매 업체에
						문의 가능합니다.</p>
				</div>
				<input type="checkbox" id="que22" /> <label for="que22"> <i
					class="fa-solid fa-q fa-1x"></i> <span>화니처에서 다루는 콘텐츠는 어떤 것이
						있나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>화니처는 모든 사람들이 더 나은 공간에서 더 나은 삶을 만들어갈 수 있도록, 인테리어와 라이프 스타일에 관한
						콘텐츠를 공유하고 있습니다. 여러분의 집과 일상에 관한 사진과 영상, 게시글을 자유롭게 올려주세요. 사진은 업로드 후
						즉시, 노하우 콘텐츠는 업로드 후 14일 이내 오늘의집 앱에 게시됩니다. 단, 온라인 집들이 콘텐츠는 오늘의집 발행
						기준에 따라 콘텐츠를 선정하여 오늘의집 앱에 게시합니다.</p>
				</div>
				<input type="checkbox" id="que23" /> <label for="que23"> <i
					class="fa-solid fa-q fa-1x"></i> <span>인테리어 상담과 시공을 직접해주시나요?</span>
					<i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>화니처 인테리어 시공 서비스는 오늘의집 사용자와 인테리어 전문가님을 중개하는 서비스로, 화니처가 직접 상담과
						시공을 진행하지 않습니다.</p>
				</div>
				<input type="checkbox" id="que24" /> <label for="que24"> <i
					class="fa-solid fa-q fa-1x"></i> <span>상담방법과 상담가능시간 유선번호는
						어떻게 되나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						상담 시간은 평일 09:00 ~ 18:00 (주말 & 공휴일 제외)이며, 전화번호는 1670-0876 입니다.<br />
						우측 상단 프로필 사진을 클릭 후 [나의쇼핑 > 고객센터 > 1:1 카톡 상담하기] 를 이용하시면 상담원과 채팅으로
						더욱 빠르고 편리하게 문의 가능합니다.
					</p>
				</div>
				<input type="checkbox" id="que25" /> <label for="que25"> <i
					class="fa-solid fa-q fa-1x"></i> <span>입점 및 제휴/광고 문의는 어떻게
						하나요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						입점 신청은 https://orora.ohou.se/application/license 에서, <br /> 제휴/광고
						문의는 https://ohou.se/contacts/new?type=request 페이지에서 신청 가능합니다.
					</p>
				</div>
				<input type="checkbox" id="que26" /> <label for="que26"> <i
					class="fa-solid fa-q fa-1x"></i> <span>제가 쓴 리뷰가 블라인드 처리되었어요,
						블라인드 처리 기준은 무엇인가요?</span> <i class="fa-solid fa-angle-down"></i> <i
					class="fa-solid fa-angle-up"></i>
				</label>
				<div>
					<p>
						화니처는 상품의 실사용 정보를 얻기 힘든 가구 및 인테리어 제품 등의 구매 과정에서 해당 제품을 직접 사용한 유저들이
						생생하고 진실된 리뷰를 올리고 이를 서로 활용하는 문화를 만들어가고자 합니다.<br /> 화니처를 이용해주시는
						모두에게 유용하고 진실된 리뷰가 공유될 수 있도록, 다음 금지행위에 해당되는 리뷰는 오늘의집 서비스 이용 약관
						제24조에 따라 고객에게 통보 없이 삭제 또는 블라인드 될 수 있습니다. 관련 문의사항은 고객센터로 문의주시기
						바랍니다.<br /> (리뷰 작성 시 금지행위)<br /> 1. 특정업체 또는 개인의 영리적 목적을 위한 리뷰 게시<br />
						- 판매자 또는 판매자의 이해관계인(가족 또는 직원 등)이 판매자의 상품에 대한 리뷰 게시<br /> - 판매자 또는
						판매자의 이해관계인이 경쟁사의 상품에 대한 부정적인 내용 등 비방 목적으로 인정될 수 있는 리뷰 게시<br /> -
						특정업체의 제품에 대하여 특정 내용의 리뷰 작성 조건으로 대가(예: 금전적 보상, 상품 할인, 무료 제품 제공 등)를
						제공받고 이를 밝히지 않는 등 표시광고법령을 위반하는 내용의 리뷰 게시<br /> - 동일 상품에 대해 반복적 리뷰
						게시<br /> 2. 상품에 대한 부적합한 정보 게시<br /> - 허위 또는 과장된 내용 게시<br /> -
						직접 작성하지 않았거나 구매한 상품과 관련 없는 내용, 사진 게시 (예: 상품 페이지 캡쳐, 타/유사상품 리뷰)<br />
						3. 타인의 권리 등을 침해할 수 있는 내용 게시<br /> - 타인의 개인정보나 사생활을 공개하는 내용 게시(예:
						타인의 전화번호, 이메일 주소, 우편 주소 등)<br /> - 정당한 권한 없이 타인의 지식재산권, 기타 소유권,
						명예, 신용 등을 침해하는 내용 게시<br /> 4. 불쾌함 등을 유발하거나 반사회적인 내용 게시<br /> -
						욕설, 폭언, 비방 등 타인에게 불쾌하거나 위협이 되는 내용 게시<br /> - 불법물, 음란물 또는 청소년 유해
						매체물 게시<br /> - 범죄행위나 불법적인 행동을 전시 또는 조장하는 내용 게시 (예: 폭력, 불법 약물 사용,
						미성년자 음주, 아동 또는 동물 학대 포함<br /> 5. 기타 부적절한 내용 게시<br /> - 정보통신기기의
						오작동을 일으킬 수 있는 악성코드나 데이터를 포함한 내용 게시(예: 피싱, 멀웨어 사이트 링크 등)<br /> -
						사기성 상품, 서비스, 사업 계획 등을 판촉하는 내용 게시<br /> 6. 기타 관련법령 및 이용약관, 운영정책에
						위배되는 경우
					</p>
				</div>
			</div>
		</div>
	</div>
	<button id="topBtn" class="top-button" title="Go to top">Top</button>
	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />
</body>

<!-- script -->
<script src="<c:url value='/js/function.js' />"></script>
<script src="${root }js/function.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/4cd100a941.js"
	crossorigin="anonymous"></script>
</html>