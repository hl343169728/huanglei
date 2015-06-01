package com.hz.yisheng.demo.pattern;

import com.hz.yisheng.demo.pattern.proxy.Eatable;
import com.hz.yisheng.demo.pattern.proxy.LazySheep;
import com.hz.yisheng.demo.pattern.proxy.LazySheepProxy;

/**
 * 代理模式客户端
 * 
 * 1.定义 
 *		为其它对象提供一种代理以控制对这个对象的访问
 * 2.应用场景 
 * 		1）Spring AOP。Spring AOP底层就是使用动态代理来实现的，Spring将切面织入到代理对象中。 
 * 		2）Hibernate延迟加载。Hibernate提供了延迟加载机制，使用延迟加载时先返回的就是真实对象的代理类，当真正请求的时候才调用真实对象到数据库中加载数据。 
 * 		3）可以在代理类中加入权限验证，记录日志，统计计数器（这个同装饰者模式相同），运行时间统计等等。
 * 3.代理模式与装饰者模式 
 * 		代理模式和装饰者模式有时候看起来很相似，都可以在真实对象的方法前后添加行为，但是两者的目的不同，代理模式是为了控制对真实对象的访问，而装饰者模式是为了给对象添加职责。
 * 		Proxy不像Decorator可以递归组合,代理对象和具体对象是静态的，而装饰者和具体对象之间的组合是动态的，需要在运行时动态组合。
 *  
 * @author a
 *
 */
public class ProxyTest {

	public static void main(String[] args) {
		Eatable lazySheep = new LazySheep();
		lazySheep.eat();
		System.out.println("---------------------");
		Eatable lazySheepProxy = new LazySheepProxy();
		lazySheepProxy.eat();
	}
}
