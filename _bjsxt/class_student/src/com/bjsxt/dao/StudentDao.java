package com.bjsxt.dao;

import java.util.Map;

import com.bjsxt.basedao.BaseDao;
import com.bjsxt.model.Student;

public interface StudentDao extends BaseDao<Student> {

	// 通过classId获取Map集合
	Map<String, Student> findByClassId(int classId) throws Exception;

}
