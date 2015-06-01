package com.hz.yisheng.demo.pattern.singleton;

/**
 * 单例模式（懒汉式）
 * 
 * 缺点：synchronized会造成线程阻塞，多线程下影响性能。 如果去掉synchronized那么就不是单例模式了，因为多线程模式下可能会同时走到if(instance==null)处，然后都分别创建实例。 
 * 
 * @author huanglei
 * 
 */
public class Singleton2 {

	private static Singleton2 instance;

	private Singleton2() {

	}

	public synchronized Singleton2 getInstance() {
		if (null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}
}
