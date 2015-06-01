//package com.hz.yisheng.demo.utils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;
//
//
///**
// * @描述:
// * @版权:
// * @公司:
// * @作者:王熙斌
// * @创建时间：2013-3-22 上午10:26:40 
// **/
//public class Bean2Xml {
//	
//	protected final static Logger logger = LoggerFactory.getLogger(Bean2Xml.class);
//
//	public static String bean2xml(Object bean,String rootNode){
//		XStream xStream  =   new  XStream( new  DomDriver());
//		xStream.alias(rootNode , bean.getClass()); // 指定class对应的节点名称，默认是完整package名称＋class名称
//		String str  =  xStream.toXML(bean); // str为生成的xml，值为空的属性不生成节点。 
//		logger.debug(str);
//		return str;
//	}
//	
//	public static Object xml2java(String xml,Class<?> clazz,String rootNode) throws InstantiationException, IllegalAccessException{
//		XStream xStreamt  =   new  XStream( new  DomDriver());
//		Object bean = clazz.newInstance();
//		xStreamt.alias( rootNode , bean.getClass()); // 指定节点对应的class
//
//		bean =  xStreamt.fromXML(xml); // str是接收到的xml字符串，注意，xml里面的节点和bean的属性一定要能对应上，否则会抛异常 	
//		return bean;
//	}
//}
