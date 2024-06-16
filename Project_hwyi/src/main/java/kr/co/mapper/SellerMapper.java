package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface SellerMapper {

	// 아이디 중복 체크에 사용된 sql
	@Select("select ID " + "from member " + "where ID=#{user_id}")
	String checkSellerIdExist(String ID);

	// 회원가입 DB 등록
	@Insert("insert all into member(code, id, pw, name, mail, phone, address) "
			+ "values (('Se' || TO_CHAR(user_seq.nextval)), #{user_id}, #{user_pw}, #{user_name}, #{user_email}, #{user_tel}, #{user_add1})"
			+ "into store(code, strcode, straddress, strtel)"
			+ "values(('Se' || TO_CHAR(user_seq.nextval)), #{seller_num}, #{seller_add1}, #{seller_tel})"
			+ "SELECT * FROM DUAL")
	void addSellerInfo(UserBean joinUserBean);

	// 로그인시 회원가입 정보 확인
	@Select("select member.code, name from member, store where ID=#{user_id} and PW=#{user_pw} and store.code = member.code")
	UserBean getLoginBuyerInfo(UserBean tempLoginUserBean);

	// 전체 Seller 목록 불러오기
	@Select("select m.*, s.* " + "from member m, store s " + "where m.code = s.code")
	List<UserBean> getSellerList();

}