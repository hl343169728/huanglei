package com.hz.yisheng.demo.pattern;

import com.hz.yisheng.demo.pattern.proxy.CglibInterceptor;
import com.hz.yisheng.demo.pattern.proxy.Eatable;
import com.hz.yisheng.demo.pattern.proxy.LazySheep;

/**
 * Cglib动态代理
 * 
 * @author a
 *
 */
public class CglibProxyTest {

	public static void main(String[] args) {
		Eatable proxy = (Eatable) new CglibInterceptor().createCglibProxy(new LazySheep());
		proxy.eat();
	}
}
