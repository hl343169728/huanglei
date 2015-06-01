package com.hz.yisheng.demo.pattern.singleton;

/**
 * 单例模式（饿汉式） 
 * 
 * 缺点：初始化类的时候就会创建一个实例，可能会造成浪费。
 * 
 * @author huanglei
 * 
 */
public class Singleton {

	private static Singleton instance = new Singleton();

	private Singleton() {

	}

	public Singleton getInstance() {
		return instance;
	}
}
