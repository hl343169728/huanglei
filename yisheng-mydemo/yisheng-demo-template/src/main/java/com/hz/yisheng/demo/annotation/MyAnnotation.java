package com.hz.yisheng.demo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @Description 自定义注解
 * @author huanglei   
 * @date 2015-2-10 上午10:40:39     
 * @version 1.0
 *
 */
@Retention(RetentionPolicy.RUNTIME) 
public @interface MyAnnotation {
	
	public String name();
	
	public String value() default "hello";
}
