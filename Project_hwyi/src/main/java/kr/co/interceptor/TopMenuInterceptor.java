package kr.co.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.beans.BoardInfoBean;
import kr.co.service.TopMenuService;


public class TopMenuInterceptor implements HandlerInterceptor{
	
	//@Autowired : Interceptor처리된 클래스에서는 오토와이어드를 사용할 수 없음
	private TopMenuService topMenuService;
	//DI
	public TopMenuInterceptor(TopMenuService topMenuService) {
		this.topMenuService=topMenuService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<BoardInfoBean> topMenuList=topMenuService.getTopMenuList(); //4개 게시판
		request.setAttribute("topMenuList", topMenuList);
		return true;
	}
	
	

}
