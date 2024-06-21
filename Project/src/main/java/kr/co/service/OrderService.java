package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.OrderBean;
import kr.co.dao.OrderDao;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public List<OrderBean> getOrderListByMemberId(String code) {
		return orderDao.getOrderListByMemberId(code);
	}

	public OrderBean getOrderByOrderId(String orderID) {
		return orderDao.getOrderByOrderId(orderID);
	}
	

	public OrderBean getProductInfo(String furnitureid) {
		OrderBean productInfo = orderDao.getProductInfo(furnitureid);
		System.out.println("getProductInfo: " + productInfo); // 로그 출력
		return productInfo;
	}
	
	public List<OrderBean> getAllAddList(String code) {
		return orderDao.getAllAddList(code);
	}
	
}
