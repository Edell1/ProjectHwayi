package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.beans.UserBean;

public interface SellerMapper {

	// ���̵� �ߺ� üũ�� ���� sql
<<<<<<< HEAD
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
=======
	@Select("select ID " + "from member " + "where ID=#{id}")
	String checkSellerIdExist(String ID);
>>>>>>> refs/remotes/origin/heumE

	// ȸ������ DB ���
	@Insert("insert all into member(code, id, pw, name, mail, phone, address, address2) "
			+ "values (('Se' || TO_CHAR(user_seq.nextval)), #{id}, #{pw}, #{name}, #{mail}, #{phone}, #{address}, #{address2})"
			+ "into store(code, strcode, straddress, straddress2, strtel, brand)"
			+ "values(('Se' || TO_CHAR(user_seq.nextval)), #{strcode}, #{straddress}, #{straddress2}, #{strtel}, #{brand})"
			+ "SELECT * FROM DUAL")
	void addSellerInfo(UserBean joinUserBean);

	// �α��ν� ȸ������ ���� Ȯ��
	@Select("select member.code, name from member, store where ID=#{id} and PW=#{pw} and store.code = member.code")
	UserBean getLoginSellerInfo(UserBean tempLoginUserBean);

	// ��ü Seller ��� �ҷ�����
	@Select("select m.*, s.* from member m, store s where m.code = s.code")
	List<UserBean> getSellerList();

	// ���̵�� ȸ�� ���� Ȯ��
	@Select("SELECT m.*, s.* FROM member m, store s WHERE id = #{id} and m.code = s.code")
	UserBean selectSellerById(String id);

	// ȸ�� ���� ����
	@Update("update member set name=#{name}, pw=#{pw}, mail=#{mail}, phone=#{phone} , address=#{address} where id=#{id}")
	void modifySellerInfo(UserBean modifySellerBean);

	// �����ڱ��� ȸ�� ���� ����
	@Update("update member set name=#{name}, mail=#{mail}, phone=#{phone}, address=#{address}, address2=#{address2} where id=#{id}")
	void modifySellerInfoByAdmin(UserBean modifySellerBean);

}