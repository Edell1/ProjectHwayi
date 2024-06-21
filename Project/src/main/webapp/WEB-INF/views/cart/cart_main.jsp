<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>장바구니</title>
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
<link rel="stylesheet" href="<c:url value='/css/top_footer.css' />" />
<link rel="stylesheet" href="<c:url value='/css/cart.css' />" />
<link rel="stylesheet" href="<c:url value='/css/mypage_nav.css' />" />
</head>
<body>
	<div class="top">
		<c:import url="/WEB-INF/views/include/top_menu.jsp" />
		<c:import url="/WEB-INF/views/include/nav_menu.jsp" />
	</div>

	<div class="flex_wrap">
		<c:import url="/WEB-INF/views/include/mypage_nav.jsp" />
		<div class="cart_contain">
			<div class="tit">장바구니</div>
			<div class="top_box">
				<div>
					<label for="allChk"><input type="checkbox"
						class="all-select-checkbox" onclick="AllCheckboxes()"> <span>전체</span></label>
				</div>
				<div>
					<a href="${root}furniture/furniture_list" class="cartBtn back_btn">쇼핑
						계속하기</a>
				</div>
			</div>
			<div class="bottom_box">
				<table class="cart_table">
					<tr>
						<th></th>
						<th>상품</th>
						<th>이름</th>
						<th>가격</th>
						<th>수량</th>
						<th>총액</th>
						<th></th>
					</tr>
					<c:if test="${not empty cartItems}">
						<c:forEach var="cartItem" items="${cartItems}">
							<tr>
								<td><input type="checkbox" class="item-checkbox"
									value="${cartItem.furnitureid}"
									onclick="handleCheckboxChange(this)"></td>
								<td><img
									src="${root}image/furniture1/${cartItem.furnitureid}.png"
									class="cart-img" style="width: 50px" /></td>
								<td class="product-name">${cartItem.furnitureName}</td>
								<td class="product_price">${cartItem.price}</td>
								<td style="width: 300px">
									<button onclick="decreaseQuantity(this)" class="decbtn">-</button>
									수량:<span class="cartQuantity" data-index="${loop.index}">${cartItem.count}</span>
									<button onclick="increaseQuantity(this)" class="incbtn">+</button>
								</td>
								<td class="subtotal">${cartItem.price * cartItem.count}</td>
								<td>
									<button class="cart_item_delete" type="button"
										onclick="deleteItem('${cartItem.code}', '${cartItem.furnitureid}')">X</button>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th>배송비</th>
						<th>수량</th>
						<th>총액</th>
						<th></th>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th>장바구니 총액</th>
						<th>착불</th>
						<th></th>
						<th id="totalPrice">${finalPrice}</th>
					</tr>
				</table>
			</div>
			<div class="btnBox">
				<a href="#" class="cartBtn delete_btn" onclick="deleteAllItems()">삭제하기</a>
				<a href="#" class="cartBtn order_btn">주문하기</a>
			</div>
		</div>
	</div>

	<button id="topBtn" class="top-button" title="Go to top">Top</button>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />

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

	<script>
	
	function deleteItem(member_id, product_id) {
	    if (confirm("해당 상품을 삭제하시겠습니까?")) {
	        $.ajax({
	            type: "POST",
	            url: "${root}cart/deleteItem",
	            data: {
	                member_id,
	                product_id
	            },
	            success: function(response) {
	                // 삭제 요청 성공 시, 화면에서 해당 요소 삭제
	                $(event.target).closest('div').remove();
	                location.reload();
	            },
	            error: function(xhr, status, error) {
	                alert(xhr.responseText); // 실패 시 서버에서 전달한 실패 이유를 표시
	            }
	        });
	    }
	}
	
        // 전체 체크박스 선택
        function AllCheckboxes() {
            var allCheckboxes = document.querySelectorAll('.item-checkbox');
            var isAllChecked = document.querySelector('.all-select-checkbox').checked;

            allCheckboxes.forEach(function(checkbox) {
                checkbox.checked = isAllChecked;
                handleCheckboxChange(checkbox);
            });
        }

        //화면에서만 수량증가
        let updatedQuantities = {};

        function decreaseQuantity(button) {
            // 부모 요소 중 <tr>를 찾아 그 안에서 .cartQuantity와 .item-checkbox 요소를 검색
            var trElement = button.closest('tr');
            var quantityElement = trElement.querySelector('.cartQuantity');
            var quantity = parseInt(quantityElement.innerHTML);
            var product_Id = trElement.querySelector('.item-checkbox').value;

            // 수량이 1 이상일 경우 감소
            if (quantity > 1) {
                quantity--;
                quantityElement.innerHTML = quantity;
                updatedQuantities[product_Id] = quantity;
            }
            // 소계 업데이트
            updateSubtotal(trElement, quantity);
            calculateCount();
        }

        function increaseQuantity(button) {
            // 부모 요소 중 <tr>를 찾아 그 안에서 .cartQuantity와 .item-checkbox 요소를 검색
            var trElement = button.closest('tr');
            var quantityElement = trElement.querySelector('.cartQuantity');
            var quantity = parseInt(quantityElement.innerHTML);
            var product_Id = trElement.querySelector('.item-checkbox').value;

            quantity++;
            quantityElement.innerHTML = quantity;
            updatedQuantities[product_Id] = quantity;
            // 소계 업데이트
            updateSubtotal(trElement, quantity);
            calculateCount();
        }

        function updateSubtotal(trElement, quantity) {
            var priceElement = trElement.querySelector('.product_price');
            var subtotalElement = trElement.querySelector('.subtotal');
            var price = parseInt(priceElement.innerHTML);
            var subtotal = price * quantity;
            subtotalElement.innerHTML = subtotal;
        }
        

        let checkedItems = []; // 선택된 상품들의 ID와 수량을 담을 배열

        function handleCheckboxChange(checkbox) {
            var product_id = checkbox.value;
            var quantityElement = checkbox.closest('.cart-item').querySelector('.cartQuantity');
            var quantity = parseInt(quantityElement.innerHTML);

            var foundIndex = checkedItems.findIndex(item => item.product_id === product_id);

            if (foundIndex !== -1) {
                // 이미 선택된 상품이면 수량을 업데이트
                checkedItems[foundIndex].quantity = quantity;
            } else {
                // 새로 선택된 상품이면 배열에 추가
                checkedItems.push({ product_id: product_id, quantity: quantity });
            }
            calculateTotal();
            console.log("Checked Items: ", checkedItems);
        }
        
        
        function getProductId() {
            var checkedCheckboxes = document.querySelectorAll('.item-checkbox:checked');
            var form = document.createElement('form');
            form.method = 'post';
            form.action = "${root}order/processOrder";

            checkedCheckboxes.forEach(function(checkbox) {
                var product_id = checkbox.value;
                var updatedQuantity = updatedQuantities[product_id];
                if (updatedQuantity === undefined) {
                    var quantityElement = checkbox.closest('.cart-item').querySelector('.cartQuantity');
                    updatedQuantity = parseInt(quantityElement.innerHTML);
                }

               
                var idInput = document.createElement('input');
                idInput.type = 'hidden';
                idInput.name = 'product_id';
                idInput.value = product_id;
                form.appendChild(idInput);

                var quantityInput = document.createElement('input');
                quantityInput.type = 'hidden';
                quantityInput.name = 'quantities';
                quantityInput.value = updatedQuantity;
                form.appendChild(quantityInput);
            });
            
            var totalPriceInput = document.createElement('input');
            totalPriceInput.type = 'hidden';
            totalPriceInput.name = 'totalPrice';
            totalPriceInput.value = document.getElementById('totalPrice').innerText;
            form.appendChild(totalPriceInput);

            var finalPriceInput = document.createElement('input');
            finalPriceInput.type = 'hidden';
            finalPriceInput.name = 'finalPrice';
            finalPriceInput.value = document.getElementById('finalPrice').innerText;
            form.appendChild(finalPriceInput);

            document.body.appendChild(form);
            form.submit();
        }

		// 개별 상품 총액
        function calculateCount() {
            var total = 0;
            var subtotals = document.querySelectorAll('.subtotal');
            subtotals.forEach(function(subtotal) {
                total += parseInt(subtotal.innerHTML);
            });
            document.getElementById('totalPrice').innerHTML = total;
        }
        
		// 전체 상품 총액
        function calculateTotal() {
            let total = 0;
            document.querySelectorAll('.cart-item').forEach(item => {
                const checkbox = item.querySelector('.item-checkbox');
                if (checkbox && checkbox.checked) {
                    const priceElement = item.querySelector('.product_price');
                    const price = parseInt(priceElement.innerText);
                    const quantity = parseInt(item.querySelector('.cartQuantity').innerText);
                    total += price * quantity;
                }
            });
            document.getElementById('totalPrice').innerText = total ;
            document.getElementById('finalPrice').innerText = (total + 5000) ; // 배송비 5000원 추가
        }

        document.addEventListener('DOMContentLoaded', (event) => {
            calculateTotal();
        });
        
        function deleteAllItems() {
        	var code = '${loginUserBean.code}'; // member_id를 JSP 페이지에서 가져옵니다.
            if (confirm("모든 상품을 삭제하시겠습니까?")) {
                $.ajax({
                    type: "POST",
                    url: "${root}cart/deleteAllItems",
                    data: {
                    	code: code
                    },
                    success: function(response) {
                        location.reload();
                    },
                    error: function(xhr, status, error) {
                        alert(xhr.responseText);
                    }
                });
            }
        }

    </script>
</body>
</html>