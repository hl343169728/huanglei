package com.hz.yisheng.demo.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hz.yisheng.demo.pattern.proxy.Eatable;
import com.hz.yisheng.demo.pattern.proxy.LazySheep;

/**
 * JDK动态代理 
 * 
 * @author a
 *
 */
public class JdkProxyLazySheepTest {

	public static Eatable getProxy(final Eatable realSubject) {
		// 创建动态代理
		return (Eatable) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), new Class[] { Eatable.class }, new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				washHand();
				// 调用真实对象
				Object retVal = method.invoke(realSubject, args);
				System.out.println("action after method invocation....\n");
				return retVal;
			}
		});
	}
	
	private static void washHand(){ 
        System.out.println("我爱洗手，吃之前要洗手"); 
    } 
	
	public static void main(String[] args) { 
		 // 设置此系统属性,以查看代理类文件System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); 
	     // 创建代理对象 
		 Eatable proxy = JdkProxyLazySheepTest.getProxy(new LazySheep()); 
		 proxy.eat(); 
	} 
}
