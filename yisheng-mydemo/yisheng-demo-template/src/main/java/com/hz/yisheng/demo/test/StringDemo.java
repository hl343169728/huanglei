package com.hz.yisheng.demo.test;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
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
		formatGeneral();
		formatNumber();
		decision();
		judge();
		checkMobile();
		jerque();
		characterUnicode();
		sbDelete();
		encryptUncrypt();
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
	
	/**
	 * 常规类型格式化
	 */
	private static void formatGeneral() {
		String str1 = String.format("%d", 400 / 2);
		String str2 = String.format("%b", 3 > 5);
		String str3 = String.format("%x", 200);
		System.out.println("400的一半是：" + str1);
		System.out.println("3>5正确吗？：" + str2);
		System.out.println("200的十六进制数是：" + str3);
	}
	
	/**
	 * 将数字格式化为货币格式
	 */
	@SuppressWarnings("resource")
	private static void formatNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个数字：");
		double number = scan.nextDouble();
		System.out.println("Locale类的常量作为构造参数获得不同的货币格式：");
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
		System.out.println("Locale.CHINA：" + nf.format(number));
		nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Locale.US：" + nf.format(number));
		nf = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
		System.out.println("Locale.ENGLISH：" + nf.format(number));
	}
	
	/**
	 * 正则表达式
	 */
	private static void decision() {
		String str1 = "Mrkj007";
		String str2 = "mrkj007";
		boolean b1 = str1.matches("\\p{Upper}\\p{Lower}\\p{Lower}\\p{Lower}\\d\\d\\d");
		boolean b2 = str2.matches("\\p{Upper}\\p{Lower}\\p{Lower}\\p{Lower}\\d\\d\\d");
		System.out.println(str1 + "是合法字符吗？" + b1);
		System.out.println(str2 + "是合法字符吗？" + b2);
	}
	
	/**
	 * 正则表达式
	 */
	private static void judge() {
		String regex = "\\w{0,}\\@\\w{0,}\\.{1}\\w{0,}";
		String str1 = "aaaa@";
		String str2 = "aaa";
		String str3 = "aaaa@111.com";
		if (str1.matches(regex)) {
			System.out.println(str1 + "是Email邮箱");
		}
		if (str2.matches(regex)) {
			System.out.println(str2 + "是Email邮箱");
		}
		if (str3.matches(regex)) {
			System.out.println(str3 + "是Email邮箱");
		}
	}
	
	/**
	 * 验证手机号
	 */
	private static void checkMobile() {
		String str1 = "12345678996";
		String str2 = "15863524152";
		System.out.println(check(str1));
		System.out.println(check(str2));
	}

	private static String check(String str) {
		String regex = "1[3,5,8]\\d{9}$";
		if (str.matches(regex)) {
			return str + "\n 是合法的手机号";
		} else {
			return str + "\n 不是合法的手机号";
		}
	}
	
	/**
	 * String 与 StringBuffer 消耗时间比较
	 */
	private static void jerque() {
		String str = "";
		long startTime = new Date().getTime();
		for (int i = 0; i < 10000; i++) {
			str = str + i;
		}
		long endTime = new Date().getTime();
		System.out.println("String 消耗的时间：" + (startTime - endTime));
		StringBuffer sb = new StringBuffer();
		startTime = new Date().getTime();
		for (int i = 0; i < 10000; i++) {
			sb.append(i);
		}
		endTime = new Date().getTime();
		System.out.println("StringBuffer 消耗的时间：" + (startTime - endTime));
	}
	
	/**
	 * 将汉字和字母都转换为Unicode编码
	 */
	private static void characterUnicode() {
		String str = "明日 soft";
		char[] chars = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (char c : chars) {
			sb.append((int)c + " ");
		}
		System.out.println("'明日 soft' 的Unicode编码是：" + sb.toString());
	}
	
	/**
	 * 去重
	 */
	private static void sbDelete() {
		String str = "命运如同海风——吹着青春的舟，飘摇的，曲折的，渡过了时间的海！";
		StringBuffer sb = new StringBuffer(str);
		System.out.println("原来的字符串：" + sb);
		System.out.println("原来的字符串长度：" + sb.length());
		for (int i = 0; i < sb.length(); i++) {
			for (int j = i+1; j < sb.length(); j++) {
				if (sb.charAt(i) == sb.charAt(j)) {
					sb.deleteCharAt(j);
				}
			}
		}
		System.out.println("现在的字符串：" + sb);
		System.out.println("现在的字符串长度：" + sb.length());
	}
	
	/**
	 * 加密算法
	 * @param value
	 * @param secret
	 * @return
	 */
	private static String EAndU(String value, char secret) {
		byte[] b = value.getBytes();
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte)(b[i]^(int)secret);
		}
		return new String(b, 0, b.length);
	}
	
	/**
	 * 加密、解密
	 */
	private static void encryptUncrypt() {
		String str = "我爱 Java";
		char secret = '祈';
		System.out.println("原字符串：" + str);
		String encrypt = EAndU(str, secret);
		System.out.println("加密后的值：" + encrypt);
		String uncrypt = EAndU(encrypt, secret);
		System.out.println("解密后的值：" + uncrypt);
	}

}
