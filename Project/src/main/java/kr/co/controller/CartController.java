
package kr.co.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.CartBean;
import kr.co.beans.UserBean;
import kr.co.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
    private CartService cartService; // 장바구니 서비스
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/cart_main")
	public String cart_main() {
	    return "/cart/cart_main";
	}
	
	@GetMapping("/cart_details")
	public String cartPage(Model model, String code) {
		List<CartBean> cartItems = cartService.getCartItemByMemberId(code);
		model.addAttribute("cartItems", cartItems);
		return "cart/cart_main";
	}

}