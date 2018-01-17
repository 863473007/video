package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.CourseMapper;
import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.CourseExample;
import com.zhiyou.pojo.CourseExample.Criteria;
import com.zhiyou.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	
	@Autowired
	private CourseMapper courseMapper;
	
	public List<Course> selectAll(){
		
		return courseMapper.selectByExampleWithBLOBs(new CourseExample());
	}
	
	public void updateOrInsert(Course course){
		if(course.getId()!=null){
			courseMapper.updateByPrimaryKeyWithBLOBs(course);
		}else{
			courseMapper.insert(course);
		}
	}
	
	public Course selectById(int id){
		return courseMapper.selectByPrimaryKey(id);
	}
	
	public int delById(int id){
		return courseMapper.deleteByPrimaryKey(id);
	}

	public List<Course> selectBySubjectId(int subjectId) {
		
		
		CourseExample example= new CourseExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andSubjectIdEqualTo(subjectId);
		List<Course> courseList = courseMapper.selectByExampleWithBLOBs(example);
		
		return courseList;
	}
}
