package kr.co.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
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

	public String buyercheckUserExist(String ID) {
		return buyerMapper.buyercheckUserExist(ID);
	}

	public void buyeraddUserInfo(UserBean joinUserBean) {
		buyerMapper.buyeraddUserInfo(joinUserBean);

	}

	public String sellercheckUserExist(String id) {
		return sellerMapper.checkUserIdExist(id);
	}

	public void selleraddUserInfo(UserBean joinUserBean) {
		sellerMapper.addUserInfo(joinUserBean);

	}

	public List<UserBean> getBuyerList() {
		return buyerMapper.getBuyerList();

	}

	public List<UserBean> getSellerList() {
		return sellerMapper.getSellerList();

	}

}