package kr.co.mapper;

import kr.co.beans.CartBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartMapper {

	// 사용자 code로 카트의 상품 정보 읽기
	@Select("select c.*, f.* from cart c join furniture f on c.furnitureid = f.furnitureid where c.code = #{code}")
	List<CartBean> getCartItemByMemberId(@Param("code") String code);

	// 사용자의 cart에서 특정 상품 삭제
	@Delete("delete from cart where code=#{code} and furnitureid=#{furnitureid} ")
	int deleteCartItem(@Param("code") String code, @Param("furnitureid") String furnitureid);

	// 카트에 상품아이디, 수량 저장
	@Insert("INSERT INTO cart (cart_id, code, furnitureid, count, price, furnitureName) VALUES (cart_seq.nextval, #{code}, #{furnitureid}, #{count}, #{price}, #{furnitureName})")
	void insertCartItem(CartBean addCartBean);

	// 수량변경
	@Update("UPDATE cart SET count = #{count} WHERE code = #{code} AND furnitureid = #{furnitureid}")
	void updateCartItem(CartBean cartBean);

	// 특정 사용자의 카트에 특정 상품이 담겨있는지 확인
	@Select("SELECT * FROM cart WHERE code = #{code} AND furnitureid = #{furnitureid}")
	CartBean getCartItemByProductIdAndMemberId(@Param("code") String code, @Param("furnitureid") String furnitureid);

	// 사용자 카트 개수 출력
	@Select("select * from cart where code = #{code}")
	List<CartBean> getCntCart(String code);

	@Delete("DELETE FROM cart WHERE code = #{code}")
	int deleteAllCartItems(String code);
	
}