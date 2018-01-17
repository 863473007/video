package com.zhiyou.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {

	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception e) {
		
		//�쳣��Ϊ����
		// Ԥ������쳣����д�����ʱ��֪��ĳ���ط��ᱨ�쳣������쳣�����Զ���
		// ����ʱ�쳣�����������й����У���֪����ĳ���ط��ᱨ�쳣
		/*
		 * ����������  
		 * ��������Ϣ���뵽Writer  ,��Writer��ȡ�ַ���
		 */
		String message="";
		if(e instanceof MyException){
			message= e.getMessage();
		}else{
			Writer out = new StringWriter();
			PrintWriter s = new PrintWriter(out);
			e.printStackTrace(s);
			message =out.toString();
		}
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("message",message);
		modelAndView.setViewName("error/error");
		
		return modelAndView;
	}

}
