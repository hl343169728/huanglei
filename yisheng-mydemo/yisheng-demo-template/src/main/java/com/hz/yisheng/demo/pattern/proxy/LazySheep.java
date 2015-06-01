package com.hz.yisheng.demo.pattern.proxy;

/**
 * 真实对象，负责具体执行
 * 
 * @author a
 *
 */
public class LazySheep implements Eatable{

	public LazySheep(){
		
	}
	
	@Override
	public void eat() {
		System.out.println("我是懒羊羊，我就是喜欢吃，我是吃货！");
	}

}
