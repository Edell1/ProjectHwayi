package kr.co.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import kr.co.beans.PageBean;
import kr.co.beans.UserBean;
import kr.co.dao.UserDao;
import kr.co.service.FurnitureService;
import kr.co.service.UserAdminService;
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
	private UserAdminService userAdminService;

	@Autowired
	private FurnitureService furnitureService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/login_admin")
	public String login_admin(@ModelAttribute("tempLoginBean") UserBean tempLoginBean,
			@RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model) {
		model.addAttribute("fail", fail);
		return "admin/login_admin";
	}
	
    @PostMapping("/login_pro") //pro admin
    public String login_pro(@Valid @ModelAttribute("tempLoginBean") UserBean tempLoginBean, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "admin/login_admin";
        }
        // 세션 영역에 있는 로그인 정보 불러오기
        userAdminService.getLoginAdminInfo(tempLoginBean); //true
        
        if (loginUserBean.isUserLogin() ==true) {
            // 세션에 로그인 상태 및 사용자 정보 저장
            loginUserBean.setUserRole("admin"); // 역할 설정
            loginUserBean.setId(tempLoginBean.getId()); // 예시: 로그인한 사용자의 아이디 저장
            return "admin/login_success";
        } else {
            return "admin/login_admin";
        }
    }

	@RequestMapping("/main")
	public String main(Model model) {
		List<UserBean> buyerlist = userbuyerService.getBuyerList();
		List<UserBean> sellerlist = usersellerService.getSellerList();

		model.addAttribute("buyerlist", buyerlist);
		model.addAttribute("sellerlist", sellerlist);

		return "admin/main";
	}

	@GetMapping("/furniture_admin")
	public String furniture_admin(Model model) {
		List<FurnitureBean> furniturelist = furnitureService.getFurnitureList();
		model.addAttribute("furniturelist", furniturelist);

		System.out.println("Controller" + furniturelist);
		return "admin/furniture_admin";
	}

	@GetMapping("/buyer_info")
	public String buyer_info(@RequestParam("id") String id, Model model) {
		UserBean showBuyerBean = userbuyerService.selectBuyerById(id);
		model.addAttribute("showBuyerBean", showBuyerBean);
		return "admin/buyer_info";
	}

	@RequestMapping("/buyer_modify")
	public String buyer_modify(@ModelAttribute("modifyBuyerBean") UserBean modifyBuyerBean,
			@RequestParam("id") String id, Model model) {
		UserBean tempUserBean = userbuyerService.selectBuyerById(id);
		modifyBuyerBean.setId(id);
		modifyBuyerBean.setPw(tempUserBean.getPw());
		modifyBuyerBean.setName(tempUserBean.getName());
		modifyBuyerBean.setMail(tempUserBean.getMail());
		modifyBuyerBean.setPhone(tempUserBean.getPhone());
		modifyBuyerBean.setAddress(tempUserBean.getAddress());
		modifyBuyerBean.setAddress2(tempUserBean.getAddress2());

		model.addAttribute("id", id);

		return "admin/buyer_modify";
	}

	@PostMapping("/buyer_modify_pro")
	public String buyer_modify_pro(@ModelAttribute("modifyBuyerBean") UserBean modifyBuyerBean, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			return "admin/buyer_modify";
		}
		userbuyerService.modifyBuyerInfoByAdmin(modifyBuyerBean);
		model.addAttribute("id", modifyBuyerBean.getId());

		return "admin/buyer_modify_success";
	}

	@GetMapping("/seller_info")
	public String seller_info(@RequestParam("id") String id, Model model) {
		UserBean showSellerBean = usersellerService.selectSellerById(id);
		model.addAttribute("showSellerBean", showSellerBean);

		List<FurnitureBean> furniturelist = furnitureService.getFurnitureList();
		model.addAttribute("furniturelist", furniturelist);

		return "admin/seller_info";
	}

	@RequestMapping("/seller_modify")
	public String seller_modify(@ModelAttribute("modifySellerBean") UserBean modifySellerBean,
			@RequestParam("id") String id, Model model) {
		UserBean tempUserBean = usersellerService.selectSellerById(id);
		modifySellerBean.setId(id);
		modifySellerBean.setPw(tempUserBean.getPw());
		modifySellerBean.setName(tempUserBean.getName());
		modifySellerBean.setMail(tempUserBean.getMail());
		modifySellerBean.setPhone(tempUserBean.getPhone());
		modifySellerBean.setAddress(tempUserBean.getAddress());
		modifySellerBean.setAddress2(tempUserBean.getAddress2());
		modifySellerBean.setBrand(tempUserBean.getBrand());
		modifySellerBean.setStrtel(tempUserBean.getStrtel());
		modifySellerBean.setStraddress(tempUserBean.getStraddress());
		modifySellerBean.setStraddress2(tempUserBean.getStraddress2());

		model.addAttribute("id", id);

		return "admin/seller_modify";
	}

	@PostMapping("/seller_modify_pro")
	public String seller_modify_pro(@ModelAttribute("modifySellerBean") UserBean modifySellerBean, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			return "admin/seller_modify";
		}
		usersellerService.modifySellerInfoByAdmin(modifySellerBean);
		model.addAttribute("id", modifySellerBean.getId());

		return "admin/seller_modify_success";
	}

	@RequestMapping("/furniture_info")
	public String furniture_info(@RequestParam("furnitureid") String furnitureid, Model model) {
		FurnitureBean modifyFurnitureBean = furnitureService.selectFurnitureById(furnitureid);
		model.addAttribute("modifyFurnitureBean", modifyFurnitureBean);
		return "admin/furniture_info";
	}

	@RequestMapping("/furniture_modify")
	public String furniture_modify(@ModelAttribute("modifyFurnitureBean") FurnitureBean modifyFurnitureBean,
			Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/furniture_info";
		}
		modifyFurnitureBean.setChecked(0); // 가구 승인
		furnitureService.grantFurnitureInfoByAdmin(modifyFurnitureBean);
		System.out.println(modifyFurnitureBean.getChecked());
		return "admin/furniture_grant";
	}

	@GetMapping("/furniture_decline")
	public String furniture_decline() {
		return "admin/furniture_decline";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "admin/dashboard";
	}
	
	@GetMapping("/notice_list")
	public String notice_list() {
		return "admin/notice_list";
	}

}
