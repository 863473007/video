package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.AdminMapper;
import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.AdminExample;
import com.zhiyou.pojo.AdminExample.Criteria;
import com.zhiyou.service.LoginService;
import com.zhiyou.tools.MD5Utils;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private AdminMapper adminMapper;
	
	public List<Admin> login(String username,String password){
		AdminExample example = new AdminExample();
		//加入添加使用的对象   Criteria 标准条件
		Criteria  criteria =example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(MD5Utils.getMd5Simple(password));
		
		List<Admin> list =adminMapper.selectByExample(example);
		
		return list;
	}
}
