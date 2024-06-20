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
	
	public List<CartBean> getCartItemByMemberId(String member_Id) {
		return cartMapper.getCartItemByMemberId(member_Id);
	}

	public int deleteCartItem(String member_Id, String product_Id) {
		return cartMapper.deleteCartItem(member_Id, product_Id);
	}

	public void insertCartItem(CartBean cartBean) {
		cartMapper.insertCartItem(cartBean);
	}

	public void updateCartItem(CartBean cartBean) {
		cartMapper.updateCartItem(cartBean);
	}

	public CartBean getCartItemByProductIdAndMemberId(String member_Id, String product_Id) {
		return cartMapper.getCartItemByProductIdAndMemberId(member_Id, product_Id);
	}

	public List<CartBean> getCntCart(String member_Id) {
		return cartMapper.getCntCart(member_Id);
	}



}