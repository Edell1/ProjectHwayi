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
	
<<<<<<< HEAD
	@GetMapping("/user/checkBuyerExist/{ID}")
	public String checkUserIdExist(@PathVariable String ID) {
=======
	@GetMapping("/user/checkBuyerExist/{id}")
	public String checkUserIdExist(@PathVariable String id) {
>>>>>>> refs/remotes/origin/heumE
		// @PathVariable : �ּҿ� ������ ���̱�
<<<<<<< HEAD
		Boolean chk = userService.checkUserExist(ID);
=======
		Boolean chk = userService.checkUserExist(id);
>>>>>>> refs/remotes/origin/heumE
		return chk + "";
	}
	
}
