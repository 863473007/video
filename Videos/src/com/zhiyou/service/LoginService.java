package com.zhiyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhiyou.mapper.AdminMapper;
import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.AdminExample;
import com.zhiyou.pojo.AdminExample.Criteria;
import com.zhiyou.tools.MD5Utils;


public interface LoginService{

	
	public List<Admin> login(String username,String password);
}
