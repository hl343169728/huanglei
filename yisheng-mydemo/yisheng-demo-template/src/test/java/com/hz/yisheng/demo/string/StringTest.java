package com.hz.yisheng.demo.string;

public class StringTest {

	public static void main(String[] args) {
		String str1 = "12345";
		String str2 = "6789";

		// 将指定字符串连接到此字符串的结尾
		System.out.println(str1.concat(str2));
		// 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的
		System.out.println(str1.replace("1", "A"));
		
		
	}
}
