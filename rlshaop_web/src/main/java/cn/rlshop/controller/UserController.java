package cn.rlshop.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rlshop.model.User;
import cn.rlshop.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService ;
	
	/*
	 * 转向登录页面
	 */
	@RequestMapping("/toLogin")
	public String  tologin(){
		return "login";
	}

	
	/*
	 * 用户登录
	 */
	@RequestMapping("/login")
	public String  login(User user,Model model,HttpServletRequest request,HttpServletResponse response,String remember,String autologin){
		Cookie cookie = null;
		//首先先检测有没有记住用户名 设置cookie
		if("true".equals(remember)||"true"==remember){
			cookie = new Cookie("remember",user.getUserName());
			
			cookie.setMaxAge(Integer.MAX_VALUE);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
		}else{
			cookie = new Cookie("remember","");
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
		}
		
		//检测用户名，登陆
		User use = userService.findUserByUP(user);
		if(use!=null){
			//然后先检测有没有30天自动登录 设置cookie
			Cookie autocookie = null;
			if("true".equals(autologin)||"true"==autologin){
				autocookie = new Cookie("autologin",user.getUserName()+","+user.getPassWord());
				autocookie.setMaxAge(60*60*24*30);
				autocookie.setPath(request.getContextPath());
				response.addCookie(autocookie);
			}else{
				autocookie = new Cookie("autologin","");
				autocookie.setMaxAge(0);
				autocookie.setPath(request.getContextPath());
				response.addCookie(autocookie);
			}
			request.getSession().setAttribute("user", use);
			return "index";
		}
		else {
			model.addAttribute("error","用户名或密码错误");
			return "/login";
		}
	}
	
	
	

	/*
	 *转向用户注册
	 */
	@RequestMapping("/toRegist")
	public String toRegist(){
		return "regist";
	}
	
	
	/*
	 * 新增用户
	 */
	@RequestMapping("/saveUser")
	public String addUser(Model model ,User user,HttpServletRequest request){
		userService.addUser(user);
		return "login";	
	}
	
	/*
	 * 显示个人信息
	 */
	@RequestMapping("/toUserInfo")
	public String toUserInfo(HttpServletRequest request){
		//用户的数据直接从session中拿就够了，不用再去数据库里面去拿了
		return "userInfo";
	}
	
	/*
	 * 更新个人信息
	 */
	@RequestMapping("/updateUser")
	public String toUpdateUser(User user,Model model){
		userService.updateUser(user);
		model.addAttribute("flag", "true");
		return "login";
	}
	
	/*
	 * 用户登出
	 */
	@RequestMapping("/toLogOut")
	public String toLogOut(HttpServletRequest request,HttpServletResponse response){
		//清除cookie
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("autologin".equals(cookie.getName())||"autologin"==cookie.getName()&&(cookie.getValue()!=""||!"".equals(cookie.getValue()))){
				cookie.setValue("");
				cookie.setMaxAge(0);
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
		}
		//清除session
		if(request.getSession(false)!=null){
			request.getSession().invalidate();
		}
		return "redirect:/index";
	}
}
