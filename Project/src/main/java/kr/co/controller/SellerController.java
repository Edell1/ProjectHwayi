package kr.co.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.FurnitureBean;
import kr.co.service.FurnitureService;

@Controller
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private FurnitureService furnitureService;

	@GetMapping("/main")
	public String main() {
		return "seller/main";
	}

	@GetMapping("/seller_productAdd")
	public String seller_productAdd(@ModelAttribute("addFurnitureBean") FurnitureBean addFurnitureBean) {
		return "seller/seller_productAdd";
	}

	@PostMapping("/furnitureAdd_pro")
	public String furnitureAdd_pro(@Valid @ModelAttribute("addFurnitureBean") FurnitureBean addFurnitureBean,
			BindingResult result) {
		if (result.hasErrors()) {
			return "seller/seller_productAdd";
		}

		furnitureService.addFurnitureInfo(addFurnitureBean);

		return "seller/add_furniture_success";
	}

	@GetMapping("furniture_management")
	public String furniture_management(@RequestParam("seller_code") String seller_code, Model model) {
		System.out.println(seller_code);
		List<FurnitureBean> furnitueListfromSeller = furnitureService.getFurnitureListfromSeller(seller_code);
		model.addAttribute("furnitueListfromSeller", furnitueListfromSeller);
		return "seller/furniture_management";
	}

}