package kr.co.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.OrdetailBean;
import kr.co.beans.UserBean;
import kr.co.dao.OrdetailDao;

@Service
public class OrdetailService {
	
	@Autowired
	private OrdetailDao ordetailDao;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private FurnitureService furnitureService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	
	public void submitOrderDetail(List<String> furnitureid, List<Integer> count) {
		int orderID = orderService.getFirstOrderId();
		for(int i=0; i<furnitureid.size(); i++) {
			OrdetailBean submitOrdetailBean = new OrdetailBean();
			submitOrdetailBean.setOrderID(orderID);
			submitOrdetailBean.setFurnitureid(furnitureid.get(i));
			submitOrdetailBean.setCount(count.get(i));
			ordetailDao.submitOrderDetail(submitOrdetailBean);
			cartService.deleteCartItem(loginUserBean.getId(), furnitureid.get(i));
			/* furnitureService.minusProductQty(furnitureid.get(i), count.get(i)); */
		}
	}

}
