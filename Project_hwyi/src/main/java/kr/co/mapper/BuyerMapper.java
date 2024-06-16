package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface BuyerMapper {

	// ���̵� �ߺ� üũ�� ���� sql
	@Select("select ID " + "from member " + "where ID=#{user_id}")
	String checkBuyerIdExist(String ID);

	// ȸ������ DB ���
	@Insert("insert all into member (code, id, pw, name, mail, phone, address) "
			+ "values (('Cu' || TO_CHAR(user_seq.nextval)), #{user_id}, #{user_pw}, #{user_name}, #{user_email}, #{user_tel}, #{user_add1})"
			+ "into customer(code, favarite)" + "values(('Cu' || TO_CHAR(user_seq.nextval)), null)"
			+ "SELECT * FROM DUAL")
	void addBuyerInfo(UserBean joinUserBean);

	// �α��ν� ȸ������ ���� Ȯ��
	@Select("select member.code, name from member, customer where ID=#{user_id} and PW=#{user_pw} and customer.code = member.code")
	UserBean getLoginBuyerInfo(UserBean tempLoginUserBean);

	// ��ü Buyer ��� �ҷ�����
	@Select("select m.*, c.favarite " + "from member m, customer c " + "where m.code = c.code")
	List<UserBean> getBuyerList();

}