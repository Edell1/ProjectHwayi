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
		// ������ �����Ͱ� �ִٸ�
		if (tempLoginUserBean2 != null) {
			loginUserBean.setCode(tempLoginUserBean2.getCode());
			loginUserBean.setName(tempLoginUserBean2.getName());
			loginUserBean.setUserLogin(true); // �α��� ����
			System.out.println("true" + loginUserBean.isUserLogin()); // true // �α��� ������ ��Ÿ���� true ��ȯ

		}
		return userDao.getLoginAdminInfo(tempLoginUserBean);
	}


}