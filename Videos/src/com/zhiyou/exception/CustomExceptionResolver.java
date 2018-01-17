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
		
		//异常分为两类
		// 预处理的异常：你写代码的时候知道某个地方会报异常，这个异常可以自定义
		// 运行时异常：程序在运行过程中，不知道在某个地方会报异常
		/*
		 * 输入输入流  
		 * 将错误信息输入到Writer  ,从Writer获取字符串
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
