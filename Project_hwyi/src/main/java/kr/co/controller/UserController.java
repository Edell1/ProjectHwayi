package kr.co.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.beans.UserBean;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/join_choice")
	public String join_choice() {
		return "user/join_choice";
	}
	
	//@ModelAttribute("joinUserBean") : UserBean joinUserBean=new UserBean()
	//joinUserBean�� getter setter�� �����ϰ� ����
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}
	
	@PostMapping("join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		//hasErrors() : �����ڵ尡 �ֳ�? ��ȿ���˻翡 �ɷȴ�?
		if(result.hasErrors()) {
			return "user/join";
		}
		
		return "user/join_success";
	}
	
	@GetMapping("/modify")
	public String modify() {
	return "user/modify";
	}
	
	@GetMapping("/logout")
	public String logout() {
	return "user/logout";
		}

}