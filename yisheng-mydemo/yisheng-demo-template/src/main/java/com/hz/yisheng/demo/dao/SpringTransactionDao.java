package com.hz.yisheng.demo.dao;

import com.hz.yisheng.demo.orm.Order;
import com.hz.yisheng.demo.orm.Person;

public interface SpringTransactionDao {

	public void savePersonAndOrder(Person person, Order order);

	public void savePerson(Person person);

	public void saveOrder(Order order);
}
