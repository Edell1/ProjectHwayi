package kr.co.mapper;

import kr.co.beans.CartBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartMapper {

	// ��� ��ٱ��� ��� ��ȸ
	@Select("SELECT * FROM Cart")
	List<CartBean> getAllCarts();

	@Select("select c.*, m.* from cart c, member m where c.code = m.code and m.code = #{code}")
	List<CartBean> getCartItemByMemberId(@Param("code") String code);
	
    // Ư�� ȸ���� ��ٱ��� ��� ��ȸ
    @Select("SELECT cart_id, code, furnitureid, count, price " +
            "FROM Cart " +
            "WHERE code = #{code}")
    List<CartBean> getCartBycode(@Param("code") String code);

    // Ư�� ȸ���� Ư�� ��ǰ ��ٱ��� ���� ��ȸ
    @Select("SELECT * FROM Cart WHERE code = #{code} AND furnitureid = #{furnitureid}")
    CartBean getCarByfurnitureIdAndCode(@Param("code") String code,
                                               @Param("furnitureid") String furnitureid);

    // Ư�� ȸ���� ��ٱ��� ���� ��ȸ
    @Select("SELECT * FROM Cart WHERE code = #{code}")
    List<CartBean> getCntCart(String code);
    
	@Select("select count(*) from Cart")
	int getProductCnt();

    // ��ٱ��� �׸� ����
    @Delete("DELETE FROM Cart WHERE code = #{code} AND furnitureid = #{furnitureid}")
    int deleteCart(@Param("code") String code, @Param("furnitureid") String furnitureid);

    // ��ٱ��� ���� ����
    @Update("UPDATE Cart SET furnitureid = #{cart.furnitureid}, " +
            "count = #{cart.count}, price = #{cart.price} " +
            "WHERE cart_id = #{cart.cart_id}")
    void updateCart(@Param("cart") CartBean cart);

    // ��ٱ��Ͽ� ��ǰ �߰�
    @Insert("INSERT INTO Cart (cart_id, code, furnitureid, count, price) " +
            "VALUES (cart_seq.NEXTVAL, #{code}, #{furnitureid}, #{count}, #{price})")
    void addCart(CartBean cart);

}