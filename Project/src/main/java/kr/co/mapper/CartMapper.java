package kr.co.mapper;

import kr.co.beans.CartBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartMapper {

	// 모든 장바구니 목록 조회
	@Select("SELECT * FROM Cart")
	List<CartBean> getAllCarts();

	@Select("select c.*, m.* from cart c, member m where c.code = m.code and m.code = #{code}")
	List<CartBean> getCartItemByMemberId(@Param("code") String code);
	
    // 특정 회원의 장바구니 목록 조회
    @Select("SELECT cart_id, code, furnitureid, count, price " +
            "FROM Cart " +
            "WHERE code = #{code}")
    List<CartBean> getCartBycode(@Param("code") String code);

    // 특정 회원의 특정 상품 장바구니 정보 조회
    @Select("SELECT * FROM Cart WHERE code = #{code} AND furnitureid = #{furnitureid}")
    CartBean getCarByfurnitureIdAndCode(@Param("code") String code,
                                               @Param("furnitureid") String furnitureid);

    // 특정 회원의 장바구니 수량 조회
    @Select("SELECT * FROM Cart WHERE code = #{code}")
    List<CartBean> getCntCart(String code);
    
	@Select("select count(*) from Cart")
	int getProductCnt();

    // 장바구니 항목 삭제
    @Delete("DELETE FROM Cart WHERE code = #{code} AND furnitureid = #{furnitureid}")
    int deleteCart(@Param("code") String code, @Param("furnitureid") String furnitureid);

    // 장바구니 정보 수정
    @Update("UPDATE Cart SET furnitureid = #{cart.furnitureid}, " +
            "count = #{cart.count}, price = #{cart.price} " +
            "WHERE cart_id = #{cart.cart_id}")
    void updateCart(@Param("cart") CartBean cart);

    // 장바구니에 상품 추가
    @Insert("INSERT INTO Cart (cart_id, code, furnitureid, count, price) " +
            "VALUES (cart_seq.NEXTVAL, #{code}, #{furnitureid}, #{count}, #{price})")
    void addCart(CartBean cart);

}