package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface BuyerMapper {

	// 아이디 중복 체크에 사용된 sql
	@Select("select ID " + "from member " + "where ID=#{ID}")
	String buyercheckUserExist(String ID);

	// 회원가입 DB 등록
	@Insert("insert all into member (code, id, pw, name, mail, phone, address) "
			+ "values (('Cu' || TO_CHAR(user_seq.nextval)), #{ID}, #{PW}, #{Name}, #{Mail}, #{Phone}, #{Address})"
			+ "into customer(code, favarite)"
			+ "values(('Cu' || TO_CHAR(user_seq.nextval)), null)"
			+ "SELECT * FROM DUAL")
	void buyeraddUserInfo(UserBean joinUserBean);
	
	@Select("select m.*, c.favarite "
			+ "from member m, customer c "
			+ "where m.code = c.code")
	List<UserBean> getBuyerList();

}
