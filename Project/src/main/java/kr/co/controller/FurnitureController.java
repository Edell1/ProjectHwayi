package kr.co.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.CartBean;
import kr.co.beans.FurnitureBean;
import kr.co.beans.UserBean;
import kr.co.service.CartService;
import kr.co.service.FurnitureService;
import oracle.net.aso.f;

@Controller
@RequestMapping("/furniture")
public class FurnitureController {

	@Autowired
	private FurnitureService furnitureService;

	@Autowired
	private CartService cartService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/furniture_list")
	public String furniture_list(@RequestParam(value = "furnitureType", required = false) String furnitureType,
			Model model) {

		List<FurnitureBean> checkedfurniturelist;
		// 가구 카테고리를 눌렀을때 카테고리에 맞는 상품 갖고오기
		if (furnitureType != null) {
			checkedfurniturelist = furnitureService.getFurnitureListFromType(furnitureType);
		} else {
			// 가구 기본 페이지 전체상품 갖고오기
			checkedfurniturelist = furnitureService.getCheckedFurnitureList();
		}

		model.addAttribute("checkedfurniturelist", checkedfurniturelist);

		System.out.println("Controller" + checkedfurniturelist);
		return "/furniture/furniture_list";
	}

	@GetMapping("/furniture_brand")
	public String furniture_brand() {
		return "/furniture/furniture_brand";
	}

	@GetMapping("/furniture_detail")
	public String furniture_detail(@RequestParam("furnitureid") String furnitureid,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		FurnitureBean oneFurnitureBean = furnitureService.getFurnitureById(furnitureid);
		
		CartBean furnitureCartBean = new CartBean();
		furnitureCartBean.setCount(1);
		
		model.addAttribute("furnitureid", furnitureid);
		
		/*
		 * List<ReviewBean> reviewList =
		 * reviewService.getAllReviewByProductId(product_id, page);
		 * model.addAttribute("reviewList", reviewList); AdminPageBean pageBean =
		 * reviewService.getReviewCntByProductId(product_id, page);
		 * model.addAttribute("pageBean", pageBean);
		 */
		
		model.addAttribute("oneFurnitureBean", oneFurnitureBean);
		model.addAttribute("furnitureCartBean", furnitureCartBean);

		return "/furniture/furniture_detail";
	}

	@GetMapping("/addCart_pro")
	public String cart_add(@ModelAttribute("addCartBean") CartBean addCartBean,
			@RequestParam("furnitureid") String furnitureid, @RequestParam("count") int count) {
		CartBean existingCartItem = cartService.getCartItemByProductIdAndMemberId(loginUserBean.getCode(), furnitureid);

		if (existingCartItem != null) {
			existingCartItem.setCount(existingCartItem.getCount() + count);
			cartService.updateCartItem(existingCartItem);
		} else {
			addCartBean.setCount(count);
			addCartBean.setFurnitureid(furnitureid);
			addCartBean.setCode(loginUserBean.getCode());
			cartService.insertCartItem(addCartBean);
		}

		return "cart/add_cart_success";
	}

}
