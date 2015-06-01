package com.hz.yisheng.demo.pattern.strategy;

/**
 * 上下文。维护一个DiscountStrategy的引用，提供setter方法，用于可以替换算法的实现，并提供一个方法getPrice()供客户端访问策略接口
 * 
 * @author a
 *
 */
public class Context {

	DiscountStrategy strategy;

	public Context() {
		// 提供了一个默认实现，这样客户端可以不传入具体策略
		this.strategy = new DefaultStrategy();
	}

	public Context(DiscountStrategy strategy) {
		this.strategy = strategy;
	}

	public DiscountStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(DiscountStrategy strategy) {
		this.strategy = strategy;
	}

}
