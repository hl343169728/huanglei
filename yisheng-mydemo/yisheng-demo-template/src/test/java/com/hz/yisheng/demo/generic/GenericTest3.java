package com.hz.yisheng.demo.generic;

public class GenericTest3 {

	public static void main(String[] args) {

		Info<String> i1 = new Info<String>();
		Info<String> i2 = new Info<String>();
		i1.setVar("HELLO");
		i2.setVar("汤姆");
		add(i1, i2);

		Integer[] i = array(1, 2, 3, 4, 5);// 返回泛型数组
		out(i);
	}

	public static <T> void add(Info<T> i1, Info<T> i2) {
		System.out.println(i1.getVar() + "，" + i2.getVar());
	}

	public static <T> T[] array(T... arg) {// 接收可变参数
		return arg;// 返回泛型数组
	}

	public static <T> void out(T[] param) {// 输出
		System.out.print("接受泛型数组：");
		for (T t : param) {
			System.out.print(t + "、");
		}
	}
}
