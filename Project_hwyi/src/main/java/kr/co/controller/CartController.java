
package kr.co.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.CartBean;
import kr.co.beans.FurnitureBean;
import kr.co.dao.FurnitureDao;
import kr.co.service.CartService;
import kr.co.service.FurnitureService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
    private CartService cartService; // ��ٱ��� ����

	@GetMapping("/cart_main")
	public String cart_main() {
		return "cart/cart_main";
	}
	
	@GetMapping("/cart_details")
	public String cartPage(Model model, String code) {
		List<CartBean> cartItems = cartService.getCartBycode(code);
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
	public ResponseEntity<String> deleteCartItem(@RequestParam("code") String code,
			@RequestParam("furnitureid") String furnitureid) {
		try {
			int affectedRows = cartService.deleteCart(code, furnitureid);
			if (affectedRows > 0) {
				return ResponseEntity.ok("���� ����");
			} else {
				return ResponseEntity.badRequest().body("���� ����: �ش� ��ǰ�� ��ٱ��Ͽ� �����ϴ�.");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("���� ����: " + e.getMessage());
		}
	}
}
