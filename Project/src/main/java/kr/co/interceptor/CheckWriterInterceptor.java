package kr.co.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.beans.ContentBean;
import kr.co.beans.UserBean;
import kr.co.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	
	private UserBean loginUserBean;
	private BoardService boardService;
	
	public CheckWriterInterceptor(UserBean loginUserBean, BoardService boardService) {
		this.loginUserBean = loginUserBean;
		this.boardService = boardService;
	}

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		
//		String str1=request.getParameter("content_idx");
//		int content_idx=Integer.parseInt(str1);//형변환
//		
//		ContentBean currentContentBean =boardService.getContentInfo(content_idx);
//		
//		//작성한 사람의 글번호와 로그인한 사람의 글번호가 다르면
//		if(currentContentBean.getCode() != loginUserBean.getCode()) {
//			//경로를 읽어서
//			String contextPath=request.getContextPath();
//			//not_writer 호출
//			response.sendRedirect(contextPath+"/board/not_writer");
//			
//			return false;
//		}
//		
//		return true;
//	}
	
	

	
}