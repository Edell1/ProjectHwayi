package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.CartBean;
import kr.co.dao.CartDao;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;

	public List<CartBean> getCartBycode(String code) {
		return cartDao.getCartBycode(code);
	}

	public CartBean getCarByfurnitureIdAndCode(String code, String furnotureid) {
		return cartDao.getCarByfurnitureIdAndCode(code, furnotureid);
	}

	public List<CartBean> getCntCart(String code) {
		return cartDao.getCntCart(code);
	}

	public int calculateTotalPrice(String code) {
		List<CartBean> cartItems = cartDao.getCartBycode(code);
		int totalPrice = 0;

		for (CartBean cartItem : cartItems) {
			int fruniturePrice = (int) cartItem.getPrice();
			int count = cartItem.getCount();
			totalPrice += (fruniturePrice * count);
		}

		return totalPrice;
	}

	public void addCart(CartBean cartBean) {
		cartDao.addCart(cartBean);
	}

	public void updateCart(CartBean cartBean) {
		cartDao.updateCart(cartBean);
	}

	public int deleteCart(String code, String furnotureid) {
		return cartDao.deleteCart(code, furnotureid);

	}

}