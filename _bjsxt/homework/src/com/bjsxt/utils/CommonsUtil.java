package com.bjsxt.utils;

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
	
	/**
	 * 转换为指定的日期格式
	 */
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
}
