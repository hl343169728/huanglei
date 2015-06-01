package com.hz.yisheng.demo.test;

public class Demo {

	public static void main(String[] args) {
		int i = 10;
		new Demo().changeCode(i);
		System.out.println(i);
	}

	public void changeCode(int j) {
		j = 100;
	}
}
