package com.hz.yisheng.demo.pattern.singleton;

import java.lang.reflect.Constructor;

/**
 * 反射：先将构造方法修改为了可见，然后强行的创建了2个实例，最终程序输出了false
 * 
 * @author huanglei
 * 
 */
public class SingletongMain {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {

		Class clazz = Singleton.class;

		Constructor[] constructors = clazz.getDeclaredConstructors();

		for (int i = 0; i < constructors.length; i++) {
			Constructor constructor = constructors[i];
			constructor.setAccessible(true);
			Singleton s1 = (Singleton) constructor.newInstance();
			Singleton s2 = (Singleton) constructor.newInstance();

			System.out.println(s1 == s2);
		}
	}
}
