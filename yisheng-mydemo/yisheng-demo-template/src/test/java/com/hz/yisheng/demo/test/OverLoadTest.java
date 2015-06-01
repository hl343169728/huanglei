package com.hz.yisheng.demo.test;

public class OverLoadTest {

	public static void main(String[] args) {
		new OverLoadTest().max(2, 1);
		new OverLoadTest().max(2.3f, 3.8f);
		new OverLoadTest().max("123", "1");
		new OverLoadTest().max(1, 2, 3);
		System.out.println("-----------------------");
		new OverLoadTest().max(2, 1);
		short i = 10;
		short j = 11;
		new OverLoadTest().max(i,j);
	}

	public void max(int a, int b) {
		System.out.println(a > b ? a : b);
	}

	public void max(float a, float b) {
		System.out.println("short类型参数。。。");
		System.out.println(a > b ? a : b);
	}

	public void max(String a, String b) {
		System.out.println(a.length() > b.length() ? a : b);
	}

	public void max(int a, int b, int c) {
		System.out.println(b > (a > c ? a : c) ? b : (a > c ? a : c));
	}
}
