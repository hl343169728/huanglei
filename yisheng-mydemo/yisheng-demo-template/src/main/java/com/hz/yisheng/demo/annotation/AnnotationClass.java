package com.hz.yisheng.demo.annotation;

/**
 * 
 * @Description 使用自定义注解描述类
 * @author huanglei
 * @date 2015-2-10 上午10:42:52
 * @version 1.0
 * 
 */
@MyAnnotation(name = "张三")
public class AnnotationClass {

	@MyAnnotation(name = "张三", value = "Hello World annotation fieldType")
	private String field;

	@MyAnnotation(name = "张三", value = "Hello World annotation methodType")
	public void test() {

	}

	public void test(@MyAnnotation(name = "张三", value = "Hello World annotation parameterType") String param) {

	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	
}
