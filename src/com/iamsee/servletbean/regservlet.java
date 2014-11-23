package com.iamsee.servletbean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iamsee.toolbean.*;
import com.iamsee.valuebean.*;

public class regservlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	DB db = new DB();
	DBUser dbuser = new DBUser();
	MyTools mytools = new MyTools();
	User user = new User();
	VoteSingle votesingle = new VoteSingle();
	
	public regservlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		user.setName(name);
		user.setPwd(pwd);
		
		boolean flag;
		flag = dbuser.adduser(user);
		if(flag)
		{

    		response.sendRedirect("../RegisterSuccess.jsp");
		}
		else
		{
			System.out.println("<h1>注册失败,转入主页</h1>");
			response.sendRedirect("../RegisterError.jsp");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
