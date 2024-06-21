package kr.co.mapper;

import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface AdminMapper {

	// 로그인시 회원가입 정보 확인
	@Select("select * from member where id='admin' and pw='admin' and code = 'admin'")
	UserBean getLoginAdminInfo(UserBean tempLoginUserBean);
	
	

}
