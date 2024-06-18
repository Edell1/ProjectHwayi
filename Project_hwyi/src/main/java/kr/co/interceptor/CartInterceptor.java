package kr.co.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.beans.CartBean;
import kr.co.beans.UserBean;
import kr.co.service.CartService;

@Component
public class CartInterceptor implements HandlerInterceptor {

	private UserBean loginMemberBean;
	private CartService cartService;

	@Autowired
	public CartInterceptor(UserBean loginMemberBean, CartService cartService) {
		this.loginMemberBean = loginMemberBean;
		this.cartService = cartService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	throws Exception {
		
		if(loginMemberBean.isUserLogin() == false) {
			String contextPath = request.getContextPath();
			
			response.sendRedirect(contextPath+"/member/not_login");
			
			return false;
		}
		
		
		String code = loginMemberBean.getCode();
	    List<CartBean> cartItems = cartService.getCartBycode(code);
	    request.setAttribute("cartItems", cartItems); 
	    
	    return true;
	}
	
	
	
}