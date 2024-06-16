package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface BuyerMapper {

	// 아이디 중복 체크에 사용된 sql
	@Select("select ID " + "from member " + "where ID=#{id}")
	String checkBuyerIdExist(String ID);

	// 회원가입 DB 등록
	@Insert("insert all into member (code, id, pw, name, mail, phone, address) "
			+ "values (('Cu' || TO_CHAR(user_seq.nextval)), #{id}, #{pw}, #{name}, #{mail}, #{phone}, #{address})"
			+ "into customer(code, favarite)" + "values(('Cu' || TO_CHAR(user_seq.nextval)), null)"
			+ "SELECT * FROM DUAL")
	void addBuyerInfo(UserBean joinUserBean);

	// 로그인시 회원가입 정보 확인
	@Select("select m.code, m.name from member m, customer c where id=#{id} and pw=#{pw} and c.code = m.code")
	UserBean getLoginBuyerInfo(UserBean tempLoginUserBean);

	// 전체 Buyer 목록 불러오기
	@Select("select m.*, c.favarite " + "from member m, customer c " + "where m.code = c.code")
	List<UserBean> getBuyerList();

}