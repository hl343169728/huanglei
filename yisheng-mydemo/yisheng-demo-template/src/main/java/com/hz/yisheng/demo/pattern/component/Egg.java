package com.hz.yisheng.demo.pattern.component;

/**
 * 是ConcreteDecorator，可以用来修改EggCake
 * 
 * @author a
 *
 */
public class Egg extends Decorator{

	public Egg(AppenderFood component) {
		super(component);
	}
	
	public void append(){
		component.append();
		System.out.println("加个蛋");
	}

}
