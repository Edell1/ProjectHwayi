package kr.co.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.CartBean;
import kr.co.beans.FurnitureBean;
import kr.co.beans.UserBean;
import kr.co.service.CartService;
import kr.co.service.FurnitureService;

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

	@GetMapping("/furniture_detail")
	public String furniture_detail(@RequestParam("furnitureid") String furnitureid, Model model) {
		FurnitureBean furniture = furnitureService.getFurnitureById(furnitureid);
		model.addAttribute("furnitureBean", furniture);
		return "/furniture/furniture_detail"; // JSP ÆÄÀÏ ÀÌ¸§
	}

	@GetMapping("/furniture_brand")
	public String furniture_brand() {
		return "/furniture/furniture_brand";
	}

	@PostMapping("/addToCart_pro")
	public String addToCartPro(@ModelAttribute("addCartBean") CartBean addCartBean,
			@RequestParam("furnitureid") String furnitureid, @RequestParam("code") String code,
			@RequestParam("price") int price, @RequestParam("count") int count) {

		addCartBean.setFurnitureid(furnitureid);
		addCartBean.setCode(loginUserBean.getCode());
		cartService.updateCart(addCartBean);

		cartService.addCartInfo(furnitureid, code, price, count);

		return "cart/add_cart_success";
	}

}
