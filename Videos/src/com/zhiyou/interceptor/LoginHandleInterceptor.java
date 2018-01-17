package com.zhiyou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandleInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		//判断当前用户是否登录
		//如果获取session 
		HttpSession session =request.getSession();
		//避免空指针异常
		//video.getId()!=0
		if(null!=session.getAttribute("userName")){
			return true;
		}else{
			//跳转到登录界面  重定向的意思就是模拟  你在url写了admin.action 敲回车
			//http://localhost:8080/Videos/admin.action
			response.sendRedirect(request.getContextPath()+"/admin.action");
			
		}
		return false;
	}

}
