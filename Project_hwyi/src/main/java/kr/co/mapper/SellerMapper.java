package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.beans.UserBean;

public interface SellerMapper {

	// 아이디 중복 체크에 사용된 sql
<<<<<<< HEAD
	@Select("select ID " + "from member " + "where ID=#{ID}")
	String checkUserIdExist(String ID);
	
	
	// 회원가입 DB 등록
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
=======
	@Select("select ID " + "from member " + "where ID=#{id}")
	String checkSellerIdExist(String ID);
>>>>>>> refs/remotes/origin/heumE

	// 회원가입 DB 등록
	@Insert("insert all into member(code, id, pw, name, mail, phone, address, address2) "
			+ "values (('Se' || TO_CHAR(user_seq.nextval)), #{id}, #{pw}, #{name}, #{mail}, #{phone}, #{address}, #{address2})"
			+ "into store(code, strcode, straddress, straddress2, strtel, brand)"
			+ "values(('Se' || TO_CHAR(user_seq.nextval)), #{strcode}, #{straddress}, #{straddress2}, #{strtel}, #{brand})"
			+ "SELECT * FROM DUAL")
	void addSellerInfo(UserBean joinUserBean);

	// 로그인시 회원가입 정보 확인
	@Select("select member.code, name from member, store where ID=#{id} and PW=#{pw} and store.code = member.code")
	UserBean getLoginSellerInfo(UserBean tempLoginUserBean);

	// 전체 Seller 목록 불러오기
	@Select("select m.*, s.* from member m, store s where m.code = s.code")
	List<UserBean> getSellerList();

	// 아이디로 회원 정보 확인
	@Select("SELECT m.*, s.* FROM member m, store s WHERE id = #{id} and m.code = s.code")
	UserBean selectSellerById(String id);

	// 회원 정보 수정
	@Update("update member set name=#{name}, pw=#{pw}, mail=#{mail}, phone=#{phone} , address=#{address} where id=#{id}")
	void modifySellerInfo(UserBean modifySellerBean);

	// 관리자권한 회원 정보 수정
	@Update("update member set name=#{name}, mail=#{mail}, phone=#{phone}, address=#{address}, address2=#{address2} where id=#{id}")
	void modifySellerInfoByAdmin(UserBean modifySellerBean);

}