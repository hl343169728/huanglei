package com.hz.yisheng.demo.utils;

import java.util.Date;

public class IdCardUtil {

	public static String idCardNo15to18(String idCardNo, String year) {
		idCardNo = idCardNo.trim();
		StringBuilder sb = new StringBuilder(idCardNo);
		if (idCardNo != null && idCardNo.length() == 15) {
			sb.insert(6, year);
			sb.insert(17, "%");
		}
		return sb.toString();
	}

	public static String idCardNo18to15(String idCardNo) {
		idCardNo = idCardNo.trim();
		StringBuilder sb = new StringBuilder(idCardNo);
		if (idCardNo != null && idCardNo.length() == 18) {
			sb.delete(17, 18);
			sb.delete(6, 8);
		}
		return sb.toString();
	}

	public static Date parseBirthday(String idCard) {
		if (is15bitIdcard(idCard)) {
			return parse15BitIdcardBirthday(idCard);
		} else {
			return parse18BitIdcardBirthday(idCard);
		}

	}

	private static Date parse18BitIdcardBirthday(String idCard) {
		String text = idCard.substring(6, 14);
		return CalendarUtil.pareDate(text, "yyyyMMdd");
	}

	private static Date parse15BitIdcardBirthday(String idCard) {
		String text = "19" + idCard.substring(6, 12);
		return CalendarUtil.pareDate(text, "yyyyMMdd");
	}

	private static boolean is15bitIdcard(String idCard) {
		return idCard.length() == 15;
	}

}
