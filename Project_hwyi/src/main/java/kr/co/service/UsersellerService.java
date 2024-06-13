package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.UserBean;
import kr.co.dao.UserDao;

@Service
public class UsersellerService {
	
	@Autowired
	private UserDao userDao;
	
	// �Ѱܹ��� �ش� ���̵� ����Ͽ� ��ȯ���� �̸��� ��밡������ �Ǵ� ����
	public boolean checkUserExist(String ID) {
		String name = userDao.sellercheckUserExist(ID);
		
		if(name == null) {
			return true; // ��밡��
		}
		return false; // �̹� �����ϴ� user_name
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userDao.selleraddUserInfo(joinUserBean);
		
	}
	
}