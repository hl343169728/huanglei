package com.hz.yisheng.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarUtil {

	private static final String DEFAULT_FORMAT = "yyyy-MM-dd";

	private static SimpleDateFormat formater = new SimpleDateFormat();

	/**
	 * 返回当天日期类型
	 * 
	 * @return
	 */
	private static Date now() {
		return new Date();
	}

	/**
	 * 返回指定格式（如：2014-12-12）的日期类型
	 * 
	 * @return
	 */
	public static Date today() {
		return formatDate(DEFAULT_FORMAT, now());
	}

	public synchronized static Date pareDate(String dateString, String format) {
		formater.applyPattern(format);
		formater.setLenient(false);
		try {
			return formater.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	public synchronized static Date parseDate(String dateString) {
		return pareDate(dateString, DEFAULT_FORMAT);
	}

	public static Date now(String format) {
		return formatDate(format, now());
	}

	private synchronized static Date formatDate(String format, Date date) {
		formater.applyPattern(format);
		formater.setLenient(false);
		try {
			return formater.parse(formater.format(date));
		} catch (ParseException e) {
			return now();
		}
	}

	/**
	 * 返回指定格式的字符串日期类型
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(DEFAULT_FORMAT, date);
	}

	public synchronized static String format(String format, Date date) {
		if (date == null)
			return "";
		formater.applyPattern(format);
		return formater.format(date);
	}

	/**
	 * 计算公历某天相差的天数
	 * 
	 * @param start_year
	 * @param start_month
	 * @param start_day
	 * @param end_year
	 * @param end_month
	 * @param end_day
	 * @return
	 */
	public static int getDateOffset(int start_year, int start_month,
			int start_day, int end_year, int end_month, int end_day) {
		int[] monthday = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304,
				334 }; //

		int diffDays = (end_year - start_year) * 365;
		diffDays += ((end_year - 1) / 4 - (start_year - 1) / 4);
		diffDays -= ((end_year - 1) / 100 - (start_year - 1) / 100);
		diffDays += ((end_year - 1) / 400 - (start_year - 1) / 400);

		diffDays += (monthday[end_month - 1] + ((isLeapYear(end_year) && (start_month > 2)) ? 1
				: 0));
		diffDays += end_day;

		diffDays -= (monthday[start_month - 1] + ((isLeapYear(start_year) && (start_month > 2)) ? 1
				: 0));
		diffDays -= start_day;

		return diffDays;
	}

	/**
	 * 判断某年是否是闰年
	 * 
	 * @param year
	 * @return
	 */
	private static boolean isLeapYear(int year) {
		return (!(year % 4 != 0) && (year % 100 != 0) || !(year % 400 != 0));
	}

	public static Calendar calFirstDaynThisWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, week);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 1);
		return c;
	}

	public static Calendar calLastDaynThisWeek(int year, int week) {
		Calendar c = CalendarUtil.calFirstDaynThisWeek(year, week);
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 6);
		return c;
	}
}
