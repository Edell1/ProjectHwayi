package kr.co.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.UserBean;
import kr.co.mapper.BuyerMapper;
import kr.co.mapper.SellerMapper;

@Repository
public class UserDao {

	@Autowired
	private BuyerMapper buyerMapper;

	@Autowired
	private SellerMapper sellerMapper;

	public String buyercheckUserExist(String user_id) {
		return buyerMapper.buyercheckUserExist(user_id);
	}

	public void buyeraddUserInfo(UserBean joinUserBean) {
		buyerMapper.buyeraddUserInfo(joinUserBean);

	}

	public String sellercheckUserExist(String user_id) {
		return sellerMapper.checkUserIdExist(user_id);
	}

	public void selleraddUserInfo(UserBean joinUserBean) {
		sellerMapper.addUserInfo(joinUserBean);

	}

}
