package kr.co.controller;

import java.util.List;

import javax.annotation.Resource;
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
import kr.co.beans.UserBean;
import kr.co.service.FurnitureService;

@Controller
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private FurnitureService furnitureService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("furniture_management")
	public String furniture_management(Model model) {
		String seller_code = loginUserBean.getCode();
		System.out.println("seller_code" + seller_code);
		List<FurnitureBean> furnitueListfromSeller = furnitureService.getFurnitureListfromSeller(seller_code);
		model.addAttribute("furnitueListfromSeller", furnitueListfromSeller);
		return "seller/furniture_management";
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

	@RequestMapping("product_info")
	public String product_info(@RequestParam("furnitureid") String furnitureid, Model model) {
		FurnitureBean modifyProductBean = furnitureService.selectProductById(furnitureid);
		model.addAttribute("modifyProductBean", modifyProductBean);
		System.out.println(modifyProductBean.getFurnitureid());
		System.out.println(modifyProductBean.getFurniture_type());
		System.out.println(modifyProductBean.getFurniture_color());
		System.out.println(modifyProductBean.getFurniture_price());
		System.out.println(modifyProductBean.getFurniture_mat());
		System.out.println(modifyProductBean.getFurniture_date());
		System.out.println(furnitureid);

		return "seller/product_info";
	}

	@RequestMapping("product_modify")
	public String product_modify(@ModelAttribute("modifyProductBean") FurnitureBean modifyProductBean,
			@RequestParam("furnitureid") String furnitureid, Model model) {
		FurnitureBean modifyProductBean2 = furnitureService.selectProductById(furnitureid);

		System.out.println(furnitureid);
		modifyProductBean.setFurniture_name(modifyProductBean2.getFurniture_name());
		modifyProductBean.setFurnitureid(furnitureid);
		modifyProductBean.setFurniture_color(modifyProductBean2.getFurniture_color());
		modifyProductBean.setFurniture_mat(modifyProductBean2.getFurniture_mat());
		modifyProductBean.setFurniture_width(modifyProductBean2.getFurniture_width());
		modifyProductBean.setFurniture_length(modifyProductBean2.getFurniture_length());
		modifyProductBean.setFurniture_height(modifyProductBean2.getFurniture_height());
		modifyProductBean.setFurniture_price(modifyProductBean2.getFurniture_price());
		modifyProductBean.setFurniture_cnt(modifyProductBean2.getFurniture_cnt());
		modifyProductBean.setTag(modifyProductBean2.getTag());
		modifyProductBean.setFurniture_img1(modifyProductBean2.getFurniture_img1());

		System.out.println(modifyProductBean.getFurnitureid());
		model.addAttribute("furniture_color", modifyProductBean2.getFurniture_color());
		model.addAttribute("furniture_mat", modifyProductBean2.getFurniture_mat());
		model.addAttribute("furniture_width", modifyProductBean2.getFurniture_width());
		model.addAttribute("furniture_length", modifyProductBean2.getFurniture_length());
		model.addAttribute("furniture_height", modifyProductBean2.getFurniture_height());
		model.addAttribute("furnitureid", modifyProductBean2.getFurnitureid());

		return "seller/product_modify";

	}

	@PostMapping("product_modify_pro")
	public String product_modify_pro(@ModelAttribute("modifyProductBean") FurnitureBean modifyProductBean, Model model,
			BindingResult result) {

		if (result.hasErrors()) {
			return "seller/product_modify";
		}
		System.out.println(modifyProductBean.getFurnitureid());
		furnitureService.modifyProduct(modifyProductBean);
		model.addAttribute("code", modifyProductBean.getCode());

		return "seller/product_modify_success";

	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "seller/dashboard";
	}

}