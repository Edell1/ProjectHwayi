package kr.co.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.beans.ContentBean;
import kr.co.beans.PageBean;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/customer_center")
public class CustomerCenterController {
	
	@Autowired
	   private BoardService boardService;
	
	@GetMapping("/customer_center_main")
	public String customer_center_main() {
		return "customer_center/customer_center_main";
	}
	
	@GetMapping("/main")
	public String main(/*
						 * @RequestParam("board_info_idx") int board_info_idx,
						 * 
						 * @RequestParam(value="page", defaultValue="1")int page, Model model
						 */) {
		
		/*
		 * model.addAttribute("board_info_idx", board_info_idx);
		 * 
		 * String boardInfoName=boardService.getBoardInfoName(board_info_idx);
		 * model.addAttribute("boardInfoName", boardInfoName);
		 * 
		 * List<ContentBean> contentList=boardService.getContentList(board_info_idx,
		 * page); model.addAttribute("contentList", contentList);
		 * 
		 * PageBean pageBean=boardService.getContentCnt(board_info_idx, page);
		 * 
		 * model.addAttribute("pageBean",pageBean); model.addAttribute("page", page);
		 */
		
		return "customer_center/main";
	}

}
