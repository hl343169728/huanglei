package com.hz.yisheng.demo.pattern.component;

/**
 * ConcreteComponent对象，可以给它添加职责
 * 
 * @author a
 *
 */
public class EggCake implements AppenderFood{

	@Override
	public void append() {
		System.out.println("来个鸡蛋灌饼");
	}

}
