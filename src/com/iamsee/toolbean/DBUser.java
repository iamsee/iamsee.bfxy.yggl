package com.iamsee.toolbean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.iamsee.valuebean.User;
import com.iamsee.toolbean.*;

public class DBUser {
	
	DB db = new DB();
	
	/**
	 * 执行confirmuser 检查登录返回bool
	 * 
	 * @return
	 */
	public boolean confirmuser(User user) {

		db.getStm();
		String name = user.getName();
		String pwd = user.getPwd();

		System.out.println(name);
		System.out.println(pwd);
		boolean bl = false;

		ResultSet rs;
		try {
			rs = db.stm.executeQuery("select * from tb_user where name='" + name	+ "' and pwd='" + pwd + "';");
			System.out.print(rs);
			if (rs.next()) {
				bl = true;
				rs.close();
			} else {
				bl = false;
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closed();
		return bl;
		
	}
	
	/**
	 * 执行adduser语句获取返回值
	 */
	public boolean adduser(User user) {

		db.getStm();
		String name = user.getName();
		String pwd = user.getPwd();
		boolean bl = false;
		String sql = "insert into tb_user (name,pwd) values ('"+ name + "','" + pwd + "')";
		try {
			db.stm.executeUpdate(sql);
			bl = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bl=false;
		}
		db.closed();
		return bl;
	}


}
