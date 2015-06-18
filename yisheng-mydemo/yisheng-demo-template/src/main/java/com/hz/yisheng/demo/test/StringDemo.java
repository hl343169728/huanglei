package com.hz.yisheng.demo.test;

import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class StringDemo {

	public static void main(String[] args) {
		charToString();
		stringTo();
		division();
		checkNumber();
		formatDate();
		formatTime();
		formatDateAndTime();
	}
	
	/**
	 * 字符数组a创建String对象
	 */
	private static void charToString() {
		char[] a = {'g','o','o','d'};
		String str1 = new String(a);
		System.out.println(str1);
		String str2 = new String("good");
		System.out.println(str2);
		System.out.println(str1.equals(str2));
		String str3 = new String(a, 1, 2);
		System.out.println(str3);
		String str4 = new String("Hello");
		String str5 = new String("World");
		System.out.println(str4 + " " + str5);
	}
	
	/**
	 * 字符串去掉所有的空格
	 */
	private static void stringTo() {
		String str = new String("  We are students ");
		System.out.println("原字符串是：" + str);
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuffer sb =  new StringBuffer();
		int i = 1;
		while(st.hasMoreTokens()) {
			i ++;
			sb.append(st.nextToken());
		}
		System.out.println(i);
		System.out.println("去掉字符串中所有的空格后的字符串是：" + sb.toString());
	}
	
	/**
	 * 分隔字符串
	 */
	private static void division() {
		String str = "无言独上西楼， 月如钩， 寂寞梧桐深院锁清秋。剪不断、理还乱、是离愁， 别是一般滋味在心头。 ";
		System.out.println("原字符串长度：" + str.length());
		String[] news = str.split("， |。");
		for (int i = 0; i < news.length; i++) {
			System.out.print("\n" + news[i]);
		}
		System.out.println("分行后字符串数组的长度为：" + news.length);
	}
	
	/**
	 * 判断字符串是否是字符格式
	 */
	private static void checkNumber() {
		String str = "20150617";
		if (isNumber(str)) {
			System.out.println(str + "是数字格式");
		} else {
			System.out.println(str + "不是数字格式");
		}
	}
	
	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isNumber(String str) {
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i])) {
				
			} else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 日期格式化
	 */
	private static void formatDate() {
		Date today = new Date();
		String a = String.format(Locale.US, "%tb", today);
		String b = String.format(Locale.US, "%tB", today);
		String c = String.format("%ta", today);
		String d = String.format("%tA", today);
		String e = String.format("%ty", today);
		String f = String.format("%tY", today);
		String g = String.format("%tm", today);
		String h = String.format("%td", today);
		String i = String.format("%te", today);
		
		System.out.println("格式化的字符串为月份的英文缩写：" + a);
		System.out.println("格式化的字符串为月份的英文全写：" + b);
		System.out.println("月格式化为星期简写：" + c);
		System.out.println("格式化为星期全写：" + d);
		System.out.println("格式化为2位的年份值：" + e);
		System.out.println("格式化为4位的年份值：" + f);
		System.out.println("格式化为2位的月份值：" + g);
		System.out.println("格式化为2位的日期值：" + h);
		System.out.println("格式化为1位的日期值：" + i);
	}
	
	/**
	 * 时间格式化
	 */
	private static void formatTime() {
		Date today = new Date();
		System.out.println("默认时间格式：" + today);
		System.out.println("两位24小时制的小时：" + String.format("%tH", today));
		System.out.println("两位12小时制的小时：" + String.format("%tI", today));
		System.out.println("24小时制的小时：" + String.format("%tk", today));
		System.out.println("12小时制的小时：" + String.format("%tI", today));
		System.out.println("两位小时中的分钟：" + String.format("%tM", today));
		System.out.println("两位分钟中的秒：" + String.format("%tS", today));
		System.out.println("表示时区缩写形式的字符串：" + String.format("%tZ", today));
		System.out.println("上午还是下午：" + String.format("%tp", today));
	}
	
	/**
	 * 日期时间组合格式化
	 */
	private static void formatDateAndTime() {
		Date today = new Date();
		System.out.println("24小时制的时间，被格式化为小时和分钟：" + String.format("%tR", today));
		System.out.println("24小时制的时间，被格式化为小时、分和分钟：" + String.format("%tT", today));
		System.out.println("12小时制的时间，被格式化为：" + String.format("%tr", today));
		System.out.println("日期被格式化为：" + String.format("%tD", today));
		System.out.println("ISO 8601 格式化的完整日期，被格式化为：" + String.format("%tF", today));
		System.out.println("日期和时间被格式化：" + String.format("%tc", today));
	}
}
