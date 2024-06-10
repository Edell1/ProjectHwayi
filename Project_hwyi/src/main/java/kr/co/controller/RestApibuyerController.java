package kr.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.service.UserbuyerService;

@RestController
public class RestApibuyerController {
	
	@Autowired
	private UserbuyerService userService;
	
	@GetMapping("/user/checkBuyerExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		// @PathVariable : 주소에 데이터 붙이기
		Boolean chk = userService.checkUserExist(user_id);
		return chk + "";
	}
	
}
