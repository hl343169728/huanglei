package com.sxt.manager.service;

import java.util.List;
import java.util.Map;

import com.sxt.manager.model.Grade;

public interface GradeService {

	//保存方法
	void save(Grade grade) throws Exception;

	//获取班级列表信息
	List<Map> getGradeList(String currentPage, String pageSize) throws Exception;

	//获取总记录数
	int getTotal() throws Exception;

	//删除方法
	void delete(int id) throws Exception;

	//通过id 获取指定的对象
	Grade findById(int id) throws Exception;

	//通过teacherId查找班主任
	String findEmployeeNameByTeacherId(int teacherId) throws Exception;

	//更新方法
	void update(Grade g) throws Exception;

	//获取所有的学员可选的班级列表
	List<Grade> getClassNames() throws Exception;

}
