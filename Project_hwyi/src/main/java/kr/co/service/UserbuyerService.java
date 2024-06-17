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

	// �Ѱܹ��� �ش� ���̵� ����Ͽ� ��ȯ���� �̸��� ��밡������ �Ǵ� ����
	public boolean checkUserExist(String id) {
		String name = userDao.checkBuyerIdExist(id);

		if (name == null) {
			return true; // ��밡��
		}
		return false; // �̹� �����ϴ� user_name
	}

	public void addUserInfo(UserBean joinUserBean) {
		userDao.addBuyerInfo(joinUserBean);

	}

	public void getLoginUserInfo(UserBean tempLoginUserBean) {

		UserBean tempLoginUserBean2 = userDao.getLoginBuyerInfo(tempLoginUserBean);
		// ������ �����Ͱ� �ִٸ�
		if (tempLoginUserBean2 != null) {
			loginUserBean.setCode(tempLoginUserBean2.getCode());
			loginUserBean.setName(tempLoginUserBean2.getName());
			loginUserBean.setUserLogin(true); // �α��� ����
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