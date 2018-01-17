package com.hxuhao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class JWTFilter
 */
@WebFilter("/JWTFilter")
public class JWTFilter implements Filter {

    /**
     * Default constructor. 
     */
    public JWTFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Cookie[] cookies = req.getCookies();
		boolean isLogin = false;
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("JWT")){
				isLogin = true;
				break;
			}
		}
		
		// 未登录,将请求重定向至登录界面
		if(!isLogin){
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("login.jsp");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
