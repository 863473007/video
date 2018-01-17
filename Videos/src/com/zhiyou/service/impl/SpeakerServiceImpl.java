package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.SpeakerMapper;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.pojo.SpeakerExample;
import com.zhiyou.service.SpeakerService;

@Service
public class SpeakerServiceImpl implements SpeakerService{

	
	@Autowired
	private SpeakerMapper speakerMapper;
	
	public List<Speaker> selectAll(){
		
		return speakerMapper.selectByExampleWithBLOBs(new SpeakerExample());
	}
	
	public void updateOrInsert(Speaker speaker){
		if(speaker.getId()!=null){
			speakerMapper.updateByPrimaryKeyWithBLOBs(speaker);
		}else{
			speakerMapper.insert(speaker);
		}
	}
	
	public Speaker selectById(int id){
		return speakerMapper.selectByPrimaryKey(id);
	}
	
	public int delById(int id){
		return speakerMapper.deleteByPrimaryKey(id);
	}
}
