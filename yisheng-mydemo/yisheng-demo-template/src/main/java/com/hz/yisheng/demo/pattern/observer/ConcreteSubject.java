package com.hz.yisheng.demo.pattern.observer;

import java.util.Vector;

/**
 * 具体目标，具体目标维护状态信息，状态改变时负责通知观察者
 * 
 * @author a
 *
 */
public class ConcreteSubject implements ISubject{

	Vector<IObserver> observers = new Vector<IObserver>();
  	
	@Override
	public void attach(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void inform() {
		Event event = new Event();
		for (IObserver ob:observers) {
			ob.update(this, event);
		}
	}

}
