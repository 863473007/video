package com.zhiyou.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.QueryVideoVo;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.pojo.Video;
import com.zhiyou.pojo.VideoSpeaker;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SpeakerService;
import com.zhiyou.service.VideoService;
import com.zhiyou.tools.CommonTools;
import com.zhiyou.tools.Page;

@Controller
@RequestMapping("video")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@Autowired
	private SpeakerService speakerService;

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/updatePalyNum.action")
	@ResponseBody
	public void updatePalyNum(int videoId,int playNum){
		
		Video video = new Video();
		video.setId(videoId);
		video.setPlayNum(playNum+1);
		videoService.updateVideoByPrimaryKey(video);
		
	}
	
	@RequestMapping("/showVideo.action")
	public String showVideo(int videoId,String subjectName,Model model,HttpSession session){
		
		
		if(null==session.getAttribute("userAccount") || "".equals(session.getAttribute("userAccount"))){
			
			return "redirect:/index.jsp";
		}
		
		Video video= videoService.selectById(videoId);
		model.addAttribute("video", video);
		
		
		Speaker speaker = speakerService.selectById(video.getSpearkerId());
		model.addAttribute("speaker", speaker);
		
		Course course =courseService.selectById(video.getCourseId());
		model.addAttribute("course", course);
		List<Video> videoList = videoService.selectVideoByCourseId(video.getCourseId());
		for (Video video2 : videoList) {
			video2.setShowTime(CommonTools.getShowTime(video2.getTime()));
		}
		
		model.addAttribute("videoList", videoList);
		model.addAttribute("subjectName", subjectName);
		return "before/section";
	}

	@RequestMapping("/videoList.action")
	public String videoList(QueryVideoVo video, Model model, HttpSession session) {

		int start = (video.getPage()-1)*video.getRows(); 
		video.setStart(start);
		List<VideoSpeaker> list = videoService.selectVideoByQueryVo(video);	//model.addAttribute("list", list);
		model.addAttribute("userName", session.getAttribute("userName"));
		Page<VideoSpeaker> page = new Page<VideoSpeaker>();
		page.setPage(video.getPage()); 
		page.setRows(list); 
		page.setSize(video.getRows()); 		
		page.setTotal(videoService.countVideoByQueryVo(video));
		model.addAttribute("page",page);
		List<Speaker> speakerList = speakerService.selectAll();
		model.addAttribute("speakerList", speakerList);
		List<Course> courseList = courseService.selectAll();
		model.addAttribute("courseList", courseList);
		return "behind/videoList";
	}

	@RequestMapping("/addVideo.action")
	public String addVideo(Model model) {

	

		List<Speaker> speakerList = speakerService.selectAll();
		model.addAttribute("speakerList", speakerList);
		
		List<Course> courseList = courseService.selectAll();
		model.addAttribute("courseList", courseList);
		return "behind/addVideo";
	}

	
	@RequestMapping("/saveVideo.action")
	public String saveVideo(Video video) {

		videoService.saveOrUpdate(video);

		return "redirect:/video/videoList.action";
	}

	@RequestMapping("/videoDel.action")
	@ResponseBody
	
	public String deleteById(int id) {

		int result = videoService.delById(id);

		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping("/delBatchVideos.action")
	public String delBatchVideoByIds(Integer[] ids) {
		System.out.println("看看" + Arrays.toString(ids));
		videoService.delBatchByIds(ids);
		return "redirect:/video/videoList.action";
	}

	@RequestMapping("/videoEdit.action")
	public String editVideo(int id, Model model) {

		Video video = videoService.selectById(id);
		model.addAttribute("video", video);
		// ��ѯ������ʦ
		List<Speaker> speakerList = speakerService.selectAll();

		model.addAttribute("speakerList", speakerList);
		// ��ѯ���пγ�

		List<Course> courseList = courseService.selectAll();

		model.addAttribute("courseList", courseList);
		return "behind/addVideo";
	}

}
