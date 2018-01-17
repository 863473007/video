package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Speaker;


public interface SpeakerService {

	
	
	
	public List<Speaker> selectAll();
	
	public void updateOrInsert(Speaker speaker);
	
	public Speaker selectById(int id);
	
	public int delById(int id);
}
