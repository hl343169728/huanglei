package com.hz.yisheng.demo.pattern.singleton;

/**
 * 静态内部类：是懒加载的，也是线程安全的，因为虚拟机会保证类的初始化是线程安全的
 * 
 * @author huanglei
 *
 */
public class StaticSingleton {

	private StaticSingleton() {
	}

	private static class StaticSingletonHolder {
		private static final StaticSingleton INSTANCE = new StaticSingleton();
	}

	public static StaticSingleton getInstance() {
		return StaticSingletonHolder.INSTANCE;
	}

}
