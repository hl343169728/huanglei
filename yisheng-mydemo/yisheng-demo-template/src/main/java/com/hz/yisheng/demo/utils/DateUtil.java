package com.hz.yisheng.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.javafans.common.constants.CommonConstants;

public class DateUtil {

	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 获取指定格式的当前日期字符串
	 * 
	 * @param format
	 *            指定格式
	 * @return
	 */
	public static String getCurrentDateString(String format) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date nowDate = new Date();
		result = sdf.format(nowDate);
		return result;
	}

	/**
	 * 日期类型转指定格式的字符串类型
	 * 
	 * @param date
	 *            日期类型
	 * @param format
	 *            指定格式
	 * @return
	 */
	public static String convertDateToString(Date date, String format) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		result = sdf.format(date);
		return result;
	}

	/**
	 * 字符串类型日期转指定格式字符串日期，如：formatStrDate("2015-01-04 09:46:29.0",DATE_TYPE_Y_M_D
	 * )，转为2015-01-04
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static String formatStrDate(String str, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateFormat.format(date);
	}

	/**
	 * 日期加减 只计算天数
	 * 
	 * @param date
	 * @param p
	 *            计算的天数
	 * @return
	 */
	public static Date dayCount(Date date, int d) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, d);
		return calendar.getTime();
	}

	/**
	 * 日期加减 值计算月份
	 * 
	 * @param date
	 * @param m
	 * @return
	 */
	public static Date monthCount(Date date, int m) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, m);
		return calendar.getTime();
	}

	/**
	 * 得到年份
	 * 
	 * @param date
	 * @return 年份
	 */
	public static int getYear(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		return gc.get(Calendar.YEAR);
	}

	/**
	 * 得到月份
	 * 
	 * @param date
	 * @return 月份
	 */
	public static int getMonth(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		return gc.get(Calendar.MONTH) + 1;
	}

	/**
	 * 得到日
	 * 
	 * @param date
	 * @return 日
	 */
	public static int getDay(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		return gc.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 得到小时
	 * 
	 * @param date
	 * @return 小时
	 */
	public static int getHour(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		return gc.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 得到分钟
	 * 
	 * @param date
	 * @return 分钟
	 */
	public static int getMinute(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		return gc.get(Calendar.MINUTE);
	}

	/**
	 * 取得一个月的天数
	 * 
	 * @param strDate
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 获取指定日期的月初第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfMonth(Date date) {
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		calDate.set(Calendar.DATE, 1);
		return calDate.getTime();
	}

	/**
	 * 获取指定日期的月末最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfMonth(Date date) {
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		calDate.set(Calendar.DATE, calDate.getActualMaximum(Calendar.DATE));
		return calDate.getTime();
	}

	/**
	 * 获取指定日期的月份
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar getCalendar(Date date) {
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		return calDate;
	}

	/**
	 * 获取指定日期的星期第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfWeek(Date date) {
		Date result = null;
		Calendar calDate = getCalendar(date);
		int firstDay = calDate.get(Calendar.DAY_OF_WEEK);
		result = addDay(calDate.getTime(), -firstDay + 1);
		return result;
	}

	/**
	 * 获取指定日期的星期最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfWeek(Date date) {
		Date result = null;
		Calendar calDate = getCalendar(date);
		int firstDay = calDate.get(Calendar.DAY_OF_WEEK);
		result = addDay(calDate.getTime(), 7 - firstDay);
		return result;
	}

	/**
	 * 获取指定日期的年初第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfYear(Date date) {
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		calDate.set(Calendar.DATE, 1);
		calDate.set(Calendar.MONTH, 1);
		return calDate.getTime();
	}

	/**
	 * 判断某一个时间是否在另一个时间之后
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static boolean afterIgnoreDay(Date a, Date b) {
		boolean result = false;
		long la = a.getHours() * 60 * 60 + a.getMinutes() * 60 + a.getSeconds();
		long lb = b.getHours() * 60 * 60 + b.getMinutes() * 60 + b.getSeconds();
		if (la >= lb) {
			return true;
		}
		return result;
	}

	/**
	 * 判断两个时间是否相等
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static boolean equalDay(Date a, Date b) {
		boolean result = false;
		if (a.getYear() == b.getYear() && a.getMonth() == b.getMonth()
				&& a.getDay() == b.getDay()) {
			result = true;
		}
		return result;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static int daysBetween(Date startDate, Date endDate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(
				CommonConstants.DATE.FORMAT_YYYY_MM_dd);
		startDate = sdf.parse(sdf.format(startDate));
		endDate = sdf.parse(sdf.format(endDate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		long startTime = cal.getTimeInMillis();
		cal.setTime(endDate);
		long endTime = cal.getTimeInMillis();
		long between_days = (endTime - startTime) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 增加1/1000秒
	 * 
	 * @param dt
	 * @param millisecond
	 * @return
	 */
	public static Date addMillisecond(Date date, int millisecond) {
		return addSecond(date, (long) millisecond);
	}

	public static Date addMillisecond(Date date, long millisecond) {
		date.setTime(date.getTime() + millisecond);
		return date;
	}

	/**
	 * 增加秒
	 * 
	 * @param date
	 *            日期
	 * @param second
	 *            毫秒数
	 * @return
	 */
	public static Date addSecond(Date date, int second) {
		return addSecond(date, (long) second);
	}

	/**
	 * 增加秒
	 * 
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date addSecond(Date date, float second) {
		return addSecond(date, (long) second);
	}

	/**
	 * 增加秒
	 * 
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date addSecond(Date date, long second) {
		return addMillisecond(date, 1000L * second);
	}

	/**
	 * 增加秒
	 * 
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date addSecond(Date date, double second) {
		Double millisecond = new Double(1000D * second);
		return addMillisecond(date, millisecond.longValue());
	}

	/**
	 * 增加小时
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date addHour(Date date, int hour) {
		return addHour(date, (long) hour);
	}

	/**
	 * 增加小时
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date addHour(Date date, float hour) {
		return addHour(date, (long) hour);
	}

	/**
	 * 增加小时
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date addHour(Date date, long hour) {
		return addMillisecond(date, 0x36ee80L * hour);
	}

	/**
	 * 增加小时
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date addHour(Date date, double hour) {
		Double millisecond = new Double(3600000D * hour);
		return addMillisecond(date, millisecond.longValue());
	}

	/**
	 * 增加天
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, int day) {
		return addDay(date, (long) day);
	}

	/**
	 * 增加天
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, float day) {
		return addDay(date, (long) day);
	}

	/**
	 * 增加天
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, long day) {
		return addMillisecond(date, 0x5265c00L * day);
	}

	/**
	 * 增加天
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, double day) {
		Double millisecond = new Double(86400000D * day);
		return addMillisecond(date, millisecond.longValue());
	}

	/**
	 * 增加月
	 * 
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date addMonth(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(2, cal.get(2) + month);
		return cal.getTime();
	}

	public static Date addMonth(Date date, float month) {
		return addMonth(date, (int) month);
	}

	public static Date addMonth(Date date, long month) {
		return addMonth(date, (new Long(month)).intValue());
	}

	public static Date addMonth(Date date, double month) {
		double floorMonth = Math.floor(month);
		double decimalMonth = month - floorMonth;
		date = addMonth(date, (new Double(floorMonth)).intValue());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(2, cal.get(2) + 1);
		Date nextdt = cal.getTime();
		long monthMillisecond = nextdt.getTime() - date.getTime();
		double millisecond = (double) monthMillisecond * decimalMonth;
		return addMillisecond(date, (long) millisecond);
	}

	/**
	 * 增加年
	 * 
	 * @param dt
	 * @param year
	 * @return
	 */
	public static Date addYear(Date dt, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(1, cal.get(1) + year);
		return cal.getTime();
	}

	public static Date addYear(Date dt, float year) {
		return addYear(dt, (int) year);
	}

	public static Date addYear(Date dt, long year) {
		return addYear(dt, (new Long(year)).intValue());
	}

	public static Date addYear(Date dt, double year) {
		double floorYear = Math.floor(year);
		double decimalYear = year - floorYear;
		dt = addYear(dt, (new Double(floorYear)).intValue());
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(1, cal.get(1) + 1);
		Date nextdt = cal.getTime();
		long yearMillisecond = nextdt.getTime() - dt.getTime();
		double millisecond = (double) yearMillisecond * decimalYear;
		return addSecond(dt, (long) millisecond);
	}

	/**
	 * 判断当前日期是星期几（阿拉伯数字）
	 * 
	 * @param pTime
	 *            要判断的时间
	 * @return dayForWeek 判断结果
	 * @Exception 发生异常
	 */
	public static int dayForWeek(String pTime) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat(
				CommonConstants.DATE.FORMAT_YYYY_MM_dd);
		Calendar c = Calendar.getInstance();
		c.setTime(format.parse(pTime));
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}

	/**
	 * 获取星期几
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static String dayOfWeek(Date date) {
		String weekDaysName = "";
		try {
			int dayOfWeek = dayForWeek(DateUtil.convertDateToString(date,
					CommonConstants.DATE.FORMAT_YYYY_MM_dd));
			weekDaysName = CommonConstants.DATE.weekDaysName[dayOfWeek];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weekDaysName;
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(dayForWeek(dataToStr(new Date(),
		// DATE_TYPE_Y_M_D)));
		// System.out.println(addDay(new Date(), 1));

		System.out.println(dayOfWeek(new Date()));
		System.out.println(formatStrDate("2015-01-04 09:46:29.0",
				CommonConstants.DATE.FORMAT_DEFAULT));
	}
}
