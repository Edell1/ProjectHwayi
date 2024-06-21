package kr.co.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.OrderBean;
import kr.co.beans.UserBean;
import kr.co.service.OrderService;
import kr.co.service.UserbuyerService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	UserbuyerService userbuyerService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/order_main")
	public String main() {
		return "order/order_main";
	}

	@GetMapping("/order_add_details")
	public String orderPage(Model model, String code) {
		List<OrderBean> addLists = orderService.getAllAddList(code);
		model.addAttribute("addLists", addLists);
		return "order/order_main";
	}

	@PostMapping("/processOrder")
	public String processOrder(@RequestParam("furnitureid") List<String> productIds,
			@RequestParam("quantities") List<Integer> quantities, @RequestParam("totalPrice") String totalPrice,
			@RequestParam("finalPrice") String finalPrice, Model model) {

		List<OrderBean> productDetailsList = new ArrayList<>();
		String id = loginUserBean.getId();
		String code = loginUserBean.getCode();
		UserBean userBean = userbuyerService.selectBuyerById(id);
		model.addAttribute("userBean", userBean);

		for (int i = 0; i < productIds.size(); i++) {
			OrderBean productInfo = orderService.getProductInfo(productIds.get(i));
			if (productInfo != null) {
				productInfo.setItem_count(quantities.get(i));
				productDetailsList.add(productInfo);

			}
		}

		if (code != null && !code.isEmpty()) {
			List<OrderBean> addLists = orderService.getAllAddList(code);
			model.addAttribute("code", code);
			model.addAttribute("addLists", addLists);
		}

		List<OrderBean> addLists = orderService.getAllAddList(code);
		model.addAttribute("addLists", addLists);
		model.addAttribute("productDetails", productDetailsList);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("finalPrice", finalPrice);
		return "order/order_main";
	}

}
