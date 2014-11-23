package com.iamsee.toolbean;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iamsee.valuebean.*;

public class DB {
	private String className;

	private String url;

	private String username;

	private String password;

	private Connection con;

	public Statement stm;

	public ResultSet rs;

	public DB() {
//		className = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
//		url = "jdbc:microsoft:sqlserver://192.168.31.118:1433;databaseName=vote_ms";
//		username = "sa";
//		password = "sasa";
		className = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://blog.iamsee.com:3306/iamsee.bfxy.yggl?characterEncoding=utf-8";
		username = "root";
		password = "zhuotong";
	}

	/**
	 * 加载数据库驱动程序
	 */

	public static void main(String args[]) {
		DB db = new DB();
		db.loadDrive();
		db.getCon();
		db.getStm();
		
		db.getRs("select * from tb_vote");
		if(db.rs == null)
		{
			System.out.println("rs为空");
		}
		else {
			
			System.out.println("rs不为空");
		}
		try {
			while(db.rs.next())
			{
				 System.out.println("执行结果如下所示:");
					
				
				 while(db.rs.next()) {
				
				
				 System.out.print(db.rs.getInt(1));
				
				 System.out.print(db.rs.getString(2));
				 System.out.println(db.rs.getInt(3)+" ");
			}
			}
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("有错误");
		}

		db.closed();

	}

	public void loadDrive() {
		try {
			Class.forName(className);
			System.out.println("加载数据库驱动成功");
		} catch (ClassNotFoundException e) {
			System.out.println("加载数据库驱动程序失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 连接数据库
	 */
	public void getCon() {
		loadDrive();
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("连接数据库成功");
		} catch (Exception e) {
			System.out.println("连接数据库失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 获取Statement
	 */
	public void getStm() {
		getCon();
		try {
			stm = con.createStatement();
			System.out.println("获取Statement对象成功");
		} catch (Exception e) {
			System.out.println("获取Statement对象失败！");
			e.printStackTrace();
		}
	}

	/**
	 * @功能 查询数据表，获取结果集
	 */
	public void getRs(String sql) {
		getStm();

		try {
			rs = stm.executeQuery(sql);
			System.out.println("查询数据库成功");
			/*
			 * 测试查询
			 */
//			 System.out.println("执行结果如下所示:");
//			
//			 String name = null;
//			 while(rs.next()) {
//			 name = rs.getString("beselected");
//			 name = new String(name.getBytes("ISO-8859-1"),"GB2312");
//			
//			 System.out.print(rs.getInt(1));
//			
//			 System.out.print(rs.getString(2));
//			 System.out.println(rs.getInt(3)+" ");
//		
//			 }
			
			

		} catch (Exception e) {
			System.out.println("查询数据库失败！");
			e.printStackTrace();
		}
	}



	/**
	 * 更新数据表
	 */
	public int update(String sql) {
		int i = -1;
		if (sql != null && !sql.equals("")) {
			getStm();
			try {
				i = stm.executeUpdate(sql);
				System.out.println("更新数据库成功");
			} catch (Exception e) {
				System.out.println("更新数据库失败！");
				e.printStackTrace();
			} finally {
				closed();
			}
		}
		return i;
	}

	/**
	 * 关闭数据库连接
	 */
	public void closed() {
		try {
			if (rs != null)
				rs.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println("关闭数据库失败！");
			e.printStackTrace();
		}
	}
}