package com.hz.yisheng.demo.pattern;

import com.hz.yisheng.demo.pattern.strategy.Context;
import com.hz.yisheng.demo.pattern.strategy.DiscountStrategy;
import com.hz.yisheng.demo.pattern.strategy.PriceAStrategy;

/**
 * 策略模式客户端
 * 缺点：
 * 	因为所有的具体实现都依赖同一个接口，假如示例中DefaultStrategy具体策略实现可以不依赖输入参数，
 * 	而PriceAStrategy需要依赖输入参数，需要由Context为其提供信息，那么这样即使DefaultStrategy不需要任何信息，它的实现中仍然需要有入参，但是却用不到
 * 
 * @author a
 *
 */
public class StrategyTest {

	public static void main(String[] args) {
		DiscountStrategy strategy = new PriceAStrategy();
		Context context = new Context();
		context.setStrategy(strategy);
		context.getStrategy();
	}
}
