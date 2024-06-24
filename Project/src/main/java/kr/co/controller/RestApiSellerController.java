package kr.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.service.UsersellerService;

@RestController
public class RestApiSellerController {
	
	@Autowired
	private UsersellerService userService;
	
	@GetMapping("/user/checkSellerIdExist/{id}")
	public String checkUserIdExist(@PathVariable String id) {
		// @PathVariable : ÁÖ¼Ò¿¡ µ¥ÀÌÅÍ ºÙÀÌ±â
		Boolean chk = userService.checkUserExist(id);
		return chk + "";
	}
	
}