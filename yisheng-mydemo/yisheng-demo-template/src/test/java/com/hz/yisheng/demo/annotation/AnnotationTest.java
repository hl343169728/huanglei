package com.hz.yisheng.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * @Description 注解测试类
 * @author huanglei
 * @date 2015-2-10 上午10:51:05
 * @version 1.0
 * 
 */
public class AnnotationTest {

	public static void main(String[] args) {

		System.out.println("---------类注解---------");
		classAnnotation();
		System.out.println("---------方法注解---------");
		methodAnnotation();
		System.out.println("---------属性注解---------");
		fieldAnnotation();
	}

	/**
	 * 类注解
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void classAnnotation() {
		Class clazz = AnnotationClass.class;
		// 判断是否有注解 
		boolean isAnnotation = clazz.isAnnotationPresent(MyAnnotation.class);
		MyAnnotation myAnno = null; 
		if (isAnnotation) {
			myAnno = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
			System.out.println(myAnno.name() + "，" + myAnno.value()); 
		}
		Annotation[] annotations = clazz.getDeclaredAnnotations();
		for (Annotation annotation : annotations) {
			MyAnnotation myAnnotation = (MyAnnotation) annotation;
			System.out.println("class annotaion:" + myAnnotation.name() + "，" + myAnnotation.value());
		}
	}

	/**
	 * 方法注解
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void methodAnnotation() {
		Class clazz = AnnotationClass.class;
		// 不带参数的方法
		Method[] methods = clazz.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if ("test".equals(method.getName())) {
				Annotation[] annotations = clazz.getDeclaredAnnotations();
				for (Annotation annotation : annotations) {
					MyAnnotation myAnnotation = (MyAnnotation) annotation;
					System.out.println("method annotation:" + myAnnotation.name() + "，" + myAnnotation.value());
				}
			}
		}

		// 有参数的方法
		try {
			Method parameterMethod = clazz.getDeclaredMethod("test", String.class);
			Annotation[][] parameterAnnotations = parameterMethod.getParameterAnnotations();
			for (int i = 0; i < parameterAnnotations.length; i++) {
				for (int j = 0; j < parameterAnnotations[i].length; j++) {
					MyAnnotation parameterAnnotation = (MyAnnotation) parameterAnnotations[i][j];
					System.out.println("method annotation parametertype:" + parameterAnnotation.name() + "，" + parameterAnnotation.value());
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 属性注解
	 */
	@SuppressWarnings("rawtypes")
	private static void fieldAnnotation(){
		Class aClass = AnnotationClass.class; 
        Field[] fields = aClass.getDeclaredFields(); 
        for (int i = 0; i < fields.length; i++) { 
            Field field = fields[i]; 
            if (field.getName().equals("field")) { 
                Annotation[] annotations = field.getAnnotations(); 
                for (Annotation annotation:annotations) { 
                    MyAnnotation myAnnotation = (MyAnnotation)annotation; 
                    System.out.println("field annotation:" + myAnnotation.name() + "，" +myAnnotation.value()); 
                } 
            } 
        } 
	}
}
