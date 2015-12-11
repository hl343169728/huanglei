package com.bjsxt.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.bjsxt.basedao.BaseDaoImpl;
import com.bjsxt.dao.StudentDao;
import com.bjsxt.model.Student;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

	/**
	 * 通过classId获取
	 */
	@SuppressWarnings({ "rawtypes" })
	public Map<String, Student> findByClassId(int classId) throws Exception {
		List<Student> sList = this.queryListForParams("select * from student where cid=?", new Object[] { classId });
		Map<String, Student> map = new HashMap<String, Student>();
		for (Iterator iterator = sList.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			map.put(student.getSrow() + "_" + student.getScol(), student);
		}
		return map;
	}

}
