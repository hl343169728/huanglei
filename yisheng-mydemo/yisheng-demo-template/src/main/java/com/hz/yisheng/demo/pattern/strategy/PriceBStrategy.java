package com.hz.yisheng.demo.pattern.strategy;

/**
 * 具体策略，分别实现某种不同的算法
 * 
 * @author a
 *
 */
public class PriceBStrategy implements DiscountStrategy{

	@Override
	public void price() {
		System.out.println("年底甩货，我打5折！");
	}

}
