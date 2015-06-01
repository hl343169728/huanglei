package com.hz.yisheng.demo.generic;

/**
 * 普通泛型
 * 
 * @author a
 *
 */
public class SampleTest {

	public static void main(String[] args) {

		Point<String> point = new Point<String>();
		point.setVar("张三");
		System.out.println(point.getVar().length());

		Notepad<String, Integer> notepad = new Notepad<String, Integer>();// 定义两个泛型类型的对象，里面的key为String，value为Integer
		notepad.setKey("李四");// 设置第一个内容
		notepad.setValue(20);// 设置第二个内容
		// 取得信息
		System.out.print("姓名：" + notepad.getKey());
		System.out.print("，年龄：" + notepad.getValue());
	}
}

class Point<T> { // 此处可以随便写标识符号，T是type的简称
	private T var;// var的类型由T指定，即：由外部指定

	public T getVar() {// 返回值的类型由外部决定
		return var;
	}

	public void setVar(T var) {// 设置的类型也由外部决定
		this.var = var;
	}

}

class Notepad<K, V> {// 此处指定了两个泛型类型
	private K key;// 此变量的类型由外部决定
	private V value;// 此变量的类型由外部决定

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
