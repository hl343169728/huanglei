package com.bjsxt.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.HomeworkDao;
import com.bjsxt.dao.impl.HomeworkDaoImpl;
import com.bjsxt.po.Homework;
import com.bjsxt.utils.CommonsUtil;
import com.bjsxt.utils.FileUtil;

public class HomeworkAction extends BaseAction{
	private int id;
	private Homework homework;
	private File[] files;
	private String[] filesFileName;
	private List<Homework> list;
	
	private HomeworkDao hdao = new HomeworkDaoImpl();
	
	/**
	 * 保存方法
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		String path = "";
		for (int i = 0; i < files.length; i++) {
			File temp = files[i];
			String fileName = filesFileName[i];
			path += FileUtil.saveFile("upload/file", temp, fileName); //相对路径
			path = path+";";
		}
		homework.setFilePath(path.substring(0,path.length()-1));
		homework.setTime(CommonsUtil.FormateDate(new Date()));
		this.hdao.save(this.homework);
		return "list";
	}
	
	/**
	 * 获取作业列表信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		this.list = this.hdao.findAll();
		return "success";
	}
	
	/**
	 * getter 和 setter 方法
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Homework getHomework() {
		return homework;
	}
	public void setHomework(Homework homework) {
		this.homework = homework;
	}
	public File[] getFiles() {
		return files;
	}
	public void setFiles(File[] files) {
		this.files = files;
	}
	public String[] getFilesFileName() {
		return filesFileName;
	}
	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}
	public List<Homework> getList() {
		return list;
	}
	public void setList(List<Homework> list) {
		this.list = list;
	}
	
}
