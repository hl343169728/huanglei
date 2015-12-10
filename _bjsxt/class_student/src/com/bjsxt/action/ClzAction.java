package com.bjsxt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.bjsxt.dao.ClzDao;
import com.bjsxt.dao.StudentDao;
import com.bjsxt.dao.impl.ClzDaoImpl;
import com.bjsxt.dao.impl.StudentDaoImpl;
import com.bjsxt.model.Clz;
import com.bjsxt.model.Student;

public class ClzAction extends BaseAction{
	
	private int id;
	private Clz clz;
	private int classId;
	private ClzDao cdao = new ClzDaoImpl();
	private StudentDao sdao = new StudentDaoImpl();
	private List<Clz> list = new ArrayList<Clz>();
	private Map<String,Student> map;
	

	/**
	 * 保存方法
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		this.cdao.save(this.clz);
		return "VIEW";
	}
	
	/**
	 * 获取学生可选的所有的班级
	 * @return
	 * @throws Exception
	 */
	public String getAllClz() throws Exception{
		List<Clz> list = this.cdao.findAll();
		response.setContentType("html/text,charset=utf-8");
		this.myWriter(JSONArray.fromObject(list).toString());
		return null;
	}
	
	/**
	 * 获取已有的所有班级的基本信息
	 * @return
	 * @throws Exception
	 */
	public String getClassList() throws Exception{
		list = this.cdao.findAll();
		return "LIST";
	}
	
	/**
	 * 获取某个班级的详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception{
		this.clz = this.cdao.findById(classId);
		this.map = this.sdao.findByClassId(classId);
		return "DETAIL";
	}
	
	
	/**
	 * getter和setter 方法
	 * @return
	 */
	public List<Clz> getList() {
		return list;
	}
	public void setList(List<Clz> list) {
		this.list = list;
	}
	public Clz getClz() {
		return clz;
	}
	public void setClz(Clz clz) {
		this.clz = clz;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public Map<String, Student> getMap() {
		return map;
	}
	public void setMap(Map<String, Student> map) {
		this.map = map;
	}
}
