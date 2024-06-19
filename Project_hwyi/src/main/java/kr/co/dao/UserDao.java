package kr.co.dao;

import java.util.List;

<<<<<<< HEAD
=======
import org.apache.ibatis.session.RowBounds;
>>>>>>> refs/remotes/origin/heumE
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

<<<<<<< HEAD
	public String buyercheckUserExist(String ID) {
		return buyerMapper.buyercheckUserExist(ID);
=======
	public String checkBuyerIdExist(String ID) {
		return buyerMapper.checkBuyerIdExist(ID);
>>>>>>> refs/remotes/origin/heumE
	}

	public void addBuyerInfo(UserBean joinUserBean) {
		buyerMapper.addBuyerInfo(joinUserBean);

	}

<<<<<<< HEAD
	public String sellercheckUserExist(String ID) {
		return sellerMapper.checkUserIdExist(ID);
=======
	public String checkSellerIdExist(String id) {
		return sellerMapper.checkSellerIdExist(id);
>>>>>>> refs/remotes/origin/heumE
	}

	public void addSellerInfo(UserBean joinUserBean) {
		sellerMapper.addSellerInfo(joinUserBean);

	}
	
<<<<<<< HEAD
	public List<UserBean> getBuyerList() {
		return buyerMapper.getBuyerList();
		
	}
	
	public List<UserBean> getSellerList() {
		return sellerMapper.getSellerList();
=======
	public UserBean getLoginBuyerInfo(UserBean tempLoginUserBean) {
		return buyerMapper.getLoginBuyerInfo(tempLoginUserBean);
		
	}
	
	public UserBean getLoginSellerInfo(UserBean tempLoginUserBean) {
		return sellerMapper.getLoginSellerInfo(tempLoginUserBean);
>>>>>>> refs/remotes/origin/heumE
		
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