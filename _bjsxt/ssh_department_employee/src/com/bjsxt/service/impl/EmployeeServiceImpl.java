package com.bjsxt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	@Resource
	private EmployeeDao edao;
	public EmployeeDao getEdao() {
		return edao;
	}
	public void setEdao(EmployeeDao edao) {
		this.edao = edao;
	}
	
	
}
