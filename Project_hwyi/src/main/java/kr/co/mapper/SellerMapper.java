package kr.co.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface SellerMapper {

	// 아이디 중복 체크에 사용된 sql
	@Select("select ID " + "from member " + "where ID=#{user_id}")
	String checkUserIdExist(String user_id);
	
	// 회원가입 DB 등록
	@Insert("insert all into member(code, id, pw, name, mail, phone, address) "
			+ "values (('Se' || TO_CHAR(user_seq.nextval)), #{user_id}, #{user_pw}, #{user_name}, #{user_email}, #{user_tel}, #{user_add1})"
			+ "into store(code, strcode, straddress, strtel)"
			+ "values(('Se' || TO_CHAR(user_seq.nextval)), #{seller_num}, #{seller_add1}, #{seller_tel})"
			+ "SELECT * FROM DUAL")
	void addUserInfo(UserBean joinUserBean);

}
