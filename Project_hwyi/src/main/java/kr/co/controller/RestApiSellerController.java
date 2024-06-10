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
	
	@GetMapping("/user/checkSellerIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		// @PathVariable : �ּҿ� ������ ���̱�
		Boolean chk = userService.checkUserExist(user_id);
		return chk + "";
	}
	
}
