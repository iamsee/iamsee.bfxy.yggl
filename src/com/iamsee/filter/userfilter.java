package com.iamsee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public  class userfilter  implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req= (HttpServletRequest)request;
		HttpServletResponse res =(HttpServletResponse)response;
		
		HttpSession session = req.getSession(true);
		
		String name = (String)session.getAttribute("name");
		String admin = (String)session.getAttribute("admin");
		
		
		if((name == null ||"".equals(name)))
		{
			res.sendRedirect("../index.jsp");
			
		}
		else
		{
			chain.doFilter(request, response);
		}
		
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
