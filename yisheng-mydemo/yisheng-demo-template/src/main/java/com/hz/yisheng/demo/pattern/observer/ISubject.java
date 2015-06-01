package com.hz.yisheng.demo.pattern.observer;

/**
 * 目标对象，可以有任意多个观察者观察目标，目标对象提供了注册和删除观察者对象的接口
 * 
 * @author a
 *
 */
public interface ISubject {
	
	void attach(IObserver observer);
	
	void detach(IObserver observer);
	
	void inform();
}
