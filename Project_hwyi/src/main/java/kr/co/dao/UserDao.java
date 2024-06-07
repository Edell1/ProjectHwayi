package kr.co.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.UserBean;
import kr.co.mapper.BuyerMapper;

@Repository
public class UserDao {

	@Autowired
	private BuyerMapper buyerMapper;


	public String checkUserExist(String user_id) {
		return buyerMapper.checkUserIdExist(user_id);
	}

	public void addUserInfo(UserBean joinUserBean) {
		buyerMapper.addUserInfo(joinUserBean);

	}


}
