package cn.rlshop.intercetor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.rlshop.model.User;

/**
 * 拦截器    未登录 查看订单  添加订单  要先去登录界面
 * @author 
 *
 */
public class OrderInterceptor implements HandlerInterceptor{
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			response.sendRedirect("/toLogin");
			return false;
		}
		
		return true;
	}

	
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
