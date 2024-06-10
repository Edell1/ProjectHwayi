<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<script>
   function checkUserIdExist(){
      var user_id=$("#user_id").val()
      
      //아이디를 입력하지 않았을 경우 예외처리
      if(user_id.length == 0){
         alert('아이디를 입력해주세요')
         return 
      }
      
      $.ajax({
         //요청할 주소
         url: '${root}user/checkBuyerExist/' + user_id,
         //요청타입
         type: 'get',
         //응답결과
         dataType: 'text',
         //성공시 호출할 함수
         success: function(result){
            if(result.trim() == 'true'){
                     alert('사용할 수 있는 아이디입니다')
                     $("#userIdExist").val('true')
                  } else if(result.trim() == 'false'){
                     alert('사용할 수 없는 아이디 입니다')
                     $("#userIdExist").val('false')
                  }
         }
      }) //$.ajax
   }//checkUserIdExist()
   
   //사용자가 아이디란에 입력한 상태
   function resetUserIdExist(){
         $("#userIdExist").val('false')
      }
</script>
<body>

<div class="container" style="margin-top:100px">
      <div class="row">
         <div class="col-sm-3"></div>
         <div class="col-sm-6">
            <div class="card shadow">
               <div class="card-body">
                  <form:form action="${root}user/join_pro1" method="post"
                     modelAttribute="joinUserBean">
                     <form:hidden path="userIdExist" />
                     <div class="form-group">
                        <form:label path="user_name">이름</form:label>
                        <form:input path="user_name" class='form-control'
                           placeholder='이름' />
                        <form:errors path="user_name" style='color:red' />
                     </div>
                     <div class="form-group">
                        <form:label path="user_id">아이디</form:label>
                        <div class="input-group">
                           <form:input path="user_id" class='form-control'
                              placeholder='아이디' onkeypress="resetUserIdExist()" />
                           <div class="input-group-append">
                              <button type="button" class="btn btn-primary"
                                 onclick="checkUserIdExist()">중복확인</button>
                           </div>
                        </div>
                        <form:errors path="user_id" style='color:red' />
                     </div>
                     <div class="form-group">
                        <form:label path="user_pw">비밀번호</form:label>
                        <form:password path="user_pw" class='form-control'
                           placeholder='비밀번호' />
                        <form:errors path='user_pw' style='color:red' />
                     </div>
                     <div class="form-group">
                        <form:label path="user_pw2">비밀번호 확인</form:label>
                        <form:password path="user_pw2" class='form-control'
                           placeholder='비밀번호 확인' />
                        <form:errors path='user_pw2' style='color:red' />
                     </div>
                     <div class="form-group">
                        <form:label path="user_email">이메일</form:label>
                        <form:input path="user_email" class='form-control'
                           placeholder='이메일' />
                           <form:errors path='user_email' style='color:red' />
                     </div>

                     <div class="form-group">
                        <form:label path="user_tel">휴대폰 번호</form:label>
                        <form:input path="user_tel" class='form-control'
                           placeholder='휴대폰 번호' />
                        <form:errors path='user_tel' style='color:red' />
                     </div>

                     <div class="form-group">
                        <form:label path="user_add1">주소</form:label>
                        <form:input path="user_add1" class='form-control' placeholder='우편번호 입력' />
                        <form:errors path='user_add1' style='color:red' />
                        </div>
                        <div class="form-group">
                        <form:label path="user_add2">상세주소</form:label>
                        <form:input path="user_add2" class='form-control' placeholder='상세주소 입력' />
                        <form:errors path='user_add2' style='color:red' />
                     </div>

                     <div class="form-group">
                        <div class="text-right">
                           <form:button class='btn btn-primary'>회원가입</form:button>
                        </div>
                     </div>
                  </form:form>
               </div>
            </div>
         </div>
         <div class="col-sm-3"></div>
      </div>
   </div>

<c:import url="/WEB-INF/views/include/bottom_info.jsp"/>

</body>
</html>








