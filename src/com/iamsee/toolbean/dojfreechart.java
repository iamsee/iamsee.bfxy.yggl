package com.iamsee.toolbean;

import java.sql.SQLException;

import org.junit.Test;

public class dojfreechart {

	
	public static int getallnum() throws SQLException {

		int allnum = 1;
		DB db = new DB();
		String sql = "select count(*) from t_baseinfo";
		db.getRs(sql);
		if (db.rs != null) {

			while (db.rs.next()) {
				allnum = db.rs.getInt("count(*)");
			}

		}
		System.out.println(allnum);
		return allnum;

	}

	public static int getkeywordnum(String keyword) throws SQLException {

		int keywordnum = 1;
		DB db = new DB();
		String sql = "select count(*) from t_baseinfo where " + keyword;
		db.getRs(sql);
		if (db.rs != null) {

			while (db.rs.next()) {
				keywordnum = db.rs.getInt("count(*)");
			}

		}
		System.out.println(keywordnum);
		return keywordnum;

	}

}
