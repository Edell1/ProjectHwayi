package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface SellerMapper {

	// 아이디 중복 체크에 사용된 sql
	@Select("select ID " + "from member " + "where ID=#{id}")
	String checkUserIdExist(String ID);

	// 회원가입 DB 등록
	@Insert("insert all into member(code, id, pw, name, mail, phone, address) "
			+ "values (('Se' || TO_CHAR(user_seq.nextval)), #{id}, #{pw}, #{name}, #{mail}, #{phone}, #{address})"
			+ "into store(code, strcode, straddress, strtel)"
			+ "values(('Se' || TO_CHAR(user_seq.nextval)), #{strcode}, #{straddress}, #{strtel})"
			+ "SELECT * FROM DUAL")
	void addUserInfo(UserBean joinUserBean);

	// 전체 Seller 목록 불러오기
	@Select("select m.*, s.* " + "from member m, store s " + "where m.code = s.code")
	List<UserBean> getSellerList();

}