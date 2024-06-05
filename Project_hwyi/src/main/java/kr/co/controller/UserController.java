package kr.co.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.beans.UserBean;
import kr.co.service.UserService;
import kr.co.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@GetMapping("/join_choice")
	public String join_choice() {
		return "user/join_choice";
	}

	// @ModelAttribute("joinUserBean") : UserBean joinUserBean=new UserBean()
	// joinUserBean이 getter setter을 보유하고 있음
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}

	// @ModelAttribute("joinUserBean") : UserBean joinUserBean=new UserBean()
	// joinUserBean이 getter setter을 보유하고 있음
	@GetMapping("/join_seller")
	public String join_seller(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join_seller";
	}

	@PostMapping("join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		// hasErrors() : 에러코드가 있냐? 유효성검사에 걸렸니?
		if (result.hasErrors()) {
			return "user/join";
		}
		userService.addUserInfo(joinUserBean);
		return "user/join_success";
	}

	@PostMapping("join_pro2")
	public String join_pro2(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		// hasErrors() : 에러코드가 있냐? 유효성검사에 걸렸니?
		if (result.hasErrors()) {
			return "user/join_seller";
		}

		userService.addUserInfo(joinUserBean);
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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);

	}

}