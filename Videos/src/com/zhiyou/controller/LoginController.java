package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.exception.MyException;
import com.zhiyou.pojo.Admin;
import com.zhiyou.service.LoginService;

@Controller
//@RequestMapping("admin")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/admin.action")
	public String showAdmin(){
		
		return "behind/login";
	}
	
	@RequestMapping("/exit.action")
	public String exit(HttpSession session){
		
		session.removeAttribute("userName");
		return "behind/login";
	}
	
	@RequestMapping("/login.action")
	public String login(String username,String password,HttpSession session) throws Exception {
		
		//int a =10/0;
		/*boolean temp =true;
		if(temp){
			throw new MyException("��¼ʱ�����쳣����鿴��¼����");
		}*/
		
		List<Admin> list = loginService.login(username, password);
		if(list.size()>0){
			
			
			session.setAttribute("userName", list.get(0).getUsername());
		
			return "redirect:/video/videoList.action";
			
		}
		
		
		return "behind/login";
	}

}
