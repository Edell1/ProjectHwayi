package kr.co.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.FurnitureBean;
import kr.co.beans.PageBean;
import kr.co.beans.UserBean;
import kr.co.dao.UserDao;
import kr.co.service.FurnitureService;
import kr.co.service.UserbuyerService;
import kr.co.service.UsersellerService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UsersellerService usersellerService;

	@Autowired
	private UserbuyerService userbuyerService;

	@Autowired
	private FurnitureService furnitureService;

	@RequestMapping("/main")
	public String main(Model model) {
		List<UserBean> buyerlist = userbuyerService.getBuyerList();
		List<UserBean> sellerlist = usersellerService.getSellerList();

		model.addAttribute("buyerlist", buyerlist);
		model.addAttribute("sellerlist", sellerlist);

		return "admin/main";
	}

	@GetMapping("/furniture_main")
	public String furniture_main(Model model) {
		List<FurnitureBean> furniturelist = furnitureService.getFurnitureList();
		model.addAttribute("furniturelist", furniturelist);

		System.out.println("Controller" + furniturelist);
		return "admin/furniture_main";
	}

}