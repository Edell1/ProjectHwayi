package kr.co.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.UserBean;
import kr.co.dao.UserDao;

@Service
public class UserAdminService {

	@Autowired
	private UserDao userDao;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	public UserBean getLoginAdminInfo(UserBean tempLoginUserBean) {
		UserBean tempLoginUserBean2 = userDao.getLoginAdminInfo(tempLoginUserBean);
		// 가져온 데이터가 있다면
		if (tempLoginUserBean2 != null) {
			loginUserBean.setCode(tempLoginUserBean2.getCode());
			loginUserBean.setName(tempLoginUserBean2.getName());
			loginUserBean.setUserLogin(true); // 로그인 상태
			System.out.println("true" + loginUserBean.isUserLogin()); // true // 로그인 성공을 나타내는 true 반환

		}
		return userDao.getLoginAdminInfo(tempLoginUserBean);
	}


}