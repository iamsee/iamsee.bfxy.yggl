package com.iamsee.toolbean;

import java.sql.SQLException;
import java.util.ArrayList;

import com.iamsee.valuebean.postname;
import com.iamsee.valuebean.postname;

public class DBpostname {

	public static ArrayList GetPostnameList() {
		DB db = new DB();
		String sql = "select distinct(postname) from t_baseinfo";
		ArrayList<postname> postnamelist = null;

		if (sql != null && !sql.equals("")) {
			db.getRs(sql);
			if (db.rs != null) {
				postnamelist = new ArrayList<postname>();
				try {
					while (db.rs.next()) {
						postname pn = new postname();
						pn.setPostname(db.rs.getString("postname"));
						
						postnamelist.add(pn);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		}
		return postnamelist;

	}
}
