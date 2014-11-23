package com.iamsee.servletbean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iamsee.toolbean.DB;
import com.iamsee.toolbean.DBAdmin;
import com.iamsee.toolbean.DBVote;
import com.iamsee.valuebean.Admin;
import com.iamsee.valuebean.VoteSingle;

public class addvoteservlet extends HttpServlet {

	DB db = new DB();
	DBAdmin dbadmin = new DBAdmin();
	Admin admin = new Admin();
	VoteSingle votesingle = new VoteSingle();
	DBVote dbvote = new DBVote();
	/**
	 * Constructor of the object.
	 */
	public addvoteservlet() {
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

		String addvotevalue = request.getParameter("addvotevalue");
		System.out.println(addvotevalue);
		
		String beselected = addvotevalue;
		String votenum = "0";
		votesingle.setBeselected(beselected);
		votesingle.setVotenum(votenum);
		
		
		boolean bl = false;
		bl = dbvote.addvote(votesingle);
		if(bl)
		{
			System.out.println("新增投票项成功");
			response.sendRedirect("adminshowvoteservlet");
		}
		else
		{
			System.out.println("新增投票项失败");
			response.sendRedirect("adminshowvoteservlet");
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
