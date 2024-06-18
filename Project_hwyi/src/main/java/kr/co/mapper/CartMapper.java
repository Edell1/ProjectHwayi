package kr.co.mapper;

import kr.co.beans.CartBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartMapper {

	// ��� ��ٱ��� ��� ��ȸ
	@Select("SELECT * FROM Cart")
	List<CartBean> getAllCarts();

    // Ư�� ȸ���� ��ٱ��� ��� ��ȸ
    @Select("SELECT cart_id, code, interiorid, furnitureid, count, price " +
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

    // ��ٱ��� �׸� ����
    @Delete("DELETE FROM Cart WHERE code = #{code} AND furnitureid = #{furnitureid}")
    int deleteCart(@Param("code") String code, @Param("furnitureid") String furnitureid);

    // ��ٱ��� ���� ����
    @Update("UPDATE Cart SET interiorid = #{interiorid}, " +
            "count = #{count}, price = #{price} " +
            "WHERE cart_id = #{cart_id}")
    void updateCart(CartBean cart);

    // ��ٱ��Ͽ� ��ǰ �߰�
    @Insert("INSERT INTO Cart (cart_id, code, interiorid, furnitureid, count, price) " +
            "VALUES (#{cart_id}, #{code}, #{interiorid}, #{furnitureid}, #{count}, #{price})")
    void addCart(CartBean cart);

}