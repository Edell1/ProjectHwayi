
package kr.co.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/totalPrice")
	public String getTotalPrice(Model model, String code) {
		int totalPrice = cartService.calculateTotalPrice(code);
		model.addAttribute("totalPrice", totalPrice);
		return "cart/cart_main";
	}

	@PostMapping("/deleteItem")
	public ResponseEntity<String> deleteCartItem(@RequestParam("member_id") String code,
			@RequestParam("product_id") String furnitureid) {
		try {
			int affectedRows = cartService.deleteCartItem(code, furnitureid);
			if (affectedRows > 0) {
				return ResponseEntity.ok("");
			} else {
				return ResponseEntity.badRequest().body("");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("" + e.getMessage());
		}
	}

	@PostMapping("/deleteAllItems")
	public ResponseEntity<String> deleteAllCartItems(@RequestParam("code") String code) {
		try {
			int affectedRows = cartService.deleteAllCartItems(code);
			if (affectedRows > 0) {
				return ResponseEntity.ok("");
			} else {
				return ResponseEntity.badRequest().body("삭제할 항목이 없습니다.");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("서버 오류: " + e.getMessage());
		}
	}

}