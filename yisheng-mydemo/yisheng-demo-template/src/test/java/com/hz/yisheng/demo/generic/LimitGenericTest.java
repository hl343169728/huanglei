package com.hz.yisheng.demo.generic;

/**
 * 受限泛型
 * 
 * @author a
 *
 */
public class LimitGenericTest {

	public static void main(String[] args) {

		Info<Integer> info = new Info<Integer>();// 声明Integer的泛型对象
		Info<Float> info2 = new Info<Float>();// 声明Float的泛型对象
		info.setVar(10);// 设置整数，自动装箱
		info2.setVar(30.1f); // 设置小数，自动装箱
		fun(info);
		fun(info2);

		Info<String> info3 = new Info<String>();
		Info<Object> info4 = new Info<Object>();
		info3.setVar("123456");
		info4.setVar(new Object());
		fun2(info3);
		fun2(info4);

	}

	public static void fun(Info<? extends Number> temp) {// 只能接收Number及其Number的子类
		System.out.println("内容：" + temp);
	}

	public static void fun2(Info<? super String> temp) {// 只能接收String或Object类型的泛型
		System.out.println(temp + "、");
	}
}
