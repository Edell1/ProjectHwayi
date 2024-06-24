package kr.co.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.ContentBean;
import kr.co.beans.PageBean;
import kr.co.beans.UserBean;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/customer_center")
public class CustomerCenterController {
   
      @Resource(name="loginUserBean")
      private UserBean loginUserBean;
   
   @Autowired
      private BoardService boardService;
   
   @GetMapping("/customer_center_main")
   public String customer_center_main() {
      return "customer_center/customer_center_main";
   }
   
   @GetMapping("/main")
   public String main(Model model) {
      
      model.addAttribute("loginUserBean", loginUserBean);

      List<ContentBean> qnaList= boardService.getQnAList();
      model.addAttribute("qnaList",qnaList);
      
      return "customer_center/main";
   }

}
