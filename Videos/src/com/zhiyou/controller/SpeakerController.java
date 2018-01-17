package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.pojo.Speaker;
import com.zhiyou.service.SpeakerService;

@Controller
public class SpeakerController {

	@RequestMapping("/showSpeakerList.action")
	public String showVideoList(Model model,HttpSession session){
		
		List<Speaker> speakerList=speakerService.selectAll();
		model.addAttribute("username", session.getAttribute("username"));
		model.addAttribute("speakerList", speakerList);
		
		return "behind/speakerMgr";
	}
	
	@Autowired
	private SpeakerService speakerService;
	
	/*@RequestMapping("/speaker.action")
	public String speak(Model model,HttpSession session){
		List<Speaker> speakerList=speakerService.selectAll();
		model.addAttribute("username", session.getAttribute("username"));
		model.addAttribute("speakerList", speakerList);
		return "behind/speakerMgr";
	}*/
	@RequestMapping("/addspeaker.action")
	public String addspeaker(Model model,HttpSession session){
		model.addAttribute("username", session.getAttribute("username"));
		return "behind/addspeaker";
	}
	@RequestMapping("/saveSpeaker.action")
	public String saveSpeaker(Speaker speaker){
		speakerService.updateOrInsert(speaker);
		return "redirect:/showSpeakerList.action";
	}
	@RequestMapping("/speakerEdit.action")
	public String speakerEdit(int id,Model model,HttpSession session){
		Speaker speaker=speakerService.selectById(id);
		model.addAttribute("username", session.getAttribute("username"));
		model.addAttribute("speaker", speaker);
		return "behind/addspeaker";
	}
	@RequestMapping("/speakerDel.action")
	@ResponseBody
	public String speakerDel(int id){
		int result=speakerService.delById(id);
		if(result>0){
			return "success";
		}else{
			return "fail";
		}
	}
}
