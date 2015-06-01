package com.hz.yisheng.demo.pattern.singleton;

/**
 * 双重校验锁
 * 
 * @author huanglei
 * 
 */
public class Singleton3 {

	private static volatile Singleton3 instance;// volatile变量

	private Singleton3() {
	}

	public Singleton3 getInstance() {
		if (null == instance) {
			synchronized (Singleton3.class) {
				if (null == instance) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}
