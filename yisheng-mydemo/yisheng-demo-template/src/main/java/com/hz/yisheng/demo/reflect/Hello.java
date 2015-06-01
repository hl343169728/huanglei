package com.hz.yisheng.demo.reflect;

import java.util.Map;

public class Hello extends SuperHello implements IHello {

	private String name;
	private int value;
	private int[] array;
	private Map<String, Integer> map;
	public String publicFiled;

	public Hello() {
	}

	public Hello(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public String getPublicFiled() {
		return publicFiled;
	}

	public void setPublicFiled(String publicFiled) {
		this.publicFiled = publicFiled;
	}

	public String toString() {
		return "name=" + name + ",value=" + value;
	}

	@Override
	public void sayHello() throws Exception {
		System.out.println("hello");
	}

	@Override
	public void sayHello(String greeting) throws Exception {
		System.out.println("hello" + greeting);
	}

	@SuppressWarnings("unused")
	private void privateSayHello() {
		System.out.println("private hello");
	}
}
