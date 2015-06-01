package com.hz.yisheng.demo.pattern;

import com.hz.yisheng.demo.pattern.observer.ConcreteObserver;
import com.hz.yisheng.demo.pattern.observer.ConcreteSubject;
import com.hz.yisheng.demo.pattern.observer.IObserver;
import com.hz.yisheng.demo.pattern.observer.ISubject;

/**
 * 观察者模式客户端
 * 
 * 1.概述 
 *		观察者模式也称为"依赖"(Dependents)或者"发布-订阅"(Publish-Subscribe)，观察者模式的官方定义是：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖它的对象都得到通知并被自动更新。 只要存在一对多的依赖时，就可以使用观察者模式。 
 *	2.适用性 
 *		1）一个抽象模型有两个方面，其中一个方面依赖于另一方面。将这两者封装在独立的对象中以使他们可以各自独立的改变和复用。 
 *		2）当对一个对象的改变需要同时改变其他对象，而不知道具体有多少个对象有待改变时。 
 *	3.应用场景 
 *		MVC模式。一个数据Model可以通过多个不同的View来展示，例如通过PC和手机，或者通过表格或者图形方式展示，这样model的数据变化的时候，需要通知各个View。 
 *	4.观察者模式要点 
 *		1）由具体的观察者来决定是否要处理更新，可以处理也可以不处理。 
 *		2）通知更新不一定由目标定义来调用，也可以由其中的一个观察者触发。 
 *		3）观察者可以观察多个目标，例如一个表格数据，可能来自多个数据源。 
 *		4）推拉模型。推模型将目标改变的信息推送到各个观察者中，而不管它是不是需要，拉模型由观察者显式的向目标获取改变的信息。 
 *		5）在目标发改变通知之前要保证目标自身的状态是一致的。即要先改变目标的状态，最后再发通知，否则观察者获取到的信息是错误的。
 *
 * @author a
 *
 */
public class ObserverTest {

	public static void main(String[] args) {
		IObserver observer1 = new ConcreteObserver("observer1 ");
		IObserver observer2 = new ConcreteObserver("observer2 ");
		ISubject subject = new ConcreteSubject();
		subject.attach(observer1);
		subject.attach(observer2);
		subject.inform();
	}
}
