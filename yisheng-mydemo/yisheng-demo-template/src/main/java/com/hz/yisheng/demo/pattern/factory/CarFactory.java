package com.hz.yisheng.demo.pattern.factory;

public class CarFactory {

	private static final String BMW_TYPE = "bmw";
	private static final String BENZ_TYPE = "benz";

	public Car createCar(String type) {
		Car car = null;
		if (type.equalsIgnoreCase(BMW_TYPE)) {
			car = new BmwCar();
		} else if (type.equalsIgnoreCase(BENZ_TYPE)) {
			car = new BenzCar();
		} else {
			car = new BmwCar();
		}
		return car;
	}

	public static Car createBwmCar() {
		return new BmwCar();
	}

	public static Car createBenzCar() {
		return new BenzCar();
	}

}
