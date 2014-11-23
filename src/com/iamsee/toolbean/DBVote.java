package com.iamsee.toolbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iamsee.servletbean.selectvoteservlet;
import com.iamsee.toolbean.*;
import com.iamsee.valuebean.*;

public class DBVote {
	
	DB db = new DB();
	MyTools mytools = new MyTools();
	
	public static void main(String args[])
	{
		DBVote dbvote = new DBVote();
		String sql = "select * from tb_vote";
		ArrayList arraylist = dbvote.selectVote(sql);
		System.out.println(arraylist.size());
	}
	
	
	/**
	 * @功能 查询数据表，获取投票选项
	 */
	public ArrayList selectVote(String sql) {

		System.out.println(sql);
		ArrayList votelist = null;
		if (sql != null && !sql.equals("")) {
			db.getRs(sql);

			if (db.rs != null) {
				System.out.println("db.rs 不为空");
				votelist = new ArrayList();
				try {
					System.out.println("开始封装数据 ready");

					System.out.println("开始封装数据 go");
					

					while (db.rs.next()) {
						
						
						VoteSingle voteSingle = new VoteSingle();

						voteSingle.setId(mytools.intToStr(db.rs.getInt("id")));
					
						voteSingle.setBeselected(db.rs.getString("beselected"));
						voteSingle.setVotenum(mytools.intToStr(db.rs.getInt("votenum")));
						String num = voteSingle.getVotenum();
						System.out.println(voteSingle.getId() + " "
								+ voteSingle.getBeselected() + " "
								+ voteSingle.getVotenum());
						votelist.add(voteSingle);

						System.out.println("封装tb_vote表中数据成功");
					}

				} catch (Exception e) {
					System.out.println("封装tb_vote表中数据失败！");
					e.printStackTrace();
				} finally {
					db.closed();
				}
			}

		}
		return votelist;
	}
	
	/**
	 * @功能 更新数据表
	 */
	public int update(String sql) {
		int i = -1;
		if (sql != null && !sql.equals("")) {
			db.getStm();
			try {
				i = db.stm.executeUpdate(sql);
			} catch (Exception e) {
				System.out.println("更新数据库失败！");
				e.printStackTrace();
			} finally {
				db.closed();
			}
		}
		return i;
	}
					
	/**
	 * insert vote
	 */
	public boolean addvote(VoteSingle votesingle) {

		db.getStm();
		String beselected = votesingle.getBeselected();
		int votenum = Integer.valueOf(votesingle.getVotenum());
		boolean bl = false;
		String sql = "insert into tb_vote (beselected,votenum) values ('"+ beselected + "'," + votenum + ")";
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
