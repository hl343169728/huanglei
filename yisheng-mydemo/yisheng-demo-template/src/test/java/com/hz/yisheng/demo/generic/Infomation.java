package com.hz.yisheng.demo.generic;

public interface Infomation<T> {// 在接口上定义泛型
	public T getVar();// 定义抽象方法，抽象方法的返回值就是泛型类型
}
