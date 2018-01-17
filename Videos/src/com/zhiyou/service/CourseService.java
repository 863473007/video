package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Course;


public interface CourseService {

	
	
	public List<Course> selectAll();
	
	public void updateOrInsert(Course course);
	
	public Course selectById(int id);
	
	public int delById(int id);

	public List<Course> selectBySubjectId(int subjectId) ;
}
