package kr.co.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.beans.PageBean;
import kr.co.beans.UserBean;
import kr.co.dao.UserDao;

@Service
public class UserbuyerService {

	@Autowired
	private UserDao userDao;

	// 넘겨받은 해당 아이디를 사용하여 반환받은 이름이 사용가능한지 판단 여부
	public boolean checkUserExist(String id) {
		String name = userDao.buyercheckUserExist(id);

		if (name == null) {
			return true; // 사용가능
		}
		return false; // 이미 존재하는 user_name
	}

	public void addUserInfo(UserBean joinUserBean) {
		userDao.buyeraddUserInfo(joinUserBean);

	}

	public List<UserBean> getBuyerList() {

		return userDao.getBuyerList();
	}

}