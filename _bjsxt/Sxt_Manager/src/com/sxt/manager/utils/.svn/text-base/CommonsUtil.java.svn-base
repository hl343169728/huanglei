package com.sxt.manager.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 本类是javaCode工具类
 * @author oiYc_
 * @version 1.0
 */
public class CommonsUtil {
	
	private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	public static String FormateDate(Date date){
		String str = sf.format(date);
		return sf.format(date);
	}
	
	/**
	 * 将指定字符串形式时间转换成Date
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date StringToDate(String str) throws ParseException{
		DateFormat df =  new SimpleDateFormat("yyyy-MM-dd hh"); 
		Date date  = df.parse(str);
		return date;
	}
	
	/*
	public static void main(String[] args) {
		System.out.println(FormateDate(new Date()));
		System.out.println(1);
		Date d = new Date();
		System.out.println(d.getTime());
		long lo = d.getTime();
		Date d1 = new Date(lo-1000);
		Date d2 = new Date(lo+1000);
		System.out.println(d.after(d1)); 
		System.out.println(d.before(d1));
	}
	*/
	
}
