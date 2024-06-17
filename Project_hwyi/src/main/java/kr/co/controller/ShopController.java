package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {

//	@Autowired
//	private CartService cartService;

	@GetMapping("/cart")
	public String cart() {
		return "shop/cart";
	}
}