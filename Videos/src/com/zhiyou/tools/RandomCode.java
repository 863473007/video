package com.zhiyou.tools;
/**
 * @author 闫振伟   
 * @version 创建时间：2017年6月22日 上午11:50:17
 * 类说明
 */
public class RandomCode {

	public static String getRandomCode(int length){
		
		int[] arr={0,1,2,3,4,5,6,7,8,9};
		String code="";
		
		for(int i=0;i<=length-1;i++){
			int random=(int) (Math.random()*10);
			code+=arr[random];
		}
		return code;
	}
	
	
}
