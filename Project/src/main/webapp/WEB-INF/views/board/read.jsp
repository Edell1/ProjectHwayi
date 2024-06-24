<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>문의글 수정하기</title>

<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/write.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
</head>
<body>


   <c:import url="/WEB-INF/views/include/top_menu.jsp" />


   <div class="container">
      <div class="row">
         <div class="col-sm-3"></div>
         <div class="col-sm-6">
            <div class="card shadow">
               <div class="card-body">
                  <div class="form-group">
                     <label for="name">작성자</label> <input type="text"
                        id="name" name="name"
                        class="form-control"
                        value="${readQnABean.name }"
                        disabled="disabled" />
                  </div>
                  <div class="form-group">
                     <label for="add_date">작성일자</label> <input type="text"
                        id="add_date" name="add_date" class="form-control"
                        value="${readQnABean.add_date }" disabled="disabled" />
                  </div>
                  <div class="form-group">
                     <label for="content_title">제목</label> <input type="text"
                        id="content_title" name="content_title" class="form-control"
                        value="${readQnABean.content_title }" disabled="disabled" />
                  </div>
                  <div class="form-group">
                     <label for="content_subject">내용</label>
                     <textarea id="content_subject" name="board_content"
                        class="form-control" rows="10" style="resize: none"
                        disabled="disabled">${readQnABean.content_subject }</textarea>
                  </div>
                  
                  <div class="form-group">
                     <div class="text-right">
                     <c:if test="${loginUserBean.userRole == 'admin'}">
						<li><a href="${root}board/answer_write?content_idx=${readQnABean.content_idx}" class="btn btn-primary">답변하기</a></li>
					</c:if>
                        <a
                           href="${root}customer_center/main"
                           class="btn btn-primary">목록보기</a>
                        <c:if
                           test="${loginUserBean.code == readQnABean.code }">
                           <a
                              href="${root}board/delete?content_idx=${content_idx}"
                              class="btn btn-danger">삭제하기</a>
                        </c:if>
                     </div>
                  </div>
                  <c:if test="${readQnABean.q_checked == 0 }" >
                     <div class="form-group">
                     <label for="acontent">답변</label>
                     <textarea id="acontent" name="board_content"
                        class="form-control" rows="10" style="resize: none"
                        disabled="disabled">${readQnABean.acontent }</textarea>
                  </div>
                  </c:if>
               </div>
            </div>
         </div>
         <div class="col-sm-3"></div>
      </div>
   </div>

   <button id="topBtn" class="top-button" title="Go to top">Top</button>

   <c:import url="/WEB-INF/views/include/bottom_info.jsp" />

</body>

<!-- script -->
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