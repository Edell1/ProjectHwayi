<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value='${pageContext.request.contextPath }/' />
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${root}js/function.js"></script>
<script>
function deleteItem(code, furnitureid) {
    if (confirm("해당 상품을 삭제하시겠습니까?")) {
        $.ajax({
            type: "POST",
            url: "${root}cart/deleteItem",
            data: {
                code,
                furnitureid
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

function deleteAllItems() {
    var code = '${loginUserBean.code}'; 
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

// 화면에서만 수량 증가
let updatedQuantities = {}; 

function decreaseQuantity(button) {
    var cartItemElement = button.closest('.cart-item');
    var quantityElement = cartItemElement.querySelector('.cartQuantity');
    var quantity = parseInt(quantityElement.innerHTML);
    var furnitureid = cartItemElement.querySelector('.item-checkbox').value;

    if (quantity > 1) {
        quantity--;
        quantityElement.innerHTML = quantity;
        updatedQuantities[furnitureid] = quantity;
    }
    calculateTotal();
}

function increaseQuantity(button) {
    var cartItemElement = button.closest('.cart-item');
    var quantityElement = cartItemElement.querySelector('.cartQuantity');
    var quantity = parseInt(quantityElement.innerHTML);
    var furnitureid = cartItemElement.querySelector('.item-checkbox').value;

    quantity++;
    quantityElement.innerHTML = quantity;
    updatedQuantities[furnitureid] = quantity;
    calculateTotal();
}

let checkedItems = []; // 선택된 상품들의 ID와 수량을 담을 배열

function handleCheckboxChange(checkbox) {
    var cartItemElement = checkbox.closest('.cart-item');
    var furnitureid = checkbox.value;
    var quantityElement = cartItemElement.querySelector('.cartQuantity');
    var quantity = parseInt(quantityElement.innerHTML);

    var foundIndex = checkedItems.findIndex(item => item.furnitureid === furnitureid);

    if (foundIndex !== -1) {
        // 이미 선택된 상품이면 수량을 업데이트
        checkedItems[foundIndex].quantity = quantity;
    } else {
        // 새로 선택된 상품이면 배열에 추가
        checkedItems.push({ furnitureid: furnitureid, quantity: quantity });
    }
    calculateTotal();
    console.log("Checked Items: ", checkedItems);
}
    
function getProductId() {
    var checkedCheckboxes = document.querySelectorAll('.item-checkbox:checked');
    
    // 체크된 항목이 없는 경우 경고 메시지를 표시하고 함수를 종료합니다.
    if (checkedCheckboxes.length === 0) {
        alert("주문할 상품을 선택해주세요.");
        return;
    }
    
    var form = document.createElement('form');
    form.method = 'post';
    form.action = "${root}order/processOrder";

    checkedCheckboxes.forEach(function(checkbox) {
        var cartItemElement = checkbox.closest('.cart-item');
        var furnitureid = checkbox.value;
        var updatedQuantity = updatedQuantities[furnitureid];
        if (updatedQuantity === undefined) {
            var quantityElement = cartItemElement.querySelector('.cartQuantity');
            updatedQuantity = parseInt(quantityElement.innerHTML);
        }

        var idInput = document.createElement('input');
        idInput.type = 'hidden';
        idInput.name = 'furnitureid';
        idInput.value = furnitureid;
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

function calculateTotal() {
    let total = 0;
    document.querySelectorAll('.cart-item').forEach(item => {
        const checkbox = item.querySelector('.item-checkbox');
        if (checkbox && checkbox.checked) {
            const priceElement = item.querySelector('.price');
            const price = parseInt(priceElement.innerText);
            const quantity = parseInt(item.querySelector('.cartQuantity').innerText);
            total += price * quantity;
        }
    });
    document.getElementById('totalPrice').innerText = total;
    document.getElementById('finalPrice').innerText = total + 5000; // 배송비 5000원 추가
}

document.addEventListener('DOMContentLoaded', (event) => {
    calculateTotal();
});

function AllCheckboxes() {
    var allCheckboxes = document.querySelectorAll('.item-checkbox');
    var isAllChecked = document.querySelector('.all-select-checkbox').checked;

    allCheckboxes.forEach(function(checkbox) {
        checkbox.checked = isAllChecked;
        handleCheckboxChange(checkbox);
    });
}
</script>

</head>
<body>
	<div class="top">
		<c:import url="/WEB-INF/views/include/top_menu.jsp" />
		<c:import url="/WEB-INF/views/include/nav_menu.jsp" />
	</div>

	<div class="flex_wrap">
		<c:import url="/WEB-INF/views/include/mypage_nav.jsp" />

		<div class="cart_contain">
			<h2 class=tit>장바구니</h2>

			<div class="cart_view">
				<div class="cart_product">
					<div class="allCheck">
						<label class="css-1vf8o8s e1dcessg3"> <input
							type="checkbox" class="css-agvwxo e1dcessg2 all-select-checkbox"
							onclick="AllCheckboxes()"> <span>전체선택</span>
						</label>
					</div>


					<div class="cart_product1">
						<div class="cart_product2">

							<c:if test="${not empty cartItems}">
								<c:forEach var="cartItem" items="${cartItems}">
									<div class="cart-item">
										<input type="checkbox" class="item-checkbox"
											value="${cartItem.furnitureid}"
											onclick="handleCheckboxChange(this)">
										<div>
											<img
												src="${root}image/furniture1/${cartItem.furnitureid}.png"
												class="cart-img" />
											<p class="product-name">${cartItem.furnitureName}</p>
										</div>
										<p class="price">${cartItem.price}</p>
										<div>
											<button onclick="decreaseQuantity(this)" class="decbtn">-</button>
											<p>
												수량 : <span class="cartQuantity" data-index="${loop.index}">${cartItem.count}</span>
											</p>
					 						<button onclick="increaseQuantity(this)" class="incbtn">+</button>
										</div>
										<button class="cart_item_delete" type="button"
											onclick="deleteItem('${cartItem.code}', '${cartItem.furnitureid}')">✕</button>
									</div>
								</c:forEach>
							</c:if>
							<c:if test="${empty cartItems}">
								<p>장바구니가 비어있습니다.</p>
							</c:if>
						</div>
					</div>
				</div>
				
				<div class="cart_price">
					<div class="cart_price1">
						<div class="cart_price2">
							<div class="cart_price3">
								<span class="">상품 금액 : </span><span class=""><span class=""
									id="totalPrice">원</span></span>
							</div>
							<div class="cart_price3">
								<span class=" ">상품할인 금액 : </span><span class=" ">0<span
									class=" ">원</span></span>
							</div>
							<div class="cart_price3">
								<span class=" ">배송비 : </span><span class=><span class=" ">5000원</span></span>
							</div>
							<div class="cart_price3_font2">
								<span class=" ">결제예정 금액 : </span> <span class="" id="finalPrice">
									<strong class=" ">${totalPrice}</strong> <span class=" ">${totalPrice}원</span>
								</span>
							</div>
						</div>
						
						<div class="btnBox">
							<a href="#" class="cartBtn delete_btn" onclick="deleteAllItems()">전체
								삭제</a> <a class="cartBtn order_btn" type="button"
								onclick="getProductId()">주문하기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<button id="topBtn" class="top-button" title="Go to top">Top</button>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />

</body>
</html>