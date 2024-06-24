package kr.co.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.OrdetailBean;

public interface OrdetailMapper {
	
	@Select("select o.*, f.* "
			+ "from order_detail o, Furniture f "
			+ "where orderID = #{orderID} and o.furnitureid = f.furnitureid")
	List<OrdetailBean> getOrdetailListByOrderId(String orderID); 
	
	@Select("select o.*, f.*, s.* "
			+ "from order_detail o "
			+ "join Furniture f on o.furnitureid = f.furnitureid "
			+ "join store s on f.code = s.code "
			+ "where s.code = #{code}")
	List<OrdetailBean> getOrdetailByShopId(String code);
	
	@Select("select count "
			+ "from order_detail "
			+ "where furnitureid = #{furnitureid}")
	List<Integer> getProductSaleCnt(String furnitureid);
	
	@Insert("insert into order_detail values('OD'||lpad(ordetail_seq.nextval, 8, 0), #{orderID}, #{furnitureid}, #{price}, #{count})")
	void submitOrderDetail(OrdetailBean submitOrdetailBean);

}