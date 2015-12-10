package com.sxt.manager.model;

import java.util.Date;

/**
 * 学生的一次还款
 * @author ThinkPad
 *
 */
public class Huankuan {
	private int id;
	private double jine;  //根据已有的合同数生成对应金额。而且要检测一下数据库中有没有一样的金额。
	private Date yingHuankuanTime;  //应还款日期
	
	private int hetongId; //对应的合同id
	
	private Date shiHuankuanTime;  //实际还款日期
	
	private String  state="未还";  //未还，已还
	
}
