package com.sxt.manager.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.sxt.manager.model.Employee;
import com.sxt.manager.model.Grade;
import com.sxt.manager.service.GradeService;
import com.sxt.manager.service.impl.GradeServiceImpl;

public class GradeAction extends BaseAction {
	
	private Grade grade;
	private Employee employee;

	private GradeService gradeService = new GradeServiceImpl();

	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * 保存班级
	 * @return
	 * @throws Exception
	 */
	public String saveGrade() throws Exception{
		String teacherId = this.request.getParameter("teacherId");
		this.grade.setTeacherId(Integer.parseInt(teacherId));
		this.gradeService.save(this.grade);
		this.request.setAttribute("url","/jsp/grade/grade_add.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 获取班级列表信息
	 * @return
	 * @throws Exception
	 */
	public String getGradeList() throws Exception{
		String currentPage = this.request.getParameter("page");  //当前页
		String pageSize    = this.request.getParameter("rows");	 //当前页的记录数
		//获取列表信息
		List<Map> gList  = this.gradeService.getGradeList(currentPage,pageSize);
		//列表的总记录数
		int total = this.gradeService.getTotal();
		String json ="{\"total\":"+total+",\"rows\":"+JSONArray.fromObject(gList).toString()+"}";
		this.myWriter(json);
		return NONE;
	}
	
	/**
	 * 预修改方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdateGrade() throws Exception{
		this.grade = this.gradeService.findById(this.id);
		String employeeName = this.gradeService.findEmployeeNameByTeacherId(this.grade.getTeacherId());
		this.request.setAttribute("employeeName",employeeName);
		return "UPDATE";
	}
	
	/**
	 * 真正的修改方法
	 * @return
	 * @throws Exception
	 */
	public String updateGrade() throws Exception{
		String teacherId = this.request.getParameter("teacherId");
		Grade g = this.gradeService.findById(this.id);
		g.setClassNumber(this.grade.getClassNumber());
		g.setStartTime(this.grade.getStartTime());
		g.setEndTime(this.grade.getEndTime());
		g.setType(this.grade.getType());
		g.setTotalFee(this.grade.getTotalFee());
		g.setPayFee(this.grade.getPayFee());
		g.setPrePayFee(this.grade.getPrePayFee());
		g.setTeacherId(Integer.parseInt(teacherId));
		this.gradeService.update(g);
		this.request.setAttribute("url","/jsp/grade/grade_list.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 删除方法
	 * @return
	 * @throws Exception
	 */
	public String deleteGrade() throws Exception{
		String id = this.request.getParameter("id");
		this.gradeService.delete(Integer.parseInt(id));
		this.request.setAttribute("url","/jsp/grade/grade_list.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 获取班级学员可选的班级列表
	 * @return
	 * @throws Exception
	 */
	public String getClassNumber() throws Exception{
		List<Grade> gList = this.gradeService.getClassNames();
		this.myWriter(JSONArray.fromObject(gList).toString());
		return NONE;
	}
}
