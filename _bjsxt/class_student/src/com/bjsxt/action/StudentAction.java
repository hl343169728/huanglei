package com.bjsxt.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.dao.impl.StudentDaoImpl;
import com.bjsxt.model.Student;

public class StudentAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private File image;
	private String imageFileName;
	private Student student;
	private List<Student> list = new ArrayList<Student>();
	private StudentDao sdao = new StudentDaoImpl();

	/**
	 * 保存方法
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String save() throws Exception {
		/**
		 * 上传后文件的路径 重名问题及相对路径问题
		 */
		String extName = imageFileName.substring(imageFileName.lastIndexOf("."));// 文件的扩展名 ,如 .jpg
		String path = ServletActionContext.getRequest().getRealPath("upload/images");// 获取预备存储图像的文件地址
		String fileName = new Date().getTime() + extName;// 获取的图像任意时间毫秒数+扩展名，如2324534323.jpg
		FileUtils.copyFile(image, new File(path + "/" + fileName));
		student.setImagePath("upload/images/" + fileName);
		this.sdao.save(this.student);
		return "list";
	}

	/**
	 * 获取学生列表信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getStudentList() throws Exception {
		this.list = this.sdao.findAll();
		return "success";
	}

	/**
	 * 预修改的方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception {
		this.student = this.sdao.findById(this.id);
		return "update";
	}

	/**
	 * 真正的更新方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		Student stu = this.sdao.findById(this.id);
		stu.setSname(this.student.getSname());
		stu.setAge(this.student.getAge());
		stu.setImagePath(this.student.getImagePath());
		stu.setPhone(this.student.getPhone());
		stu.setScol(this.student.getScol());
		stu.setSrow(this.student.getSrow());
		stu.setCid(this.student.getCid());
		this.sdao.update(stu);
		return "list";
	}

	/**
	 * 删除方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		this.sdao.delete(this.id);
		return "list";
	}

	/**
	 * getter和setter方法
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
}
