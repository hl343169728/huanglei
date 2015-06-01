package com.hz.yisheng.demo.pattern.strategy;

/**
 * 具体策略，分别实现某种不同的算法
 * 
 * @author a
 *
 */
public class PriceAStrategy implements DiscountStrategy{

	@Override
	public void price() {
		System.out.println("我給你打8折！");
	}

}
