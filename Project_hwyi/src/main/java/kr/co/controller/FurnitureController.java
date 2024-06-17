package kr.co.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.beans.FurnitureBean;
import kr.co.dao.FurnitureDao;
import kr.co.service.FurnitureService;

@Controller
@RequestMapping("/furniture")
public class FurnitureController {

	@Autowired
	private FurnitureService furnitureService;

	@GetMapping("/furniture_list")
	public String furniture_list(Model model) {
		List<FurnitureBean> furniturelist = furnitureService.getFurnitureList();
		model.addAttribute("furniturelist", furniturelist);

		System.out.println("Controller" + furniturelist);
		return "/furniture/furniture_list";
	}
}