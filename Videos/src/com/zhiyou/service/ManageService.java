package com.zhiyou.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.ManageMapper;
import com.zhiyou.mapper.SpeakerMapper;
import com.zhiyou.pojo.Manage;
import com.zhiyou.pojo.ManageExample;
import com.zhiyou.pojo.ManageExample.Criteria;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.pojo.SpeakerExample;

@Service
public class ManageService {
	
	@Autowired
	private ManageMapper manageMapper;
	
	public List<Manage> selectAll(){
		
		return manageMapper.selectByExample(new ManageExample());
	}
   public void saveOrUpdate(Manage manage){
		
		if(null!=manage.getId() && manage.getId()!=0){
			manageMapper.updateByPrimaryKey(manage);
		}else{
			manageMapper.insert(manage);
		}
	}
   public int delBatchByIds(Integer[] ids){
		ManageExample example=new ManageExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdIn(Arrays.asList(ids));
		return manageMapper.deleteByExample(example);
	} 
	
	public int delById(int id){
		return manageMapper.deleteByPrimaryKey(id);
	}
	
	public Manage selectById(int id){
		
		return manageMapper.selectByPrimaryKey(id);
	}
	

}
