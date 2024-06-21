package kr.co.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.OrderBean;
import kr.co.mapper.OrderMapper;

@Repository
public class OrderDao {

	@Autowired
	private OrderMapper orderMapper;

	public List<OrderBean> getOrderListByMemberId(String code) {
		return orderMapper.getOrderListByMemberId(code);
	}

	public OrderBean getOrderByOrderId(String orderID) {
		return orderMapper.getOrderByOrderId(orderID);
	}

	// OrderList
	public OrderBean getProductInfo(String furnitureid) {
        return orderMapper.getProductInfo(furnitureid);
    }
	
	public List<OrderBean> getAllAddList(String code) {
		return orderMapper.getAllAddList(code);
	}
	

}
