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

	// �Ѱܹ��� �ش� ���̵� ����Ͽ� ��ȯ���� �̸��� ��밡������ �Ǵ� ����
	public boolean checkUserExist(String id) {
		String name = userDao.buyercheckUserExist(id);

		if (name == null) {
			return true; // ��밡��
		}
		return false; // �̹� �����ϴ� user_name
	}

	public void addUserInfo(UserBean joinUserBean) {
		userDao.buyeraddUserInfo(joinUserBean);

	}

	public List<UserBean> getBuyerList() {

		return userDao.getBuyerList();
	}

}