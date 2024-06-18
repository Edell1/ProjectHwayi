package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.beans.UserBean;

public interface BuyerMapper {

	// 아이디 중복 체크에 사용된 sql
	@Select("select ID " + "from member " + "where ID=#{id}")
	String checkBuyerIdExist(String ID);

	// 회원가입 DB 등록
	@Insert("insert all into member (code, id, pw, name, mail, phone, address, address2) "
			+ "values (('Cu' || TO_CHAR(user_seq.nextval)), #{id}, #{pw}, #{name}, #{mail}, #{phone}, #{address}, #{address2}) "
			+ "into customer(code, favarite)" + "values(('Cu' || TO_CHAR(user_seq.nextval)), null) "
			+ "SELECT * FROM DUAL")
	void addBuyerInfo(UserBean joinUserBean);

	// 로그인시 회원가입 정보 확인
	@Select("select m.*, c.favarite from member m, customer c where id=#{id} and pw=#{pw} and c.code = m.code")
	UserBean getLoginBuyerInfo(UserBean tempLoginUserBean);

	// 전체 Buyer 목록 불러오기
	@Select("select m.*, c.favarite " + "from member m, customer c " + "where m.code = c.code")
	List<UserBean> getBuyerList();
	
	// 아이디로 회원 정보 확인
	@Select("SELECT m.*, c.favarite FROM member m, customer c WHERE id = #{id} and m.code = c.code")
	UserBean selectBuyerById(String id);

	// 회원 정보 수정
	@Update("update member set name=#{name}, pw=#{pw}, mail=#{mail}, phone=#{phone} , address=#{address} where id=#{id}")
	void modifyBuyerInfo(UserBean modifyBuyerBean);
	
	// 관리자권한 회원 정보 수정
	@Update("update member set name=#{name}, mail=#{mail}, phone=#{phone}, address=#{address}, address2=#{address2} where id=#{id}")
	void modifyBuyerInfoByAdmin(UserBean modifyBuyerBean);

}