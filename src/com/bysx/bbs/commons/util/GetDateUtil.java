package com.bysx.bbs.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 得到时间 
 * @author yangmiao
 *
 */
public class GetDateUtil {
	public static String getDate(){
		Date postDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		return dateFormat.format(postDate);
	}
	public static Date strToDate(String s){
		java.sql.Date sqlDate = null;
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-mm-dd");
		try {
			java.util.Date utilDate = formater.parse(s);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

	 public static void main(String[] args) {
		System.out.println(GetDateUtil.getDate());
	}
}
