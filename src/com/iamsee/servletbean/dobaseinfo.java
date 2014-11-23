package com.iamsee.servletbean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iamsee.toolbean.DBbaseinfo;
import com.iamsee.valuebean.baseinfo;

public class dobaseinfo extends HttpServlet {

	DBbaseinfo dbb = new DBbaseinfo();
	/**
	 * Constructor of the object.
	 */
	public dobaseinfo() {
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

		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		String id = request.getParameter("baseinfoid");
		
		String name = request.getParameter("name");
		String shortname = request.getParameter("shortname");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String hometowndes = request.getParameter("hometowndes");
		String idcard = request.getParameter("idcard");
		String worktime = request.getParameter("worktime");
		String postname = request.getParameter("postname");
		
		if(type.equals("toupdate"))
		{
			
			baseinfo bi = dbb.getbaseinfo(id);
			session.setAttribute("bi", bi);
			response.sendRedirect("../admin/updatebaseinfo.jsp");
			
		}
		else if(type.equals("toinsert"))
		{
			response.sendRedirect("../admin/insertbaseinfo.jsp");
		}
		else if(type.equals("del"))
		{
			String delmsg = "没有删除返回信息";
			int i = dbb.delbaseinfo(id);
			if(i>0)
			{
				delmsg = "删除成功";
			}
			else
			{
				delmsg = "删除失败";
			}
			
			request.setAttribute("delmsg",delmsg);
			request.getRequestDispatcher("dopageservlet").forward(request,response);
			
		}
		else if(type.equals("update"))
		{
			baseinfo bi = new baseinfo();
			int intid = Integer.parseInt(id);
			bi.setId(intid);
			bi.setName(name);
			bi.setShortname(shortname);
			bi.setSex(sex);
			bi.setBirth(birth);
			bi.setHometowndes(hometowndes);
			bi.setIdcard(idcard);
			bi.setWorktime(worktime);
			bi.setPostname(postname);
			
			int i = dbb.updatebaseinfo(bi);
			String updatemsg = "没有更新返回信息";
			if(i>0)
			{
				 updatemsg = "更新成功";
				
				
			}
			else
			{
				updatemsg = "更新失败";
			}
			request.setAttribute("updatemsg",updatemsg);
			request.getRequestDispatcher("dopageservlet").forward(request,response);
			
			
		}
		else if(type.equals("insert"))
		{
			baseinfo bi = new baseinfo();
			
			
			bi.setName(name);
			bi.setShortname(shortname);
			bi.setSex(sex);
			bi.setBirth(birth);
			bi.setHometowndes(hometowndes);
			bi.setIdcard(idcard);
			bi.setWorktime(worktime);
			bi.setPostname(postname);
			
			int i = dbb.insertbaseinfo(bi);
			String insertmsg = "没有插入返回信息";
			if(i>0)
			{
				insertmsg = "提交成功";
				
				
			}
			else
			{
				insertmsg = "提交失败";
			}
			request.setAttribute("insertmsg",insertmsg);
			request.getRequestDispatcher("dopageservlet").forward(request,response);
			
			
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
