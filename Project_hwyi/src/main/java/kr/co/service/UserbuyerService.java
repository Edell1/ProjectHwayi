package kr.co.service;

import java.util.List;

import javax.annotation.Resource;

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

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	// 넘겨받은 해당 아이디를 사용하여 반환받은 이름이 사용가능한지 판단 여부
	public boolean checkUserExist(String id) {
		String name = userDao.checkBuyerIdExist(id);

		if (name == null) {
			return true; // 사용가능
		}
		return false; // 이미 존재하는 user_name
	}

	public void addUserInfo(UserBean joinUserBean) {
		userDao.addBuyerInfo(joinUserBean);

	}

	public void getLoginUserInfo(UserBean tempLoginUserBean) {

		UserBean tempLoginUserBean2 = userDao.getLoginBuyerInfo(tempLoginUserBean);
		// 가져온 데이터가 있다면
		if (tempLoginUserBean2 != null) {
			loginUserBean.setCode(tempLoginUserBean2.getCode());
			loginUserBean.setName(tempLoginUserBean2.getName());
			loginUserBean.setUserLogin(true); // 로그인 상태
		}
		System.out.println("service " + loginUserBean.isUserLogin());
	}
	
	public UserBean selectBuyerById(String id) {
		UserBean memberBean = userDao.selectBuyerById(id);
		return memberBean;
	}
	
	public void modifyBuyerInfoByAdmin(UserBean modifyBuyerBean) {
		userDao.modifyBuyerInfoByAdmin(modifyBuyerBean);
	}
	

	public List<UserBean> getBuyerList() {
		return userDao.getBuyerList();
	}

}