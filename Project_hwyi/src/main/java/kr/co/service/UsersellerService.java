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

	// �Ѱܹ��� �ش� ���̵� ����Ͽ� ��ȯ���� �̸��� ��밡������ �Ǵ� ����
<<<<<<< HEAD
	public boolean checkUserExist(String ID) {
		String name = userDao.sellercheckUserExist(ID);
		
		if(name == null) {
=======
	public boolean checkUserExist(String id) {
		String name = userDao.checkSellerIdExist(id);

		if (name == null) {
>>>>>>> refs/remotes/origin/heumE
			return true; // ��밡��
		}
		return false; // �̹� �����ϴ� user_name
	}

	public void addUserInfo(UserBean joinUserBean) {
		userDao.addSellerInfo(joinUserBean);

	}

	public UserBean getLoginSellerInfo(UserBean tempLoginUserBean) {
		UserBean tempLoginUserBean2 = userDao.getLoginSellerInfo(tempLoginUserBean);
		// ������ �����Ͱ� �ִٸ�
		if (tempLoginUserBean2 != null) {
			loginUserBean.setCode(tempLoginUserBean2.getCode());
			loginUserBean.setName(tempLoginUserBean2.getName());
			loginUserBean.setUserLogin(true); // �α��� ����
			System.out.println("true" + loginUserBean.isUserLogin()); // true // �α��� ������ ��Ÿ���� true ��ȯ

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