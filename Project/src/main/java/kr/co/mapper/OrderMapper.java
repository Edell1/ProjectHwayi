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
	
	// 배송지 입력 정보
	@Select("select order_addr, order_name, order_phone, order_req from Total_orders where code = #{code}")
	List<OrderBean> getAllAddList(@Param("code") String code);

}
