<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>구매자 회원가입</title>

<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/join.css' />" />

</head>
<script>
   function checkUserIdExist(){
      var ID=$("#ID").val()
      
      //아이디를 입력하지 않았을 경우 예외처리
      if(ID.length == 0){
         alert('아이디를 입력해주세요')
         return 
      }
      
      $.ajax({
         //요청할 주소
         url: '${root}user/checkBuyerExist/' + ID,
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
   <div class="join_container">
      <div class="top_box">
         <h1 class="tit">구매자 회원가입</h1>
      </div>

      <div class="join_box">
         <div class="join_box_inner">
            <div class="top_var">
               <a href="${root }main" class="home"> <i
                  class="fa-solid fa-house"></i>
               </a>
            </div>

            <div class="join_cont">
               <div class="cont_box">
                  <form:form action="${root}user/join_pro1" method="post"
                     modelAttribute="joinUserBean">
                     <form:hidden path="userIdExist" />
                     <div class="form-group">
                        <form:label class="label_txt" path="Name">이름</form:label>
                        <form:input path="Name" class='form-control'
                           placeholder='이름' />
                        <form:errors class="err_txt" path="Name" style='color:red' />
                     </div>
                     <div class="form-group">
                        <form:label class="label_txt" path="ID">아이디</form:label>
                        <div class="input-group">
                           <form:input path="ID" class='form-control'
                              placeholder='아이디' onkeypress="resetUserIdExist()" />
                           <div class="input-group-append">
                              <button type="button" class="btn btn-primary"
                                 onclick="checkUserIdExist()">중복확인</button>
                           </div>
                        </div>
                        <form:errors class="err_txt id_err" path="ID" style='color:red' />
                     </div>
                     <div class="form-group">
                        <form:label class="label_txt" path="PW">비밀번호</form:label>
                        <form:password path="PW" class='form-control'
                           placeholder='비밀번호' />
                        <form:errors class="err_txt" path='PW' style='color:red' />
                     </div>
                     <div class="form-group">
                        <form:label class="label_txt" path="PW2">비밀번호 확인</form:label>
                        <form:password path="PW2" class='form-control'
                           placeholder='비밀번호 확인' />
                        <form:errors class="err_txt" path='PW2' style='color:red' />
                     </div>
                     <div class="form-group">
                        <form:label class="label_txt" path="Mail">이메일</form:label>
                        <form:input path="Mail" class='form-control'
                           placeholder='이메일' />
                        <form:errors class="err_txt" path='Mail' style='color:red' />
                     </div>

                     <div class="form-group">
                        <form:label class="label_txt" path="Phone">휴대폰 번호</form:label>
                        <form:input path="Phone" class='form-control'
                           placeholder='휴대폰 번호' />
                        <form:errors class="err_txt" path='Phone' style='color:red' />
                     </div>

                     <div class="form-group">
                        <form:label class="label_txt" path="Address">주소</form:label>
                        <form:input path="Address" class='form-control'
                           placeholder='우편번호 입력' />
                        <form:errors class="err_txt" path='Address' style='color:red' />
                     </div>
                     <div class="form-group">
                        <form:label class="label_txt" path="Address2">상세주소</form:label>
                        <form:input path="Address2" class='form-control'
                           placeholder='상세주소 입력' />
                        <form:errors class="err_txt" path='Address2' style='color:red' />
                     </div>

                     <div class="form-group">
                        <form:button class='btn btn-primary joinBtn'>회원가입</form:button>
                     </div>
                  </form:form>
               </div>
            </div>
         </div>

      </div>
   </div>
</body>

<!-- script -->
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/4cd100a941.js"
   crossorigin="anonymous"></script>
</html>







