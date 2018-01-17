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
		
		//�жϵ�ǰ�û��Ƿ��¼
		//�����ȡsession 
		HttpSession session =request.getSession();
		//�����ָ���쳣
		//video.getId()!=0
		if(null!=session.getAttribute("userName")){
			return true;
		}else{
			//��ת����¼����  �ض������˼����ģ��  ����urlд��admin.action �ûس�
			//http://localhost:8080/Videos/admin.action
			response.sendRedirect(request.getContextPath()+"/admin.action");
			
		}
		return false;
	}

}
