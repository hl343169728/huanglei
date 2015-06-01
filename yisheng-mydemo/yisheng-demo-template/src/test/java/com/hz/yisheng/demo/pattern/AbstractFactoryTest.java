package com.hz.yisheng.demo.pattern;

import com.hz.yisheng.demo.pattern.factory.BenzCarFactory;
import com.hz.yisheng.demo.pattern.factory.BmwCarFactory;
import com.hz.yisheng.demo.pattern.factory.BusinessCar;
import com.hz.yisheng.demo.pattern.factory.ICarFactory;
import com.hz.yisheng.demo.pattern.factory.SportCar;

/**
 * 抽象工厂模式：
 * 	使用抽象工厂模式创建多个产品族中的一个产品族。如果只有一个产品族那么就等同于工厂方法模式了
 * 应用场景：
 * 	1、多数据库。比如您的程序要支持多数据库访问，但是没有使用orm框架，而是给每一种数据库提供了一个单独的实现类，通过配置文件的数据库类型来决定采用何种数据库的实现类。使用抽象工厂模式很容易更换产品系列，并且某一系列的相关的产品被放在一起使用
 * 	2、多种风格的窗口。如果要提供windows风格或者linux风格的窗口，可以通过抽象工厂模式实现
 * 
 * 抽象工厂的产品家族是按BmwCarFactory和BenzCarFactory的维度来划分的，同样也可以根据SportCarFactory和BusinessCarFactory的维度来划分
 * 
 * @author huanglei
 *
 */
public class AbstractFactoryTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ICarFactory carFactory = new BenzCarFactory();
		BusinessCar businessCar = carFactory.createBusinessCar();
		SportCar sportCar = carFactory.createSportCar();
		carFactory = new BmwCarFactory();
		businessCar = carFactory.createBusinessCar();
		sportCar = carFactory.createSportCar();
	}
}
