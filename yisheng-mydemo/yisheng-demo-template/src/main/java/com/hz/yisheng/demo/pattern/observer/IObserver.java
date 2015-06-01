package com.hz.yisheng.demo.pattern.observer;

/**
 * 观察者，定义了一个更新接口
 * 
 * @author a
 *
 */
public interface IObserver {

	void update(ISubject subject,Event e);
}
