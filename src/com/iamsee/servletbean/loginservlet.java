package com.iamsee.servletbean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.iamsee.toolbean.*;
import com.iamsee.valuebean.*;

public class loginservlet extends HttpServlet {
	
	DB db = new DB();
	DBUser dbuser = new DBUser();
	DBAdmin dbadmin = new DBAdmin();
	MyTools mytools = new MyTools();
	User user = new User();
	Admin admin = new Admin();
	VoteSingle votesingle = new VoteSingle();
	/**
	 * Constructor of the object.
	 */
	public loginservlet() {
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
	String usertype = request.getParameter("usertype");
	System.out.println(usertype);
	
		
		System.out.println(name);
		System.out.println(pwd);
		
		admin.setName(name);
		admin.setPwd(pwd);
		
		boolean flag;
		flag = dbadmin.confirmadmin(admin);
		System.out.println(flag);
		if(flag)
		{
			System.out.println("登录成功");
			HttpSession session = request.getSession();
			session.setAttribute("admin", name);
			System.out.println(name);
			System.out.println(session.getAttribute("admin"));
			
			String infopage = "showmsg.jsp";
			session.setAttribute("infopage", infopage);
			//response.sendRedirect("dopageservlet");
			String rootname = name;
			session.setAttribute("rootname", name);
			System.out.println(rootname);
			response.sendRedirect("../admin/adminindex.jsp");
			
		}
		else
		{
			
			System.out.println("登录失败，检查用户名和密码");
			response.sendRedirect("../adminloginerr.jsp");
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
