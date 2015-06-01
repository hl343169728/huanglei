package com.hz.yisheng.demo.pattern.strategy;

/**
 * 具体策略，分别实现某种不同的算法
 * 
 * @author a
 *
 */
public class DefaultStrategy implements DiscountStrategy{

	@Override
	public void price() {
		System.out.println("沒有任何打折！");
	}
	
}
