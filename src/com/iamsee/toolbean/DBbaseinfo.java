package com.iamsee.toolbean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.iamsee.valuebean.baseinfo;

public class DBbaseinfo {
	 

	public static ArrayList GetTotalList(String sql) {
		DB db = new DB();
		ArrayList<baseinfo> baseinfolist = null;

		if (sql != null && !sql.equals("")) {
			db.getRs(sql);
			if (db.rs != null) {
				baseinfolist = new ArrayList<baseinfo>();
				try {
					while (db.rs.next()) {
						baseinfo bi = new baseinfo();
						bi.setId(Integer.parseInt(db.rs.getString("id")));

						bi.setName(db.rs.getString("name"));
						bi.setShortname(db.rs.getString("shortname"));
						bi.setSex(db.rs.getString("sex"));
						bi.setBirth(db.rs.getString("birth"));
						bi.setHometowndes(db.rs.getString("hometowndes"));
						bi.setWorktime(db.rs.getString("worktime"));
						bi.setUnittime(db.rs.getString("unittime"));
						bi.setOrgid(db.rs.getString("orgid"));
						bi.setDeptid(db.rs.getString("deptid"));
						bi.setOrguid(db.rs.getString("orguid"));
						bi.setPostname(db.rs.getString("postname"));

						baseinfolist.add(bi);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		}
		return baseinfolist;

	}
	public  ArrayList Getnowlist(ArrayList<baseinfo> totalList, int pageNum,int pageSize)
	{
		ArrayList nowlist = new ArrayList();
		int start = (pageNum - 1) * pageSize;
		int end = start + pageSize - 1;
		System.out.println(start+"-"+end);
		if (start >= totalList.size())
			return nowlist;
		
		for (int i = start; i <= end; i++) {
			if (i < totalList.size())
				nowlist.add(totalList.get(i));
		}
		return nowlist;
	}
}