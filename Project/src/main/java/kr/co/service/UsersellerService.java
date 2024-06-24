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
public class UsersellerService {

	@Autowired
	private UserDao userDao;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	// 넘겨받은 해당 아이디를 사용하여 반환받은 이름이 사용가능한지 판단 여부
	public boolean checkUserExist(String id) {
		String name = userDao.checkSellerIdExist(id);

		if (name == null) {
			return true; // 사용가능
		}
		return false; // 이미 존재하는 user_name
	}

	public void addUserInfo(UserBean joinUserBean) {
		userDao.addSellerInfo(joinUserBean);

	}

	public UserBean getLoginSellerInfo(UserBean tempLoginUserBean) {
		UserBean tempLoginUserBean2 = userDao.getLoginSellerInfo(tempLoginUserBean);
		// 가져온 데이터가 있다면
		if (tempLoginUserBean2 != null) {
			loginUserBean.setCode(tempLoginUserBean2.getCode());
			loginUserBean.setName(tempLoginUserBean2.getName());
			loginUserBean.setUserLogin(true); // 로그인 상태
			System.out.println("true" + loginUserBean.isUserLogin()); // true // 로그인 성공을 나타내는 true 반환

		}
		return userDao.getLoginSellerInfo(tempLoginUserBean);
	}

	public UserBean selectSellerById(String id) {
		UserBean memberBean = userDao.selectSellerById(id);
		return memberBean;
	}

	public void modifySellerInfoByAdmin(UserBean modifySellerBean) {
		userDao.modifySellerInfoByAdmin(modifySellerBean);
	}

	public List<UserBean> getSellerList() {

		return userDao.getSellerList();
	}

}