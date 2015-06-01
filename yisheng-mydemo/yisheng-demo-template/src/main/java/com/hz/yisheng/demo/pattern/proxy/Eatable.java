package com.hz.yisheng.demo.pattern.proxy;

/**
 * 定义代理和真实对象统一的接口，这样保证使用真实对象的时候都可以使用代理类
 * 
 * @author a
 *
 */
public interface Eatable {
	
	void eat();
}
