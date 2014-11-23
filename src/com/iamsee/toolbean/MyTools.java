package com.iamsee.toolbean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTools {
	/**
	 *int->String
	 */
	public static String intToStr(int num){
		return String.valueOf(num);
	}


	/**
	 * 时间格式整理
	 */
	public static String formatDate(long ms){
		Date date=new Date(ms);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate=format.format(date);
		return strDate;
	}
}