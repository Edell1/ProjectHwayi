<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="root" value="${pageContext.request.contextPath}/" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>판매상품 등록</title>
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/seller_nav.css' />" />
<%-- <link rel="stylesheet"
   href="<c:url value='/css/seller_productAdd.css' />" /> --%>
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
</head>
<body>

   <c:import url="/WEB-INF/views/include/top_menu.jsp" />

   <div class="seller_wrap">

      <c:import url="/WEB-INF/views/include/seller_nav.jsp" />

      <div class="seller_prodAdd">
         <div class="prodAdd_inner">
            <div class="tit">판매 상품 등록</div>
            <form:form action="${root }seller/furnitureAdd_pro " method="post"
               modelAttribute="addFurnitureBean" enctype="multipart/form-data">
               <div class="flex_box">
                  <form class="prodTable" id="prodAdd">
                     <table>
                        <tr>
                           <th><form:label path="furniture_name">상품명</form:label></th>
                           <td><form:input path="furniture_name" id="productName" />
                              <form:errors path='furniture_name' style='color:red' /></td>
                        </tr>
                        <tr>
                           <th><form:label path="furniture_price">가격</form:label></th>
                           <td><form:input path="furniture_price" id="productPraice" />
                              <form:errors path='furniture_price' style='color:red' /></td>
                        </tr>
                        <tr>
                           <th><form:label path="furniture_cnt">수량</form:label></th>
                           <td><form:input path="furniture_cnt" id="productCnt" /> <form:errors
                                 path='furniture_cnt' style='color:red' /></td>
                        </tr>
                        <tr>
                           <th><form:label path="furniture_width">가로</form:label></th>
                           <td><form:input path="furniture_width" id="productWidth" />
                              <form:errors path='furniture_width' style='color:red' /></td>

                           <th><form:label path="furniture_length">세로</form:label></th>
                           <td><form:input path="furniture_length" id="productLength" />
                              <form:errors path='furniture_length' style='color:red' /></td>

                           <th><form:label path="furniture_height">높이</form:label></th>
                           <td><form:input path="furniture_height" id="productHeiht" />
                              <form:errors path='furniture_height' style='color:red' /></td>
                        </tr>

                        <tr>
                           <th><form:label path="furniture_type">종류</form:label></th>
                           <td><form:select path="furniture_type" id="category">
                                 <form:option value="bd" label="침대" />
                                 <form:option value="sf" label="소파" />
                                 <form:option value="sh" label="선반" />
                                 <form:option value="ca" label="거실장/티비장" />
                                 <form:option value="hg" label="행거" />
                                 <form:option value="cl" label="옷장" />
                                 <form:option value="pa" label="파티션" />
                                 <form:option value="dr" label="서랍장" />
                                 <form:option value="mi" label="거울" />
                                 <form:option value="ch" label="의자" />
                                 <form:option value="dk" label="책상/테이블" />
                                 <form:option value="bs" label="책장" />
                                 <form:option value="ct" label="커튼/블라인드" />
                              </form:select> <form:errors path="furniture_type" style='color:red' />
                           <td>
                        </tr>

                        <tr>
                           <th><form:label path="furniture_color">색상</form:label></th>
                           <td><form:select path="furniture_color" id="category">
                                 <form:option value="화이트" label="화이트" />
                                 <form:option value="그레이" label="그레이" />
                                 <form:option value="블랙" label="블랙" />
                                 <form:option value="베이지" label="베이지" />
                                 <form:option value="브라운" label="브라운" />
                                 <form:option value="실버" label="실버" />
                                 <form:option value="골드" label="골드" />
                                 <form:option value="레드" label="레드" />
                                 <form:option value="옐로우" label="옐로우" />
                                 <form:option value="그린" label="그린" />
                                 <form:option value="오렌지" label="오렌지" />
                                 <form:option value="블루" label="블루" />
                                 <form:option value="네이비" label="네이비" />
                                 <form:option value="핑크" label="핑크" />
                                 <form:option value="투명" label="투명" />
                                 <form:option value="기타" label="기타" />

                              </form:select> <form:errors path="furniture_color" style='color:red' />
                           <td>
                        </tr>
                        
                        <tr>
                           <th><form:label path="furniture_mat">재질</form:label></th>
                           <td><form:select path="furniture_mat" id="category">
                                 <form:option value="원목" label="원목" />
                                 <form:option value="가공목" label="가공목" />
                                 <form:option value="대리석" label="대리석" />
                                 <form:option value="세라믹" label="세라믹" />
                                 <form:option value="유리" label="유리" />
                                 <form:option value="철재" label="철재" />
                                 <form:option value="플라스틱" label="플라스틱" />
                                 <form:option value="가죽" label="가죽" />
                                 <form:option value="흙,돌" label="흙,돌" />
                                 <form:option value="아쿠아텍스" label="아쿠아텍스" />
                                 <form:option value="패브릭" label="패브릭" />
                                 <form:option value="라탄" label="라탄" />
                                 <form:option value="종이" label="종이" />
                                 <form:option value="거울" label="거울" />

                              </form:select> <form:errors path="furniture_mat" style='color:red' />
                           <td>
                        </tr>
                        <tr>
                           <th><form:label path="upload_file1">첨부 이미지</form:label></th>
                           <td><form:input type='file' path='upload_file1'
                                 id="productPhoto1" accept="image/furniture1/*" /></td>
                        </tr>
                        <tr>
                           <th><form:label path="upload_file2">상품상세 이미지</form:label></th>
                           <td><form:input type='file' path='upload_file2'
                                 id="productPhoto2" accept="image/furniture2/*" /></td>
                        </tr>
                     </table>
                  </form>

                  <div class="btn_box">
                     <form:button class='btn btn-primary'>등록하기</form:button>
                     <button class="listBtn">목록보기</button>
                  </div>
               </div>
            </form:form>
         </div>
      </div>
   </div>

   <button id="topBtn" class="top-button" title="Go to top">Top</button>

   <c:import url="/WEB-INF/views/include/bottom_info.jsp" />

</body>

<!-- scripts -->
<script src="${root}js/function.js"></script>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/4cd100a941.js"
   crossorigin="anonymous"></script>
</html>