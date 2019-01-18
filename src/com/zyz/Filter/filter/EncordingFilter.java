package com.zyz.Filter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 编码格式的filter
 * @author Administrator
 *
 */
public class EncordingFilter implements Filter {
String encoding;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		System.out.println(encoding);
		System.out.println("encoding");
		chain.doFilter(request, response);
		System.out.println("encoding");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 encoding = filterConfig.getInitParameter("encoding");
	}

}
