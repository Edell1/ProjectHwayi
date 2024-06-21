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
import kr.co.dao.FurnitureDao;
import kr.co.service.CartService;
import kr.co.service.FurnitureService;

@Controller
@RequestMapping("/furniture")
public class FurnitureController {

	@Autowired
	private FurnitureService furnitureService;

	@Autowired
	private CartService cartService;

	@Autowired
	private FurnitureDao furnitureDao;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/furniture_list")
	public String furniture_list(@RequestParam(value = "furnitureType", required = false) String furnitureType,
			@RequestParam(value = "keyword", required = false) String keyword, Model model) {

		List<FurnitureBean> checkedfurniturelist;

		// 상품을 검색했을때
		if (keyword != null && !keyword.isEmpty()) {
			List<FurnitureBean> searchResults = furnitureDao.searchProducts(keyword);
			System.out.println("검색결과 컨트롤러: " + searchResults);
			model.addAttribute("checkedfurniturelist", searchResults);
			model.addAttribute("isSearchResult", true);
		} else {
			// 상품검색안했을때
			// 카테고리를 선택했을때
			if (furnitureType != null) {
				checkedfurniturelist = furnitureService.getFurnitureListFromType(furnitureType);

			} else {
				// 가구 기본 페이지 전체상품 갖고오기
				checkedfurniturelist = furnitureService.getCheckedFurnitureList();
			}

			model.addAttribute("checkedfurniturelist", checkedfurniturelist);
			model.addAttribute("isSearchResult", false);
			System.out.println("Controller" + checkedfurniturelist);
		}
		return "/furniture/furniture_list";
	}

	@GetMapping("/furniture_list_filter")
	public String furniture_list(@RequestParam(value = "furnitureType", required = false) String furnitureType,
			@RequestParam(value = "color", required = false, defaultValue = "noFilter") String color,
			@RequestParam(value = "brand", required = false, defaultValue = "noFilter") String brand,
			@RequestParam(value = "width", required = false, defaultValue = "1000") int width,
			@RequestParam(value = "length", required = false, defaultValue = "1000") int length,
			@RequestParam(value = "height", required = false, defaultValue = "1000") int height, Model model) {

		List<FurnitureBean> checkedfurniturelist;

		// 색상과 브랜드를 모두 선택했을때
		if (color != null && brand != null) {
			checkedfurniturelist = furnitureService.getFurnitureListFromFilterAll(furnitureType, color, brand, width,
					length, height);

		}

		checkedfurniturelist = furnitureService.getFurnitureListFromFilterAll(furnitureType, color, brand, width,
				length, height);

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
		FurnitureBean oneFurnitureBean = furnitureService.selectFurnitureById(furnitureid);

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

		return "furniture/furniture_detail";
	}

	@GetMapping("/addCart_pro")
	public String cart_add(@ModelAttribute("addCartBean") CartBean addCartBean,
			@RequestParam("furnitureid") String furnitureid, @RequestParam("cnt") int cnt, @RequestParam("price") int price, @RequestParam("name") String name) {
		CartBean existingCartItem = cartService.getCartItemByProductIdAndMemberId(loginUserBean.getCode(), furnitureid);

		if (existingCartItem != null) {
			existingCartItem.setCount(existingCartItem.getCount() + cnt);
			cartService.updateCartItem(existingCartItem);
		} else {
			addCartBean.setCount(cnt);
			addCartBean.setFurnitureid(furnitureid);
			addCartBean.setCode(loginUserBean.getCode());
			addCartBean.setPrice(price);
			addCartBean.setFurnitureName(name);
			cartService.insertCartItem(addCartBean);
		}
			
		return "cart/add_cart_success";
	}

}