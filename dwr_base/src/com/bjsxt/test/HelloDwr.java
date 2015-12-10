package com.bjsxt.test;

public class HelloDwr {

	public HelloDwr() {
		System.out.println("初始化了......");
	}
	public void hello(){
		System.out.println("你好--DWR");
	}
	public boolean checkName(String uname){
		System.out.println(uname);
		if("xiaogao".equals(uname)){
			return false;
		}else{
			return true;
		}
	}
}
