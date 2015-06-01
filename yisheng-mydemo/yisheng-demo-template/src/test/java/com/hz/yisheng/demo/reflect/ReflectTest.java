package com.hz.yisheng.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import com.hz.yisheng.commondata.CommonDataConstants.Map;

import antlr.collections.List;

/**
 * 
 * @Description Java 反射 
 * 反射机制允许程序在运行时透过Reflection 相关的API取得任何class的内部信息，包括其modifiers（诸如public, static 等等）、superclass（例如Object）、实现interfaces（例如Serializable），Exceptions等，
 * 也包括fields和methods的所有信息，并可于运行时改变fields内容或调用methods。 
 * @author huanglei   
 * @date 2015-2-10 上午10:05:59     
 * @version 1.0
 *
 */
public class ReflectTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		System.out.println("--------------获取类名和类加载器名称 ---------------------");
		Hello hello = new Hello();
		// 获取类名和类加载器名称
		System.out.println(hello.getClass().getName());
		System.out.println(hello.getClass().getClassLoader().getClass().getName());// 属于应用类加载器 

		System.out.println("--------------获取Class类型的对象 ---------------------");
		try {
			// 获取Class类型的对象 
			Class<?> clazz1 = Class.forName("com.hz.yisheng.demo.reflect.Hello");
			Class<Hello> clazz2 = Hello.class;
			Class<? extends Hello> clazz3 = new Hello().getClass();
			System.out.println(clazz1);
			System.out.println(clazz2);
			System.out.println(clazz3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------实例化 ------------------");
		// 实例化 
		Class<Hello> clazz = Hello.class;
		try {
			Hello hell = clazz.newInstance();
			hell.setName("张三");
			System.out.println(hell);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------获取接口-------------------");
		// 获取接口
		Class<Hello> clazz4 = Hello.class;
		Class[] interfaces = clazz4.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println(interfaces[i].getName());
		}
		
		System.out.println("----------------获取超类-------------------");
		// 获取超类
		Class<Hello> clazz5 = Hello.class;
		Class superClazz = clazz5.getSuperclass();
		System.out.println(superClazz.getName());
		
		System.out.println("-----------------获取getFields------------------");
		// 获取getFields
		Class<Hello> clazz6 = Hello.class;
		// 由此可见通过子类的clazz.getFields()可以获得父类的public属性，子类的public属性， 并不能获取它继承自父类的protected属性。 
		Field[] fields = clazz6.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}
		
		System.out.println("-----------------获取getDeclaredFields------------------");
		// 获取getDeclaredFields
		// 通过子类的clazz.getDeclaredFields()可以获取子类的全部修饰符的属性，包括private ,protected以及public类型的，但是不能获取从父类继承的属性。 
		Field[] declaredFields = clazz6.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			System.out.println(declaredFields[i].getName());
		}
		
		System.out.println("----------------getField-------------------");
		try {
			// getField 
			Class<Hello> clazz7 = Hello.class;
			Field field = clazz7.getDeclaredField("name");
			// 获取类型
			System.out.println(field.getType().getName());
			// 获取修饰符
			System.out.println(Modifier.toString(field.getModifiers()));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------操作属性------------------");
		try {
			// 操作属性
			Class<Hello> clazz8 = Hello.class;
			Hello he = clazz.newInstance();
			Field field = clazz8.getDeclaredField("name");
			field.setAccessible(true);
			field.set(he,"张三");
			System.out.println(he);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------获取方法------------------");
		try {
			// 获取方法
			Class<Hello> clazz9 = Hello.class;
			Hello hel = clazz.newInstance();
			// 获取不带参数的方法
			Method method = clazz9.getMethod("sayHello");
			method.invoke(hel);
			// 获取方法的修饰符 
			System.out.println(Modifier.toString(method.getModifiers())); 
			// 获取带参数方法 
			Method paramMethod = clazz.getMethod("sayHello", new Class[]{String.class}); 
			paramMethod.invoke(hello,new Object[]{" 张三"}); 
			// 获取方法的入参 
			Class[] classes = paramMethod.getParameterTypes(); 
			for (int i = 0; i < classes.length; i++) {
				System.out.println(classes[i].getName());
			}
			// 获取方法的出参
			System.out.println(paramMethod.getReturnType());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------调用getter和setter------------------");
		try {
			// 调用getter和setter
			Class<Hello> clazz10 = Hello.class;
			Hello hello1 = (Hello)clazz10.newInstance();
			String fileName = "name";
			// 构造settter和getter方法名称 
			String setterMethodName = "set" + fileName.substring(0,1).toUpperCase() + fileName.substring(1, fileName.length());
			String getterMethodName = "get" + fileName.substring(0,1).toUpperCase() + fileName.substring(1, fileName.length());
			// 获取setter方法，并赋值 
			Method setterMethod = clazz10.getMethod(setterMethodName, String.class);
			setterMethod.invoke(hello1, "张三");
			// 获取getter方法，并获取返回值 
			Method getterMethod = clazz10.getMethod(getterMethodName);
			String name = (String) getterMethod.invoke(hello1);
			System.out.println(name);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
		
		System.out.println("-----------------获取构造方法并实例化------------------");
		try {
			// 获取构造方法并实例化 
			Class<Hello> clazz11 = Hello.class;
			// 获取默认构造方法，并实例化 
			Constructor constructor = clazz11.getConstructor();
			Hello hello2 = (Hello) constructor.newInstance();
			System.out.println(hello2);
			
			// 获取带参数的构造方法，并实例化
			Constructor constrctorParam = clazz11.getConstructor(String.class, int.class);
			Hello helloParam = (Hello) constrctorParam.newInstance("张三", 20);
			System.out.println(helloParam);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------获取异常-------------------");
		try {
			// 获取异常 
			Class<Hello> clazz12 = Hello.class;
			Method method = clazz12.getMethod("sayHello");
			for (Class<?> exception : method.getExceptionTypes()) { 
			    System.out.print(exception.getName()); 
			} 
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------数组 -------------------");
		try {
			// 数组
			Class<Hello> clazz13 = Hello.class;
			Field field = clazz13.getDeclaredField("array"); 
			System.out.println(field.getType()); 
			System.out.println(field.getType().getComponentType()); 
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} 
		
		System.out.println("----------------获取泛型类型  -------------------");
		try {
			// 获取泛型类型 
			Class<Hello> clazz14 = Hello.class;
			Field mapField = clazz14.getDeclaredField("map");
			Type mapMainType = mapField.getGenericType();
			if (mapMainType instanceof ParameterizedType) {
				ParameterizedType parameterizedType = (ParameterizedType) mapMainType;
				// 获取基本类型信息，即Map
				Type basicType = parameterizedType.getRawType();
				System.out.println("基本类型是：" + basicType);
				// 获取泛型类型的泛型参数
				Type[] types = parameterizedType.getActualTypeArguments();
				for (int i = 0; i < types.length; i++) {
					System.out.println("泛型类型是：" + types[i]);
				}
			} else {
				System.out.println("获取泛型类型时出错~");
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------getTypeParameters-------------------");
		TypeVariable[] typeVariables = List.class.getTypeParameters();
		for (TypeVariable typeVariable : typeVariables) {
			System.out.println(typeVariable.getName());
		}
		TypeVariable[] map = Map.class.getTypeParameters();
		for (TypeVariable typeVariable : map) {
			System.out.println(typeVariable.getName());
		}
	}
}
