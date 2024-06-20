package kr.co.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.CartBean;
import kr.co.beans.UserBean;
import kr.co.dao.CartDao;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;

	public List<CartBean> getCartItemByMemberId(String code) {
		return cartDao.getCartItemByMemberId(code);
	}
	
	// 수량에 따른 총합 계산
	public int calculateTotalPrice(String code) {
		List<CartBean> cartItems = cartDao.getCartItemByMemberId(code);
		int totalPrice = 0;

		for (CartBean cartItem : cartItems) {
			int productPrice = cartItem.getPrice();
			int count = cartItem.getCount();
			totalPrice += (productPrice * count);
		}
		return totalPrice;
	}

	public int deleteCartItem(String code, String furnitureid) {
		return cartDao.deleteCartItem(code, furnitureid);
	}

	public void insertCartItem(CartBean addCartBean) {
		cartDao.insertCartItem(addCartBean);
	}

	public void updateCartItem(CartBean cartBean) {
		cartDao.updateCartItem(cartBean);
	}

	public CartBean getCartItemByProductIdAndMemberId(String code, String furnitureid) {
		return cartDao.getCartItemByProductIdAndMemberId(code, furnitureid);
	}

}