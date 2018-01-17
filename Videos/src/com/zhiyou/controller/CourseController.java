package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Subject;
import com.zhiyou.pojo.Video;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SubjectService;
import com.zhiyou.service.VideoService;
import com.zhiyou.tools.CommonTools;

@Controller
//@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("/course.action")
	public String showCourseIndex(int subjectId,Model model){
		
		
		Subject subject = subjectService.selectSubjectByPrimaryKey(subjectId);
		
		List<Course> courseList = courseService.selectBySubjectId(subjectId);
		
		for (Course course : courseList) {
			int courseId= course.getId();
			List<Video> videoList = videoService.selectVideoByCourseId(courseId);
			for(Video video:videoList){
				
				video.setShowTime(CommonTools.getShowTime(video.getTime()));
				
			}
		    course.setVideoList(videoList);
		}
		
		subject.setCourseList(courseList);
		model.addAttribute("subject", subject);
		return "before/course";
	}

	@RequestMapping("/showCourseList.action")
	public String showVideoList(Model model,HttpSession session){
		
		List<Course> courseList=courseService.selectAll();
		model.addAttribute("username", session.getAttribute("username"));
		model.addAttribute("courseList", courseList);
		
		return "behind/courseMgr";
	}
	
	
	
	
	
	@RequestMapping("/addcourse.action")
	public String addcourse(Model model,HttpSession session){
		
		List<Subject> subjectList = subjectService.selectAll();
		
		model.addAttribute("subjectList",subjectList);
		model.addAttribute("username", session.getAttribute("username"));
		return "behind/addcourse";
	}
	
	@RequestMapping("/saveCourse.action")
	public String addcourses(Course course){
		
		courseService.updateOrInsert(course);
		
		return "redirect:/showCourseList.action";
	}
	
	@RequestMapping("/courseEdit.action")
	public String editcourse(int id,Model model,HttpSession session){
		
		Course course= courseService.selectById(id);
		model.addAttribute("username", session.getAttribute("username"));
		model.addAttribute("course",course);
		return "behind/addcourse";
	}
	
	@RequestMapping("/courseDel.action")
	@ResponseBody
	public String delcourse(int id){
		int result=courseService.delById(id);
		if(result>0){
			return "success";
		}else{
			return "fail";
		}
	}
}
