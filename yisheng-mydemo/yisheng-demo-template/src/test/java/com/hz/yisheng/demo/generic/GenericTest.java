package com.hz.yisheng.demo.generic;

public class GenericTest {

	public static void main(String[] args) {
		// Info<String> info = new Info<String>();// 泛型类型为String
		// Info<Object> obj = null;
		// obj = info;

		Infomation<String> i = null; // 声明接口对象
		i = new InfoImpl<String>("汤姆");// 通过子类实例化对象
		System.out.println("内容：" + i.getVar());

		Test t = new Test();// 实例化Test对象
		String str = t.fun("汤姆");// 传递字符串
		System.out.println(str);
		int ii = t.fun(10);// 传递数字，自动装箱
		System.out.println(ii);
	}
}

class Test {
	public <T> T fun(T t) {// 可以接收任意类型的数据
		return t;// 直接把参数返回
	}
}
