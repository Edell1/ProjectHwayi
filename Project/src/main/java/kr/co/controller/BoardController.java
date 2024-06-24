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

import kr.co.beans.ContentBean;
import kr.co.beans.PageBean;
import kr.co.beans.UserBean;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
   
   @Autowired
   private BoardService boardService;
   
   @Resource(name="loginUserBean")
   private UserBean loginUserBean;
   
//   @GetMapping("/read")
//   public String read(@RequestParam("board_info_idx") int board_info_idx, 
//                    @RequestParam("content_idx") int content_idx,
//                    @RequestParam(value="page", defaultValue="1")int page,
//                    Model model) {
//
//      model.addAttribute("board_info_idx", board_info_idx);
//      model.addAttribute("content_idx", content_idx);
//      model.addAttribute("loginUserBean", loginUserBean);
//      
//      ContentBean readContentBean=boardService.getContentInfo(content_idx);
//      model.addAttribute("readContentBean", readContentBean);
//      model.addAttribute("page", page);
//
//      return "board/read";
//   }
   

//    @GetMapping("/write") public String write(@ModelAttribute("writeContentBean")
//    ContentBean writeContentBean,
//    
//    @RequestParam("board_info_idx") int board_info_idx) {
//    
//    writeContentBean.setContent_board_idx(board_info_idx);
//     
//    return "board/write"; }
   
   
   @GetMapping("/read")
   public String read(@RequestParam("content_idx") int content_idx,
                     Model model) {
         model.addAttribute("content_idx", content_idx);
         model.addAttribute("loginUserBean", loginUserBean);
         
         ContentBean readQnABean=boardService.getQnAInfo(content_idx);
         model.addAttribute("readQnABean",readQnABean);
      
     
      return "board/read";
      }
   
   @GetMapping("/write")
   public String write(@ModelAttribute("writeQnABean") ContentBean writeQnABean ) {
     
      return "board/write";
      }
   
   @PostMapping("/write_pro")
   public String write_pro(@Valid @ModelAttribute("writeQnABean") ContentBean writeQnABean, BindingResult result) {
     System.out.println(writeQnABean.getSecret());

      
      boardService.addContentInfo(writeQnABean);
      
      return "board/write_success";
   }
   @PostMapping("/answer_write_pro")
   public String answer_write_pro( @ModelAttribute("writeQnABean") ContentBean writeQnABean) {
	   System.out.println(writeQnABean.getContent_idx());
	   System.out.println(writeQnABean.getAcontent());
	   
	   
	   boardService.updateQnAInfo(writeQnABean);
	   
	   return "board/write_success";
   }
   
   @GetMapping("/not_writer")
   public String not_writer() {
      return "board/not_writer";
   }
   
   @GetMapping("/answer_write")
   public String answer(@RequestParam("content_idx") int content_idx,
		   @ModelAttribute("writeQnABean") ContentBean writeQnABean,
		                Model model) {
	   ContentBean readQnABean=boardService.getQnAInfo(content_idx);
	   
	   
       model.addAttribute("content_idx", content_idx);
       model.addAttribute("loginUserBean", loginUserBean);
       
       model.addAttribute("readQnABean",readQnABean);
	   
       return "board/answer_write";
   }
   
   @GetMapping("/modify")
   public String modify(@RequestParam("board_info_idx") int board_info_idx, 
                      @RequestParam("content_idx") int content_idx,
                        @ModelAttribute("modifyContentBean") ContentBean modifyContentBean,
                        @RequestParam(value="page", defaultValue="1")int page,
                        Model model) {
      
      model.addAttribute("board_info_idx", board_info_idx);
      model.addAttribute("content_idx", content_idx);
      model.addAttribute("page", page);
      
      // Խñ   ϳ                   
      ContentBean tempContentBean = boardService.getContentInfo(content_idx);

      return "board/modify";
   }
   
   @PostMapping("/modify_pro")
   public String modify_pro(@Valid @ModelAttribute("modifyContentBean") ContentBean modifyContentBean, 
                          @RequestParam("page") int page,
                          BindingResult result,
                          Model model) {
      
      if(result.hasErrors()) {
         return "board/modify";
      }
      
      //      Ʈ
      boardService.modifyContentInfo(modifyContentBean);
      
      model.addAttribute("page",page);
      
      return "board/modify_success";
   }
   
   @GetMapping("/delete")
   public String delete(@RequestParam("content_idx") int content_idx, Model model) {
      
      boardService.deleteQnAInfo(content_idx);
      model.addAttribute("loginUserBean", loginUserBean);
      return "board/delete_success";
   }
   
}