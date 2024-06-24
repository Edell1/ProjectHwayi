package kr.co.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.beans.UserBean;
import kr.co.service.SearchService;
import kr.co.service.UserbuyerService;
import kr.co.service.UsersellerService;
import kr.co.validator.UserValidator;

@Controller
@RequestMapping("/user")
@SessionAttributes("loginUserBean")
public class UserController {

    @Autowired
    private UserbuyerService userbuyerService;

    @Autowired
    private UsersellerService usersellerService;

    @Autowired
    private SearchService searchService;

    @Resource(name = "loginUserBean")
    private UserBean loginUserBean;

    @GetMapping("/login_choice")
    public String login_choice() {
        return "user/login_choice";
    }

    @GetMapping("/login_buyer")
    public String login_buyer(@ModelAttribute("tempLoginBean") UserBean tempLoginBean,
                              @RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model) {
        model.addAttribute("fail", fail);
        return "user/login_buyer";
    }

    @GetMapping("/login_seller")
    public String login_seller(@ModelAttribute("tempLoginBean") UserBean tempLoginBean,
                               @RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model) {
        model.addAttribute("fail", fail);
        return "user/login_seller";
    }

    @PostMapping("/login_pro1") //pro1 buyer
    public String login_pro1(@Valid @ModelAttribute("tempLoginBean") UserBean tempLoginBean, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "user/login_buyer";
        }

        // 세션 영역에 있는 로그인 정보 불러오기
        userbuyerService.getLoginBuyerInfo(tempLoginBean); //true

        if (loginUserBean.isUserLogin() ==true) {
            // 세션에 로그인 상태 및 사용자 정보 저장
            loginUserBean.setUserRole("buyer"); // 역할 설정
            loginUserBean.setId(tempLoginBean.getId()); // 예시: 로그인한 사용자의 아이디 저장
            return "user/login_success";
        } else {
            return "user/login_buyer";
        }
    }

    @PostMapping("/login_pro2")
    public String login_pro2(@Valid @ModelAttribute("tempLoginBean") UserBean tempLoginBean, BindingResult result,
                             Model model) {

        if (result.hasErrors()) {
            return "user/login_seller";
        }

        // 세션 영역에 있는 로그인 정보 불러오기
        usersellerService.getLoginSellerInfo(tempLoginBean); //true

        if (loginUserBean.isUserLogin() ==true) {
            // 세션에 로그인 상태 및 사용자 정보 저장
            loginUserBean.setUserRole("seller"); // 역할 설정
            loginUserBean.setId(tempLoginBean.getId()); // 예시: 로그인한 사용자의 아이디 저장
            return "seller/login_success";
        } else {
            return "user/login_seller";
        }
    }

    @GetMapping("/join_choice")
    public String join_choice() {
        return "user/join_choice";
    }

    @GetMapping("/join_buyer")
    public String join_buyer(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
        return "user/join_buyer";
    }

    @GetMapping("/join_seller")
    public String join_seller(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
        return "user/join_seller";
    }

    @PostMapping("join_pro1")
    public String join_pro1(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {

        if (result.hasErrors()) {
            return "user/join_buyer";
        }

        userbuyerService.addUserInfo(joinUserBean);
        return "user/join_success_buyer";
    }

    @PostMapping("join_pro2")
    public String join_pro2(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {

        if (result.hasErrors()) {
            return "user/join_seller";
        }

        usersellerService.addUserInfo(joinUserBean);
        return "user/join_success_seller";
    }

    @GetMapping("/searchId_buyer")
    public String searchId_buyer(UserBean userBean, Model model) {
        model.addAttribute("userBean", userBean);
        return "user/searchId_buyer";
    }

    @RequestMapping("/searchBuyerIdResult")
    public String searchBuyerIdResult(@ModelAttribute("userBean") UserBean userBean, Model model) {
        String userId = null;
        try {
            userId = searchService.searchBuyerId(userBean.getName(), userBean.getPhone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userBean.getName());
        return "user/searchBuyerIdResult";
    }

    @GetMapping("/searchId_seller")
    public String searchId_seller(UserBean userBean, Model model) {
        model.addAttribute("userBean", userBean);
        return "user/searchId_seller";
    }

    @RequestMapping("/searchSellerIdResult")
    public String searchSellerIdResult(@ModelAttribute("userBean") UserBean userBean, Model model) {
        String userId = null;
        try {
            userId = searchService.searchSellerId(userBean.getName(), userBean.getPhone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userBean.getName());
        return "user/searchSellerIdResult";
    }

    @GetMapping("/modify")
    public String modify() {
        return "user/modify";
    }

    @GetMapping("/logout")
    public String logout() {
        loginUserBean.setUserLogin(false);
        loginUserBean.setUserRole("null");
        loginUserBean.setId(null); // 예시: 로그아웃 시 사용자 아이디 초기화
        System.out.println(loginUserBean.getUserRole());
        return "user/logout";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        UserValidator validator1 = new UserValidator();
        binder.addValidators(validator1);
    }

    @GetMapping("/mypage")
    public String mypage() {
        return "user/mypage";
    }
    
    @GetMapping("/mypage_order_info")
    public String mypage_order_info() {
        return "user/mypage_order_info";
    }
}