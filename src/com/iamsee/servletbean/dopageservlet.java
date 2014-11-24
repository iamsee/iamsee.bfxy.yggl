package com.iamsee.servletbean;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iamsee.toolbean.DBbaseinfo;
import com.iamsee.toolbean.DBpostname;
import com.iamsee.valuebean.baseinfo;
import com.iamsee.valuebean.postname;

public class dopageservlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public dopageservlet() {
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
		int pageSize = 10; //分页大小
		
		String selectname = request.getParameter("selectname");
		String selectpart = request.getParameter("condition");
		
		
		if(selectname == null || selectname.equals(""))
		{
			selectname="%";
		}
		else
		{
			selectname="%"+selectname+"%";
		}
		if(selectpart == null || selectpart.equals("缺省"))
		{
			selectpart="%";
		}
		else
		{
			selectpart="%"+selectpart+"%";
		}
		String sql = "select * from t_baseinfo where name like '"+selectname+"' and postname like '"+selectpart+"'";
		//String sql = "select * from t_baseinfo where name like '%' and postname like '%学报编辑部%'";
		DBbaseinfo dbb = new DBbaseinfo();
		
		ArrayList totallist = dbb.GetTotalList(sql);
		System.out.println(totallist.size());
		DBpostname dbp = new DBpostname();
		ArrayList<postname> postnamelist  = dbp.GetPostnameList();
		int totalPosts =totallist.size(); //总文章数
		int totalPages = totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0); //计算得出的总页数
		
		String pageNumberStr = request.getParameter("pageNumber");
		int pageNumber = 1;
		if(pageNumberStr!=null && !pageNumberStr.isEmpty())
		{
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		
		ArrayList nowlist = new ArrayList();
		
		nowlist = dbb.Getnowlist(totallist, pageNumber, pageSize);
		System.out.println(nowlist.size());
		baseinfo bi = new baseinfo();
		bi = (baseinfo) nowlist.get(0);
		System.out.println(bi.getName());
		session.setAttribute("pageSize", pageSize);
		session.setAttribute("totalPosts", totalPosts);
		session.setAttribute("pageNumber", pageNumber);
		session.setAttribute("totalPages", totalPages);
		session.setAttribute("postnamelist", postnamelist);
		session.setAttribute("totallist", totallist);
		System.out.println(postnamelist.size());
		System.out.println("nowlist:"+nowlist.size());
		session.setAttribute("nowlist", nowlist);
		String insertmsg = (String)request.getAttribute("insertmsg");
		String updatemsg = (String)request.getAttribute("updatemsg");
		String delmsg = (String)request.getAttribute("delmsg");
		if(insertmsg == null)
		{
			insertmsg="";
		}
		if(updatemsg == null)
		{
			updatemsg="";
		}
		if(delmsg == null)
		{
			delmsg="";
		}
		System.out.println(insertmsg);
		System.out.println(updatemsg);
		System.out.println(delmsg);
		session.setAttribute("insertmsg", insertmsg);
		session.setAttribute("updatemsg", updatemsg);
		session.setAttribute("delmsg", delmsg);
		String downstate = "false";
		session.setAttribute("downstate", downstate);
		
		
		response.sendRedirect("../admin/showinfo.jsp");
		//request.getRequestDispatcher("../admin/showinfo.jsp").forward(request, response);		
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
