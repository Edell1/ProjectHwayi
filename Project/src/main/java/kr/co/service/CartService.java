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

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	public List<CartBean> getCartItemByMemberId(String code) {
		return cartDao.getCartItemByMemberId(code);
	}

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

	// addCartInfo 메서드 추가
	public void addCartInfo(String furnitureid, String code, int price, int count) {
		CartBean existingItem = cartDao.getCarByfurnitureIdAndCode(code, furnitureid);

		if (existingItem != null) {
			// 기존에 동일한 상품이 있다면 수량과 가격을 업데이트
			existingItem.setCount(existingItem.getCount() + count);
			existingItem.setPrice(existingItem.getPrice() + price);
			cartDao.updateCart(existingItem);
		} else {
			// 새로운 상품을 장바구니에 추가

			CartBean newItem = new CartBean();
			newItem.setCode(loginUserBean.getCode());
			newItem.setFurnitureid(furnitureid);
			newItem.setCount(count);
			newItem.setPrice(price);
			cartDao.addCart(newItem);
		}
	}

}