package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface SellerMapper {

	// ���̵� �ߺ� üũ�� ���� sql
	@Select("select ID " + "from member " + "where ID=#{user_id}")
	String checkSellerIdExist(String ID);

	// ȸ������ DB ���
	@Insert("insert all into member(code, id, pw, name, mail, phone, address) "
			+ "values (('Se' || TO_CHAR(user_seq.nextval)), #{user_id}, #{user_pw}, #{user_name}, #{user_email}, #{user_tel}, #{user_add1})"
			+ "into store(code, strcode, straddress, strtel)"
			+ "values(('Se' || TO_CHAR(user_seq.nextval)), #{seller_num}, #{seller_add1}, #{seller_tel})"
			+ "SELECT * FROM DUAL")
	void addSellerInfo(UserBean joinUserBean);

	// �α��ν� ȸ������ ���� Ȯ��
	@Select("select member.code, name from member, store where ID=#{user_id} and PW=#{user_pw} and store.code = member.code")
	UserBean getLoginBuyerInfo(UserBean tempLoginUserBean);

	// ��ü Seller ��� �ҷ�����
	@Select("select m.*, s.* " + "from member m, store s " + "where m.code = s.code")
	List<UserBean> getSellerList();

}