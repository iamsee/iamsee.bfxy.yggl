package com.iamsee.toolbean;

import java.util.ArrayList;

import com.iamsee.valuebean.baseinfo;

public class test {
	
	public static void main(String args[])
	{
		DBbaseinfo dbb = new DBbaseinfo();
		String sql = "select * from t_baseinfo";
		ArrayList<baseinfo> totallist = dbb.GetTotalList(sql);
		System.out.println(totallist.size());
		
	}

}
