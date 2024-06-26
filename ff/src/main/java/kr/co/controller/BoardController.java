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
//		              @RequestParam("content_idx") int content_idx,
//		              @RequestParam(value="page", defaultValue="1")int page,
//		              Model model) {
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
   

//	 @GetMapping("/write") public String write(@ModelAttribute("writeContentBean")
//	 ContentBean writeContentBean,
//	 
//	 @RequestParam("board_info_idx") int board_info_idx) {
//	 
//	 writeContentBean.setContent_board_idx(board_info_idx);
//	  
//	 return "board/write"; }
	
   
   @PostMapping("/read")
   public String read() {
     
      return "board/read";
      }
   
   @GetMapping("/write")
   public String write() {
     
      return "board/write";
      }
   
   @PostMapping("/write_pro")
   public String write_pro(@Valid @ModelAttribute("writeContentBean") ContentBean writeContentBean, BindingResult result) {
      
      if(result.hasErrors()) {
         return "board/write";
      }
      
      boardService.addContentInfo(writeContentBean);
      
      return "board/write_success";
   }
   
   @GetMapping("/not_writer")
   public String not_writer() {
      return "board/not_writer";
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
      
      //게시글 하나의 상세정보 가져오기
      ContentBean tempContentBean = boardService.getContentInfo(content_idx);
      
      modifyContentBean.setContent_writer_name(tempContentBean.getContent_writer_name());
      modifyContentBean.setContent_date(tempContentBean.getContent_date());
      modifyContentBean.setContent_subject(tempContentBean.getContent_subject());
      modifyContentBean.setContent_text(tempContentBean.getContent_text());
      modifyContentBean.setContent_file(tempContentBean.getContent_file());
      modifyContentBean.setContent_writer_idx(tempContentBean.getContent_writer_idx());
      modifyContentBean.setContent_board_idx(board_info_idx); //param값 그대로 가져오기
      modifyContentBean.setContent_idx(content_idx); //parm값 그대로 가져오기
      
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
      
      //업데이트
      boardService.modifyContentInfo(modifyContentBean);
      
      model.addAttribute("page",page);
      
      return "board/modify_success";
   }
   
   @GetMapping("/delete")
   public String delete(@RequestParam("board_info_idx") int board_info_idx,
		                @RequestParam("content_idx") int content_idx, Model model) {
	   
	   boardService.deleteContentInfo(content_idx);
	   //해당하는 게시글로 이동하여 삭제여부 확인
	   model.addAttribute("board_info_idx",board_info_idx);
	   
      return "board/delete";
   }
   
}