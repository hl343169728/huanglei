package com.hz.yisheng.demo.pattern.singleton;

import java.io.Serializable;

public class SerSingleton implements Serializable {

	private static final long serialVersionUID = 1L;

	String name;

	private SerSingleton() {
		System.out.println("SerSingleton is created");
		name = "SerSingleton";
	}

	private static SerSingleton instance = new SerSingleton();

	public static SerSingleton getInstance() {
		return instance;
	}

	public static void createString() {
		System.out.println("createString is SerSingleton");
	}

	/**
	 * 如果注释掉readResolve()部分，则输出的结果是false，说明反序列化后又创建了一个实例
	 * 
	 * @return
	 */
	private Object readResolve() {
		return instance;
	}
}
