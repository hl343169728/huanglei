package com.hz.yisheng.demo.generic;

public class GenericTest4 {

	public static void main(String[] args) {

		Demo3<Demo2<String, Integer>> d = null;// 将Demo2作为Demo3的泛型类型
		Demo2<String, Integer> i = null;// Demo2指定两个泛型类型
		i = new Demo2<String, Integer>("汤姆", 30);// 实例化Demo2对象
		d = new Demo3<Demo2<String, Integer>>(i);// 在Demo3类中设置Demo2类的对象
		System.out.println("内容：" + d.getInfo().getVar() + "，" + d.getInfo().getValue());
	}
}

class Demo2<T, V> {
	
	private T var;
	private V value;

	public Demo2(T var, V value) {
		this.setVar(var);
		this.setValue(value);
	}

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}

class Demo3<S> {
	private S info;

	public Demo3(S info) {
		this.setInfo(info);
	}

	public S getInfo() {
		return info;
	}

	public void setInfo(S info) {
		this.info = info;
	}

}