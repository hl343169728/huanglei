package com.hz.yisheng.demo.test;

public class CharTest {

	public static void main(String[] args) {
		byte[] bs = new byte[3];
		System.out.println("byte: " + bs.getClass());

		short[] ss = new short[3];
		System.out.println("short: " + ss.getClass());

		int[] is = new int[3];
		System.out.println("int: " + is.getClass());

		char[] cs = new char[3];
		System.out.println("char: " + cs.getClass());

		long[] ls = new long[3];
		System.out.println("long: " + ls.getClass());

		float[] fs = new float[3];
		System.out.println("float: " + fs.getClass());

		double[] ds = new double[3];
		System.out.println("double: " + ds.getClass());

		Season[] sss = new Season[3];
		System.out.println("Season: " + sss.getClass());

		String[] strs = new String[3];
		System.out.println("String: " + strs.getClass());

		Father[] fas = new Father[3];
		System.out.println("Father: " + fas.getClass());

		// 多维数组
		String[][] strss = new String[3][3];
		System.out.println(strss.getClass());
	}

}

class Father {
	public String name;
}

enum Season {
	Spring, Summer, autumn, winter
}
