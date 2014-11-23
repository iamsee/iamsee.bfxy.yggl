package com.iamsee.toolbean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.iamsee.valuebean.Admin;
import com.iamsee.valuebean.User;

public class DBAdmin
{
	
	DB db = new DB();
	
	public boolean confirmadmin(Admin admin) {

		db.getStm();
		String name = admin.getName();
		String pwd = admin.getPwd();

		System.out.println(name);
		System.out.println(pwd);
		boolean bl = false;

		ResultSet rs;
		try {
			rs = db.stm.executeQuery("select * from t_admin where name='" + name	+ "' and pwd='" + pwd + "';");
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
	


}