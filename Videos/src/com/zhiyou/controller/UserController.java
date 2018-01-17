package com.zhiyou.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.pojo.User;
import com.zhiyou.service.UserService;
import com.zhiyou.tools.ImageCut;
import com.zhiyou.tools.JavaEmailSender;
import com.zhiyou.tools.MD5Utils;
import com.zhiyou.tools.RandomCode;


@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Value("${HEAD_IMG}")
	public String HEAD_IMG;
	@Value("${IMG_SEARVER_URL}")
	public String IMG_SEARVER_URL;
	
	@RequestMapping("/validateEmail.action")
	@ResponseBody
	public String validateEmail(String email){
		
		System.out.println("validateEmail:"+email);
		return userService.validateEmail(email);
		
	}
	
	@RequestMapping("/insertUser.action")
	@ResponseBody
	public String insertUser(User user,HttpSession session){
		
		
		user.setPassword(MD5Utils.getMd5(user.getPassword()));
		
		int result =userService.insertUser(user);
		if(result>0){
			session.setAttribute("userAccount", user.getEmail());
			return "success";
		}
		return "fail";
		
		
	}
	
	@RequestMapping("/loginUser.action")
	@ResponseBody
	public String login(User user,HttpSession session){
		System.out.println("==========");
		
		
		user.setPassword(MD5Utils.getMd5(user.getPassword()));
		
		int count =userService.login(user);
		if(count>0){
			session.setAttribute("userAccount", user.getEmail());
			return "success";
		}
		return "fail";
	}
	
	
	@RequestMapping("/loginOut.action")
	@ResponseBody
	public void loginOut(HttpSession session){
		
			session.removeAttribute("userAccount");
			
	}
	
	@RequestMapping("/loginOut2.action")
	public String loginOut2(HttpSession session){
		
			session.removeAttribute("userAccount");
		  return "redirect:/index.jsp";	
			
	}
	
	@RequestMapping("/showMyProfile.action")
	public String showMyProfile(HttpSession session,Model model){
		
		String email =  (String) session.getAttribute("userAccount");
		User user =userService.selectUserByEmail(email);
		model.addAttribute("user", user);
		return "before/my_profile";	
	}
	
	@RequestMapping("/changeProfile.action")
	public String changeProfile(HttpSession session,Model model){
		
		String email =  (String) session.getAttribute("userAccount");
		User user =userService.selectUserByEmail(email);
		model.addAttribute("user", user);
		return "before/change_profile";	
	}
	
	
	@RequestMapping("/updateUser.action")
	public String updateUser(User user,Model model){
		
		userService.updateUserById(user);
		
		return "redirect:/showMyProfile.action";	
	}
	
	@RequestMapping("/passwordSafe.action")
	public String passwordSafe(HttpSession session,Model model){
		
		String email =  (String) session.getAttribute("userAccount");
		User user =userService.selectUserByEmail(email);
		model.addAttribute("user", user);
		return "before/password_safe";	
		
	}
	
	
	@RequestMapping("validatePassword.action")
	@ResponseBody
	public String vaildatePassword(String password,HttpSession session){
		
		String account =  (String) session.getAttribute("userAccount");
		String md5Pass= MD5Utils.getMd5(password);
		
		return userService.validateMd5Pass(md5Pass,account);
	}

	@RequestMapping("updatePassword.action")
	public String updatePassword(String newPassword,HttpSession session){
		
		String account =  (String) session.getAttribute("userAccount");
		String md5Pass= MD5Utils.getMd5(newPassword);
		
		userService.updateMd5Pass(md5Pass,account);
		return "redirect:/showMyProfile.action";	
		
	}
	
	@RequestMapping("forgetPassword.action")
	public String forgetPassword(){
		
		return "before/forget_password";	
		
	}
	
	

	@RequestMapping("sendEmail.action")
	@ResponseBody
	public String sendEmail(String email) throws Exception{
		
		
		int result =userService.countUserByEmail(email);
		if(result>0){
			
			String code =RandomCode.getRandomCode(6);
			JavaEmailSender.sendEmail(email, "验证码",code );
			
			userService.saveCodeByEmail(code,email);
			return "success";
		}else{
			return "notExist";
		}
		
		
	}
	
	
	@RequestMapping("validateEmailCode.action")
	public String validateEmailCode(String email,String code,Model model) throws Exception{
		
		//ͨ���˺Ż�ȡ���
		int result =userService.validateEmailCode(code,email);
		if(result>0){
			model.addAttribute("email", email);
			return "before/reset_password";
		}else{
			return "before/forget_password";
		}
		
		
	}
	
	@RequestMapping("resetPassword.action")
	public String resetPassword(String email,String password) throws Exception{
		
		//ͨ���˺Ż�ȡ���
		String md5Pass= MD5Utils.getMd5(password);
		userService.updateMd5Pass(md5Pass, email);
		return "redirect:/index.jsp";
		
		
	}
	
	
	
	@RequestMapping("changeAvatar.action")
	public String changeAvatar(HttpSession session,Model model) throws Exception{
		
		String email =  (String) session.getAttribute("userAccount");
		User user =userService.selectUserByEmail(email);
		model.addAttribute("user", user);
		return "before/change_avatar";
		
		
	}
	
	@RequestMapping("upLoadImage.action")
	public String upLoadImage(HttpServletRequest request,MultipartFile image_file,HttpSession session,Model model) throws Exception{
		
		System.out.println("x1:"+request.getParameter("x1"));
		System.out.println("y1:"+request.getParameter("y1"));
		System.out.println("x2:"+request.getParameter("x2"));
		System.out.println("y2:"+request.getParameter("y2"));
		float x1 = 0,x2=0,y1=0,y2=0,width=0;
		boolean isCut =false;
		if(null!=request.getParameter("x1")&&!"".equals(request.getParameter("x1"))){
			x1= Float.parseFloat(request.getParameter("x1"));
			y1= Float.parseFloat(request.getParameter("y1"));
			x2= Float.parseFloat(request.getParameter("x2"));
			y2= Float.parseFloat(request.getParameter("y2"));
			width= x2-x1;
			isCut=true;
		}
		
		
		
		String oldName=image_file.getOriginalFilename();
		String suffix= oldName.substring(oldName.lastIndexOf("."));
		System.out.println(suffix);
		
		String uuid= UUID.randomUUID().toString();
		String newName=uuid+suffix;
		
		image_file.transferTo(new File(HEAD_IMG+newName));
		
		if(isCut){
			ImageCut imageCut = new ImageCut();  
		    imageCut.cutImage(HEAD_IMG+newName, (int)x1, (int)y1, (int)width, (int)width);
		}
		
		
		String email =  (String) session.getAttribute("userAccount");
		userService.updateImgUrlByEmail(IMG_SEARVER_URL+newName,email);
		User user = new User();
		user.setImgurl(IMG_SEARVER_URL+newName);
		model.addAttribute("user", user);
		return "before/change_avatar";
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
