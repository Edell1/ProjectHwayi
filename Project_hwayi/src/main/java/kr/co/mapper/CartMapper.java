package kr.co.mapper;

import kr.co.beans.CartBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartMapper {

	// ����� code�� īƮ�� ��ǰ ���� �б�
	@Select("select c.*, f.* from cart c join furniture f on c.furnitureid = f.furnitureid where c.code = #{code}")
	List<CartBean> getCartItemByMemberId(@Param("code") String code);

	// ������� cart���� Ư�� ��ǰ ����
	@Delete("delete from cart where code=#{code} and furnitureid=#{furnitureid} ")
	int deleteCartItem(@Param("code") String code, @Param("furnitureid") String furnitureid);

	// īƮ�� ��ǰ���̵�, ���� ����
	@Insert("INSERT INTO cart (cart_id, code, furnitureid, count, price, furnitureName) VALUES (cart_seq.nextval, #{code}, #{furnitureid}, #{count}, #{price}, #{furnitureName})")
	void insertCartItem(CartBean addCartBean);

	// ��������
	@Update("UPDATE cart SET count = #{count} WHERE code = #{code} AND furnitureid = #{furnitureid}")
	void updateCartItem(CartBean cartBean);

	// Ư�� ������� īƮ�� Ư�� ��ǰ�� ����ִ��� Ȯ��
	@Select("SELECT * FROM cart WHERE code = #{code} AND furnitureid = #{furnitureid}")
	CartBean getCartItemByProductIdAndMemberId(@Param("code") String code, @Param("furnitureid") String furnitureid);

	// ����� īƮ ���� ���
	@Select("select * from cart where code = #{code}")
	List<CartBean> getCntCart(String code);

	@Delete("DELETE FROM cart WHERE code = #{code}")
	int deleteAllCartItems(String code);
	
}