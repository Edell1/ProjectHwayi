package kr.co.mapper;

import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface AdminMapper {

	// �α��ν� ȸ������ ���� Ȯ��
	@Select("select * from member where id='admin' and pw='admin' and code = 'admin'")
	UserBean getLoginAdminInfo(UserBean tempLoginUserBean);
	
	

}
