package com.hz.yisheng.demo.pattern;

import com.hz.yisheng.demo.pattern.factory.BenzCarFactory;
import com.hz.yisheng.demo.pattern.factory.BmwCarFactory;
import com.hz.yisheng.demo.pattern.factory.Car;
import com.hz.yisheng.demo.pattern.factory.ICarFactory;

/**
 * 工厂方法模式
 * 
 * 定义一个用于创建子类的接口，让子类决定实例化哪个类，工厂方法将类的实例化延迟到子类中
 * 
 * 优点是：简单工厂的优点它也具备，同时它避免了简单工厂违背的开闭原则。 
 * 缺点是：类的个数好像增加的有点快，如果再加一辆法拉利，那么又得添加2个类，一个ConcreteProduct，一个ConcreteCreator类
 * 
 * @author huanglei
 *
 */
public class FactoryMethodTest {

	public static void main(String[] args) {
		ICarFactory carFactory = new BenzCarFactory();
		Car car = carFactory.createCar();
		car.run();
		
		carFactory = new BmwCarFactory();
		car = carFactory.createCar();
		car.run();
	}
}
