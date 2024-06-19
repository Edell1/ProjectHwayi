package kr.co.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.UserBean;
import kr.co.mapper.AdminMapper;
import kr.co.mapper.BuyerMapper;
import kr.co.mapper.SellerMapper;

@Repository
public class UserDao {

	@Autowired
	private BuyerMapper buyerMapper;

	@Autowired
	private SellerMapper sellerMapper;
	
	@Autowired
	private AdminMapper adminMapper;

	public String checkBuyerIdExist(String ID) {
		return buyerMapper.checkBuyerIdExist(ID);
	}

	public void addBuyerInfo(UserBean joinUserBean) {
		buyerMapper.addBuyerInfo(joinUserBean);

	}

	public String checkSellerIdExist(String id) {
		return sellerMapper.checkSellerIdExist(id);
	}

	public void addSellerInfo(UserBean joinUserBean) {
		sellerMapper.addSellerInfo(joinUserBean);

	}
	
	public UserBean getLoginBuyerInfo(UserBean tempLoginUserBean) {
		return buyerMapper.getLoginBuyerInfo(tempLoginUserBean);
	}
	
	public UserBean getLoginSellerInfo(UserBean tempLoginUserBean) {
		return sellerMapper.getLoginSellerInfo(tempLoginUserBean);
	}
	
	public UserBean getLoginAdminInfo(UserBean tempLoginUserBean) {
		return adminMapper.getLoginAdminInfo(tempLoginUserBean);
	}

	public List<UserBean> getBuyerList() {
		return buyerMapper.getBuyerList();
	}

	public List<UserBean> getSellerList() {
		return sellerMapper.getSellerList();
	}
	
	public UserBean selectBuyerById(String id) {
		return buyerMapper.selectBuyerById(id);
	}
	
	public UserBean selectSellerById(String id) {
		return sellerMapper.selectSellerById(id);
	}
	
	public void modifyBuyerInfoByAdmin(UserBean modifyBuyerBean) {
		buyerMapper.modifyBuyerInfoByAdmin(modifyBuyerBean);
	}
	
	public void modifySellerInfoByAdmin(UserBean modifySellerBean) {
		sellerMapper.modifySellerInfoByAdmin(modifySellerBean);
	}

}