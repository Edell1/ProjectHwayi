package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {
	
	@GetMapping("/main")
	public String main() {
		return "seller/main"; 
	}
	
	@GetMapping("/seller_productAdd")
	public String seller_productAdd() {
		return "seller/seller_productAdd"; 
	}


}