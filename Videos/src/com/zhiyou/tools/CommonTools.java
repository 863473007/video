package com.zhiyou.tools;
/**
 * @author ����ΰ   
 * @version ����ʱ�䣺2017��6��26�� ����11:19:51
 * ��˵��
 */
public class CommonTools {

	
	public static String getShowTime(int value){
		
		String showTime="";
		        int hours = (int) Math.floor(value / 3600);
		        showTime =  (String) (hours > 10 ? hours : "0" + hours)+":";
	            int minute = (int) Math.floor(value / 60);
	            showTime += (minute >= 60 ? minute % 60 > 10 ? minute % 60 : "0" + minute % 60 : minute < 10 ? "0" + minute : minute)+":";
	            int seconds = value % 60;
	            showTime += seconds > 10 ? seconds : "0" + seconds;
	            return showTime;
	}
}
