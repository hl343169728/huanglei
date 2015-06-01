package com.hz.yisheng.demo.pattern.facade;

/**
 * 外观对象，负责调用具体的子系统来处理任务
 * 
 * @author a
 *
 */
public class Facade {

	public void method(){
		SubSystemA subA = new SubSystemA();
		subA.method();
		SubSystemB subB = new SubSystemB();
		subB.method();
		SubSystemC subC = new SubSystemC();
		subC.method();
	}
}
