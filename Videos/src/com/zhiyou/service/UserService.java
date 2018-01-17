package com.zhiyou.service;

import com.zhiyou.pojo.User;

/**
 * @author ����ΰ   
 * @version ����ʱ�䣺2017��6��20�� ����10:00:35
 * ��˵��
 */
public interface UserService {

	public String validateEmail(String email);

	public int insertUser(User user);

	public int login(User user);

	public User selectUserByEmail(String email);

	public void updateUserById(User user);

	public String validateMd5Pass(String md5Pass,String account);

	public void updateMd5Pass(String md5Pass, String account);

	public int countUserByEmail(String email);

	public void saveCodeByEmail(String code, String email);

	public int validateEmailCode(String code, String email);

	public void updateImgUrlByEmail(String newName, String email);
}
