package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.beans.AddressBean;

public interface AddressMapper {

	@Select("select a.address_name, a.member_name, a.member_phone, a.member_post, a.member_add, a.member_addt "
			+ "from addresses a inner join member m on a.code = m.code where a.code = #{code}")
	List<AddressBean> getAllAddress(String code);


	@Update("UPDATE addresses SET code = 'delete_address' "
			+ "WHERE code = #{code} AND address_name = #{address_name} AND member_name = #{member_name} AND member_phone = #{member_phone} AND member_post = #{member_post} AND member_add = #{member_add} AND member_addt = #{member_addt}")
	void deleteAddress(AddressBean memberAddrBean);


	@Insert("INSERT INTO addresses (address_id, code, address_name, member_name, member_phone, member_post, member_add, member_addt)"
			+ "VALUES ('AD'||lpad(address_seq.nextval, 8, 0),#{code} , #{address_name}, #{member_name}, #{member_phone}, #{addrDetail}, #{roadAddrPart1}, #{zipNo})")
	void addAddrInfo(AddressBean memberAddrBean);


	@Select("select address_id, code, address_name, member_name, member_phone, member_post,member_add, member_addt "
			+ "from addresses where code = #{code}")
	List<AddressBean> getAddrById(String code);

	@Select("select * from addresses where address_id = #{address_id}")
	AddressBean getAddrByAddrId(String address_id);

}