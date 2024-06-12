package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer_center")
public class CustomerCenterController {
	
	@GetMapping("/customer_center_main")
	public String customer_center_main() {
		return "customer_center/customer_center_main";
	}
	

}
