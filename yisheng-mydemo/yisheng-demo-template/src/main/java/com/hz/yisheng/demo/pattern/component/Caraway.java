package com.hz.yisheng.demo.pattern.component;

/**
 * 是ConcreteDecorator，可以用来修改EggCake
 * 
 * @author a
 *
 */
public class Caraway extends Decorator{

	public Caraway(AppenderFood component) {
		super(component);
	}
	
	public void append(){
		component.append();
		System.out.println("要香菜");
	}
}
