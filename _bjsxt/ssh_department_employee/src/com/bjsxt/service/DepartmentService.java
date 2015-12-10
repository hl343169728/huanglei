package com.bjsxt.service;

import com.bjsxt.po.Department;

public interface DepartmentService {

	//根据id查找指定的对象
	Department findById(Integer id) throws Exception;

}
