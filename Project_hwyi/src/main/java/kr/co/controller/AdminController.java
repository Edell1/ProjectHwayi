package kr.co.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.PageBean;
import kr.co.beans.UserBean;
import kr.co.dao.UserDao;
import kr.co.service.UserbuyerService;
import kr.co.service.UsersellerService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UsersellerService usersellerService;

	@Autowired
	private UserbuyerService userbuyerService;

	@RequestMapping("/main")
	public String main(HttpServletRequest request, Model model) {
		List<UserBean> buyerlist = userbuyerService.getBuyerList();
		List<UserBean> sellerlist = usersellerService.getSellerList();

		request.setAttribute("buyerlist", buyerlist);
		request.setAttribute("sellerlist", sellerlist);

		return "admin/main";
	}

}