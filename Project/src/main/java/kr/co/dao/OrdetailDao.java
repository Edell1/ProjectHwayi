package kr.co.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.OrdetailBean;
import kr.co.mapper.OrdetailMapper;

@Repository
public class OrdetailDao {

	@Autowired
	private OrdetailMapper ordetailMapper;
	
	public List<OrdetailBean> getOrdetailListByOrderId(String order_id) {
		return ordetailMapper.getOrdetailListByOrderId(order_id);
	}
	
	public List<OrdetailBean> getOrdetailByShopId(String code) {
		return ordetailMapper.getOrdetailByShopId(code);
	}

	public List<Integer> getProductSaleCnt(String furnitureid){
		return ordetailMapper.getProductSaleCnt(furnitureid);
	}
	
	public void submitOrderDetail(OrdetailBean submitOrdetailBean) {
		ordetailMapper.submitOrderDetail(submitOrdetailBean);
	}
}