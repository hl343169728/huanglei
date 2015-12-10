package com.sxt.manager.service.impl;

import java.util.List;
import java.util.Map;

import com.sxt.manager.dao.EmployeeDao;
import com.sxt.manager.dao.GradeDao;
import com.sxt.manager.dao.impl.EmployeeDaoImpl;
import com.sxt.manager.dao.impl.GradeDaoImpl;
import com.sxt.manager.model.Employee;
import com.sxt.manager.model.Grade;
import com.sxt.manager.service.GradeService;

public class GradeServiceImpl implements GradeService{
	
	private GradeDao gdao = new GradeDaoImpl();
	private EmployeeDao edao = new EmployeeDaoImpl();

	/**
	 * 保存班级方法
	 */
	@Override
	public void save(Grade grade) throws Exception {
		this.gdao.save(grade);
	}

	/**
	 * 获取班级列表信息
	 */
	@Override
	public List<Map> getGradeList(String currentPage, String pageSize)
			throws Exception {
		return this.gdao.getGradeList(currentPage,pageSize);
	}

	/**
	 * 获取总记录数
	 */
	@Override
	public int getTotal() throws Exception {
		return this.gdao.getTotal();
	}

	/**
	 * 删除方法
	 */
	@Override
	public void delete(int id) throws Exception {
		this.gdao.delete(id);
	}

	/**
	 * 通过id 获取指定的对象
	 */
	@Override
	public Grade findById(int id) throws Exception {
		return this.gdao.findById(id);
	}

	/**
	 * 通过teacherId获取班主任
	 */
	@Override
	public String findEmployeeNameByTeacherId(int teacherId) throws Exception {
		List<Employee> eList = this.edao.queryListForParams("select * from employee where id=?",new Object[]{teacherId});
		if(eList.size()>0){
			return eList.get(0).getEname();
		}
		return null;
	}

	/**
	 * 更新方法
	 */
	@Override
	public void update(Grade g) throws Exception {
		this.gdao.update(g);
	}

	/**
	 * 获取所有的学员可选的班级列表
	 */
	@Override
	public List<Grade> getClassNames() throws Exception {
		return this.gdao.getClassNames();
	}
}
