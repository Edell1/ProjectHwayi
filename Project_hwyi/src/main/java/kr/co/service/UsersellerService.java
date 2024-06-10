package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.UserBean;
import kr.co.dao.UserDao;

@Service
public class UsersellerService {
	
	@Autowired
	private UserDao userdao;
	
	// �Ѱܹ��� �ش� ���̵� ����Ͽ� ��ȯ���� �̸��� ��밡������ �Ǵ� ����
	public boolean checkUserExist(String user_id) {
		String user_name = userdao.sellercheckUserExist(user_id);
		
		if(user_name == null) {
			return true; // ��밡��
		}
		return false; // �̹� �����ϴ� user_name
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userdao.selleraddUserInfo(joinUserBean);
		
	}
	
}
