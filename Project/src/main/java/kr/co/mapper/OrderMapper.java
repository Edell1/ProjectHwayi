package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.OrderBean;

@Mapper
public interface OrderMapper {

	@Select("select * from Total_orders where code = #{code} order by rownum desc")
	List<OrderBean> getOrderListByMemberId(String code);

	@Select("select * from Total_orders where orderID = #{orderID}")
	OrderBean getOrderByOrderId(String orderID);

	@Select("SELECT furnitureid, furniture_name, furniture_price FROM Furniture WHERE furnitureid = #{furnitureid}")
	OrderBean getProductInfo(String furnitureid);

	// ¹è¼ÛÁö ÀÔ·Â Á¤º¸
	@Select("select * from addresses where code = #{code}")
	List<OrderBean> getAllAddList(@Param("code") String code);

	@Select("select orderID from Total_orders order by orderID desc fetch first 1 row only")
	int getFirstOrderId();

}