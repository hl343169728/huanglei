package com.hz.yisheng.demo.pattern.factory;

public interface ICarFactory {

	public Car createCar();// 工厂方法
	
	public SportCar createSportCar();
	
	public BusinessCar createBusinessCar();
}
