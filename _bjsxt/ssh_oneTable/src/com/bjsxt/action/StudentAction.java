package com.bjsxt.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bjsxt.po.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.utils.PageInfo;

@Component
@Scope("prototype")
public class StudentAction {
	@Resource
	private StudentService studentService;
	private Integer id;
	private String sname;
	private Student student;
	private Integer pageNum;
	private PageInfo pageInfo = new PageInfo();
	private Integer[] ids;
	private List<Student> list;
	
	/**
	 * 添加方法
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		this.studentService.add(this.student);
		return "list";
	}
	
	/**
	 * 查询学员所有信息的方法
	 * @return
	 * @throws Exception
	 */
//	public String list() throws Exception{
//		this.list = this.studentService.findAll();
//		return "success";
//	}
	public String list() throws Exception{
		System.out.println(this.studentService);
		this.pageInfo = this.studentService.findAll(this.pageNum,this.sname);
		return "success";
	}
	
	/**
	 * 预修改的方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception{
		this.student = this.studentService.findById(this.id);
		return "update";
	}
	
	/**
	 * 真正的修改的方法
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		Student s = this.studentService.findById(this.id);
		s.setSchool(this.student.getSchool());
		s.setAddress(this.student.getAddress());
		s.setSname(this.student.getSname());
		this.studentService.update(s);
		return "list";
	}
	
	/**
	 * 删除方法
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception{
//		this.studentService.del(this.id);
		for (int i = 0; i < ids.length; i++) {
			Integer id = ids[i];
			this.studentService.del(id);
		}
		return "list";
	}
	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}
