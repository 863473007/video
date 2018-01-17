package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.pojo.User;
import com.zhiyou.pojo.UserExample;
import com.zhiyou.pojo.UserExample.Criteria;
import com.zhiyou.service.UserService;

/**
 * @author ����ΰ   
 * @version ����ʱ�䣺2017��6��20�� ����10:01:54
 * ��˵��
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	public String validateEmail(String email) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmailEqualTo(email);
		int count =userMapper.countByExample(example);
		if(count>0){
			return "fail";
		}
		return "success";
	}


	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}


	public int login(User user) {
		
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmailEqualTo(user.getEmail());
		createCriteria.andPasswordEqualTo(user.getPassword());
		return userMapper.countByExample(example);
	}


	public User selectUserByEmail(String email) {
		// TODO Auto-generated method stub
		
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmailEqualTo(email);
		List<User> list =userMapper.selectByExample(example);
		return list.get(0);
	}

    
	public void updateUserById(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}


	public String validateMd5Pass(String md5Pass,String account) {
		
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		
		createCriteria.andEmailEqualTo(account);
		createCriteria.andPasswordEqualTo(md5Pass);
		
		int count =userMapper.countByExample(example);
		
		
		return count>0 ?"success":"fail" ;
	}

 
	public void updateMd5Pass(String md5Pass, String account) {
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmailEqualTo(account);
		User user = new User();
		user.setPassword(md5Pass);
		userMapper.updateByExampleSelective(user, example);
	}


	public int countUserByEmail(String email) {
		
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmailEqualTo(email);
		return userMapper.countByExample(example);
	}


	public void saveCodeByEmail(String code, String email) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmailEqualTo(email);
		User user = new User();
		user.setCode(code);
		userMapper.updateByExampleSelective(user, example);
	}


	public int validateEmailCode(String code, String email) {
		
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmailEqualTo(email);
		createCriteria.andCodeEqualTo(code);
		
		return userMapper.countByExample(example);
	}


	public void updateImgUrlByEmail(String newName, String email) {
		
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmailEqualTo(email);
		User user = new User();
		user.setImgurl(newName);
		  userMapper.updateByExampleSelective(user, example);
	}
	
	

}
