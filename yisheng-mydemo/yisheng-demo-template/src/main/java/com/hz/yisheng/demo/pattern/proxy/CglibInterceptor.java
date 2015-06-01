package com.hz.yisheng.demo.pattern.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Cglib动态代理
 * 
 * @author a
 *
 */
public class CglibInterceptor implements MethodInterceptor{
	
	Object real = null;
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		washHand();
		return proxy.invokeSuper(obj, args);
	}
	
	public Object createCglibProxy(Object real){
		this.real = real;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.real.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	private void washHand(){
		 System.out.println("我爱洗手，吃之前要洗手"); 
	}
	
}
