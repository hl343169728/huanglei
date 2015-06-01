package com.hz.yisheng.demo.pattern.observer;

/**
 * 具体观察者，实现观察者接口以便使自身的状态和目标对象的状态保持一致
 * 
 * @author a
 *
 */
public class ConcreteObserver implements IObserver{

	private String name;
	
	public ConcreteObserver(String name) {
		this.name = name;
	}

	@Override
	public void update(ISubject subject, Event e) {
		System.out.println(name + "收到更新通知");
	}
	
}
