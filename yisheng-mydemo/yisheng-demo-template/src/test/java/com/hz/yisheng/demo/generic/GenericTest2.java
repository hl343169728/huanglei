package com.hz.yisheng.demo.generic;

public class GenericTest2 {

	public static void main(String[] args) {
		Demo<Integer> d = fun(30);
		System.out.println(d.getVar());
	}

	public static <T extends Number> Demo<T> fun(T param) {// 方法中传入或返回的泛型类型由调用方法时所设置的参数类型决定
		Demo<T> temp = new Demo<T>();// 根据传入的数据类型实例化Demo
		temp.setVar(param);// 将传递的内容设置到Demo对象的var属性之中
		return temp;// 返回实例化对象
	}
}

class Demo<T extends Number> {// 指定上限，只能是数字类型

	private T var;// 此类型由外部决定

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}

	public String toString() { // 覆写Object类中的toString()方法
		return this.var.toString();
	}

}
