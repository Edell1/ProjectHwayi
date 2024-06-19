package kr.co.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.FurnitureBean;
import kr.co.service.FurnitureService;

@Controller
@RequestMapping("/furniture")
public class FurnitureController {

	@Autowired
	private FurnitureService furnitureService;

	@GetMapping("/furniture_list")
	public String furniture_list(@RequestParam(value = "furnitureType", required = false) String furnitureType,
			Model model) {

		List<FurnitureBean> checkedfurniturelist;
		 //���� ī�װ��� �������� ī�װ��� �´� ��ǰ �������
	      if(furnitureType != null) {
	    	  checkedfurniturelist = furnitureService.getFurnitureListFromType(furnitureType);
	      }else {
		 //���� �⺻ ������ ��ü��ǰ �������
	    	  checkedfurniturelist = furnitureService.getCheckedFurnitureList();
	      }

		model.addAttribute("checkedfurniturelist", checkedfurniturelist);

		System.out.println("Controller" + checkedfurniturelist);
		return "/furniture/furniture_list";
	}

	@GetMapping("/furniture_detail")
	private String furniture_detail() {

		return "furniture/furniture_detail";

	}

}