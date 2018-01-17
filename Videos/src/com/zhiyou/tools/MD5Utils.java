package com.zhiyou.tools;

import org.springframework.util.DigestUtils;

public class MD5Utils {

	
	
	/*
	 * ��һ���ַ���MD5���ܣ���ʽ�ܶ࣬����ʹ�õ���Spring����
	 */
	public static String getMd5Simple(String password){
		
		
		String md502 =DigestUtils.md5DigestAsHex(password.getBytes());
	   
		return md502;
		
	}
	
	/*
	 * ��һ���ַ���MD5���ܣ���ʽ�ܶ࣬����ʹ�õ���Spring����
	 */
	public static String getMd5(String password){
		
		/*
		 * ԭ�������һ��
		 * ��ȡԭ������ܺ�ǰ8λ�ַ�
		 * 8λ�ַ�+���ܺ���ַ���    �ټ���һ��
		 */
		
		String md501= DigestUtils.md5DigestAsHex(password.getBytes());
		String temp =md501.substring(0, 8);
		String md502 =DigestUtils.md5DigestAsHex((temp+md501).getBytes());
	   
		return md502;
		
	}
}
