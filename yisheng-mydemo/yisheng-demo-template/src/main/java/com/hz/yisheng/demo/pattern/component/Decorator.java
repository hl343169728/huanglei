package com.hz.yisheng.demo.pattern.component;

/**
 * 维持一个指向Component对象的引用，同时Decorator和EggCake都是AppenderFood对象
 * 
 * @author a
 *
 */
public class Decorator implements AppenderFood{

	public AppenderFood component;
	
	public Decorator(AppenderFood component){
		this.component = component;
	}
	
	@Override
	public void append() {
		component.append();
	}

}
