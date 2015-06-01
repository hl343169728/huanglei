package com.hz.yisheng.demo.pattern.facade;

/**
 * 子系统：子系统不知道Facade，具体任务由子系统负责执行
 * 
 * @author a
 *
 */
public class SubSystemB {

	public void method() {
		System.out.println("访问子系统B的方法");
	}
}
