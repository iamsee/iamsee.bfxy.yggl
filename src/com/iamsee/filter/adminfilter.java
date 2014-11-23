package com.iamsee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class adminfilter implements Filter{

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
		
		String admin = (String)session.getAttribute("admin");
		System.out.println(admin);
		
		
		if(admin == null ||"".equals(admin))
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
