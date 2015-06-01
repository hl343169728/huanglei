package com.hz.yisheng.demo.pattern.facade;

/**
 * 子系统：子系统不知道Facade，具体任务由子系统负责执行
 * 
 * @author a
 *
 */
public class SubSystemC {

	public void method() {
		System.out.println("访问子系统C的方法");
	}
}
