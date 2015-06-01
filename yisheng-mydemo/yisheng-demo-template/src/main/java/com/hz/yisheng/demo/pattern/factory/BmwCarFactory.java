package com.hz.yisheng.demo.pattern.factory;

public class BmwCarFactory implements ICarFactory{

	@Override
	public Car createCar() {
		return new BmwCar();
	}

	@Override
	public SportCar createSportCar() {
		return new BmwSportCar();
	}

	@Override
	public BusinessCar createBusinessCar() {
		return new BmwBusinessCar();
	}

}
