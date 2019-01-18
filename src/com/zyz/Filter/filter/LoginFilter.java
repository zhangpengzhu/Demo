package com.zyz.Filter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *登录验证的filter
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("1");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("1");
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		Object obj = request.getSession().getAttribute("USER_IN_SESSION");
		if(obj==null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
	System.out.println("login1");
		chain.doFilter(request, response);
		System.out.println("login1");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("1");
	}

}
