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
<!-- 주소 api -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
   function checkUserIdExist(){
      var id=$("#id").val()
      
      //아이디를 입력하지 않았을 경우 예외처리
      if(id.length == 0){
         alert('아이디를 입력해주세요')
         return 
      }
      
      $.ajax({
         //요청할 주소
         url: '${root}user/checkBuyerExist/' + id,
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
<!-- 주소 api -->
<script>
		window.onload = function() {
		    document.getElementById("address").addEventListener("click", function() { //주소입력칸을 클릭하면
		        //카카오 지도 발생
		        new daum.Postcode({
		            oncomplete: function(data) { //선택시 입력값 세팅
		                document.getElementById("address").value = data.address; // 주소 넣기
		                document.querySelector("input[name=address2]").focus(); //상세입력 포커싱
		            }
		        }).open();
		    });
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
								<form:label class="label_txt" path="name">이름</form:label>
								<form:input path="name" class='form-control' placeholder='이름' />
								<form:errors class="err_txt" path="name" style='color:red' />
							</div>
							<div class="form-group">
								<form:label class="label_txt" path="id">아이디</form:label>
								<div class="input-group">
									<form:input path="id" class='form-control' placeholder='아이디'
										onkeypress="resetUserIdExist()" />
									<div class="input-group-append">
										<button type="button" class="btn btn-primary"
											onclick="checkUserIdExist()">중복확인</button>
									</div>
								</div>
								<form:errors class="err_txt id_err" path="id" style='color:red' />
							</div>
							<div class="form-group">
								<form:label class="label_txt" path="pw">비밀번호</form:label>
								<form:password path="pw" class='form-control' placeholder='비밀번호' />
								<form:errors class="err_txt" path='pw' style='color:red' />
							</div>
							<div class="form-group">
								<form:label class="label_txt" path="pw2">비밀번호 확인</form:label>
								<form:password path="pw2" class='form-control'
									placeholder='비밀번호 확인' />
								<form:errors class="err_txt" path='pw2' style='color:red' />
							</div>
							<div class="form-group">
								<form:label class="label_txt" path="mail">이메일</form:label>
								<form:input path="mail" class='form-control' placeholder='이메일' />
								<form:errors class="err_txt" path='mail' style='color:red' />
							</div>

							<div class="form-group">
								<form:label class="label_txt" path="phone">휴대폰 번호</form:label>
								<form:input path="phone" class='form-control'
									placeholder='휴대폰 번호' />
								<form:errors class="err_txt" path='phone' style='color:red' />
							</div>


							<div class="form-group">
								<form:label class="label_txt" path="address">주소</form:label>
								<div class="input-group">
									<form:input path="address" readonly="true" class="form-control"
										placeholder='주소 입력' />
								</div>
								<form:errors class="err_txt" path='address' style='color:red' />
							</div>
							<div class="form-group">
								<form:label class="label_txt" path="address2">상세주소</form:label>
								<div class="input-group">
									<form:input path="address2" class="form-control" placeholder='상세 주소 입력'/>
								</div>
								<form:errors path="address2" style="color:red" />
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







