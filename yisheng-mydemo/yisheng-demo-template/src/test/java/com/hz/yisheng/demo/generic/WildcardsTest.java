package com.hz.yisheng.demo.generic;

/**
 * 通配符
 * 
 * @author a
 *
 */
public class WildcardsTest {

	public static void main(String[] args) {
		Info<String> info = new Info<String>();// 使用String为泛型类型
		info.setVar("張三");// 设置内容
		fun(info);
	}

	public static void fun(Info<?> temp) {// 可以接收任意的泛型对象
		System.out.println("內容：" + temp);
	}
}

class Info<T> {
	private T var;// 定义泛型变量

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}

	public String toString() {
		return this.var.toString();
	}

}
