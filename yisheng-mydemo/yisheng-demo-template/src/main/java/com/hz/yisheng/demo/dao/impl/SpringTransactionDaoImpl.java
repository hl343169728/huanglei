package com.hz.yisheng.demo.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hz.yisheng.demo.dao.SpringTransactionDao;
import com.hz.yisheng.demo.orm.Order;
import com.hz.yisheng.demo.orm.Person;

public class SpringTransactionDaoImpl implements SpringTransactionDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 新增人员和订单信息
	 */
	@Override
	public void savePersonAndOrder(Person person, Order order) {
		savePerson(person);
		saveOrder(order);
	}

	/**
	 * 新增人员信息
	 */
	@Override
	public void savePerson(Person person) {
		jdbcTemplate.update(
				"insert into trans_person(name,age,sex)values(?,?,?)",
				new Object[] { person.getName(), person.getAge(),
						person.getSex() }, new int[] { java.sql.Types.VARCHAR,
						java.sql.Types.INTEGER, java.sql.Types.VARCHAR });

	}

	/**
	 * 新增订单信息
	 */
	@Override
	public void saveOrder(Order order) {
		jdbcTemplate.update(
				"insert into trans_orders(cost,customerId)values(?,?)",
				new Object[] { order.getCost(), order.getCustomerId() },
				new int[] { java.sql.Types.INTEGER, java.sql.Types.INTEGER });
	}

}
