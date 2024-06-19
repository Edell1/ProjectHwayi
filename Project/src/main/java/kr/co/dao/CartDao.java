package kr.co.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.CartBean;
import kr.co.mapper.CartMapper;

@Repository
public class CartDao {
	
	@Autowired
	private CartMapper cartMapper;

	public List<CartBean> getCartBycode(String code) {
		return cartMapper.getCartBycode(code);
	}
	
	public CartBean getCarByfurnitureIdAndCode(String code, String furnotureid) {
		return cartMapper.getCarByfurnitureIdAndCode(code, furnotureid);
	}

	public List<CartBean> getCntCart(String code) {
		return cartMapper.getCntCart(code);
	}

	// Ãß°¡
	public void addCart(CartBean cartBean) {
		cartMapper.addCart(cartBean);
	}

	// ¾÷µ¥ÀÌÆ®
	public void updateCart(CartBean cartBean) {
		cartMapper.updateCart(cartBean);
	}
	
	// »èÁ¦
	public int deleteCart(String code, String furnotureid) {
		return cartMapper.deleteCart(code, furnotureid);

	}


}