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
	//joinUserBean이 getter setter을 보유하고 있음
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}
	
	@PostMapping("join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		//hasErrors() : 에러코드가 있냐? 유효성검사에 걸렸니?
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