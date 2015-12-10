package com.bjsxt.utils;

import java.io.UnsupportedEncodingException;

public class CommonUtils {

	
	public static String changeUTF8( String str){
		
			String newstr = null;
			try {
				newstr = new String(str.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return newstr ;
	}
}
