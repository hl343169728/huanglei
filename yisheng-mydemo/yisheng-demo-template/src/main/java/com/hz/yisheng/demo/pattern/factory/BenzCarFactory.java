package com.hz.yisheng.demo.pattern.factory;

public class BenzCarFactory implements ICarFactory{

	@Override
	public Car createCar() {
		return new BenzCar();
	}

	@Override
	public SportCar createSportCar() {
		return new BenzSportCar();
	}

	@Override
	public BusinessCar createBusinessCar() {
		return new BenzBusinessCar();
	}

}
