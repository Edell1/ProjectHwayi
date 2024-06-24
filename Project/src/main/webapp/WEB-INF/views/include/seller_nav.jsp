<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<nav>
   <div class="tit">판매자 페이지</div>

   <div class="left_gnb">
      <ul>
         <li>판매정보</li>
         <li class="border"></li>
         <li><a href="#">주문내역/배송상태</a></li>
         <li><a href="#">취소/반품/교환 내역</a></li>
      </ul>
      <ul>
         <li>판매통계</li>
         <li class="border"></li>
         <li><a href="#">통계</a></li>
         <li><a href="#">판매수익</a></li>
      </ul>
      <ul>
         <li>판매등록</li>
         <li class="border"></li>
         <li><a href="${root}seller/seller_productAdd">상품 등록</a></li>
         <li><a href="#">배너 등록</a></li>
      </ul>
      <ul>
         <li>나의정보</li>
         <li class="border"></li>
         <li><a href="#">정보 관리</a></li>
         <li><a href="${root }/seller/furniture_management?seller_code=${loginUserBean.code}">상품 관리</a></li>
      </ul>
      <ul>
         <li>고객서비스</li>
         <li class="border"></li>
         <li><a href="#">FAQ</a></li>
         <li><a href="#">공지사항</a></li>
      </ul>
   </div>
</nav>