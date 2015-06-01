package com.hz.yisheng.demo.pattern.proxy;

/**
 * 代理类，控制对真实对象的访问，负责创建真实对象，维护指向真实对象的引用，负责访问真实对象
 * 
 * @author a
 *
 */
public class LazySheepProxy implements Eatable {

	private LazySheep real = null;

	@Override
	public void eat() {
		if (null == real) {
			real = new LazySheep();
		}
		washHand();
		real.eat();
	}

	private void washHand() {
		System.out.println("我爱洗手，吃之前要洗手");
	}
}
