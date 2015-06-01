package com.hz.yisheng.demo.orm;

import java.io.Serializable;

/**
 * 
 * @Description 订单表实体类
 * @author huanglei
 * @date 2015-2-9 下午3:55:17
 * @version 1.0
 * 
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;// 订单ID
	private int cost;// 花费
	private int customerId;// 顾客ID

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
