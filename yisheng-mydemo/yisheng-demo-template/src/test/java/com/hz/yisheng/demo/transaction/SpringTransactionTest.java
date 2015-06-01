package com.hz.yisheng.demo.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hz.yisheng.demo.dao.SpringTransactionDao;
import com.hz.yisheng.demo.orm.Order;
import com.hz.yisheng.demo.orm.Person;

/**
 * 
 * @Description Spring声明式事务 
 * @author huanglei   
 * @date 2015-2-9 下午4:54:22     
 * @version 1.0
 *
 */
public class SpringTransactionTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		SpringTransactionDao personService = (SpringTransactionDao) ctx.getBean("SpringTransactionDao"); 

		Person person = new Person(); 
        person.setName("张三"); 
        person.setAge(21); 
        person.setSex("男"); 
        

        Order order= new Order(); 
        order.setCost(10); 
        order.setCustomerId(12); 
        
        personService.savePersonAndOrder(person,order); 

	}
}
