package com.hz.yisheng.demo.pattern;

import com.hz.yisheng.demo.pattern.factory.Car;
import com.hz.yisheng.demo.pattern.factory.CarFactory;

/**
 * 简单工厂模式
 * 
 * 工厂模式我们随处可见，工厂模式用来创建类的实例，将类的创建从客户端移到统一的对象创建工厂中。
 * 工厂模式的主要优势是隔离了客户端与具体对象的创建，由工厂类负责对象的实例化，客户端只需要告诉工厂类需要什么对象，而不需知道到底实例化的是哪个对象，实现了客户端与对象创建的解耦。
 * 
 * 优点是：隔离了Client和具体的类的创建，将类的创建进行了统一管理。 
 * 缺点是：CarFactory的if/else，这是典型的代码坏味道，如果需要再添加一个法拉利那么就得需要修改CarFactory的if/else方法。这也违背的OO的开闭原则，做扩展都需要修改原有的类
 * 
 * @author huanglei
 *
 */
public class SimpleFactoryTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Car car = new CarFactory().createCar("benz");
		car.run();

		car = new CarFactory().createBwmCar();
		car.run();
	}
}
