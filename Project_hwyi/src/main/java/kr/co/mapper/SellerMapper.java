package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface SellerMapper {

	// ���̵� �ߺ� üũ�� ���� sql
	@Select("select ID " + "from member " + "where ID=#{ID}")
	String checkUserIdExist(String ID);
	
	
	// ȸ������ DB ���
	@Insert("insert all into member(code, id, pw, name, mail, phone, address) "
			+ "values (('Se' || TO_CHAR(user_seq.nextval)), #{ID}, #{PW}, #{Name}, #{Mail}, #{Phone}, #{Address})"
			+ "into store(code, strcode, straddress, strtel)"
			+ "values(('Se' || TO_CHAR(user_seq.nextval)), #{strcode}, #{straddress}, #{strtel})"
			+ "SELECT * FROM DUAL")
	void addUserInfo(UserBean joinUserBean);
	
	@Select("select m.*, s.* "
			+ "from member m, store s "
			+ "where m.code = s.code")
	List<UserBean> getSellerList();

}
