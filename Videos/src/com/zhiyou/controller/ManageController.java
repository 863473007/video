package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.zhiyou.pojo.Manage;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.service.ManageService;
import com.zhiyou.service.SpeakerService;
@Controller
public class ManageController {
	@Autowired
	private SpeakerService speakerService; 
	
	@Autowired
	private ManageService manageService; 
	
	@RequestMapping("/showManageList.action")
	public String showManageList(Model model,HttpSession session){
		
		List<Manage> list = manageService.selectAll();

		model.addAttribute("selectManage", list);
		model.addAttribute("userName", session.getAttribute("userName"));
		return "behind/manage";
	}
	@RequestMapping("/addManage.action")
	public String addVManage(Model model) {

		
		
		List<Speaker> speakerList = speakerService.selectAll();
		model.addAttribute("speakerList", speakerList);
		
		return "behind/addManage";
	}
	
	
   
	@RequestMapping("/saveManage.action")
	public String saveManage(Manage manage) {

		manageService.saveOrUpdate(manage);
		
		return "redirect:/showManageList.action";
	}
	
	
	
	@RequestMapping("/ManageDel.action")
	@ResponseBody 
	public String deleteById(int id) {

		int result =manageService.delById(id);
		
		if(result>0){
			return "success";
		}else{
			return "fail";
		}
	}
	@RequestMapping("/delBatchManage.action")
	public String delBatchManageById(Integer[] ids){
		manageService.delBatchByIds(ids);
		return "redirect:/showManageList.action";
	}

	@RequestMapping("/ManageEdit.action")
	public String editManage(int id, Model model) {

		
		Manage manage = manageService.selectById(id);
		model.addAttribute("Manage", manage);
		
		List<Speaker> speakerList = speakerService.selectAll();
		model.addAttribute("speakerList", speakerList);
		
		return "behind/addManage";
	}


}
