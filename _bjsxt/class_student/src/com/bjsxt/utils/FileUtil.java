package com.bjsxt.utils;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUtil {
	/**
	 * 保存方法
	 * @param relativePath
	 * @param srcFile
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static String saveFile(String relativePath,File srcFile,String fileName) throws Exception{
		String path = ServletActionContext.getRequest().getRealPath(relativePath);//相对路径
		String str = fileName.substring(fileName.lastIndexOf("."));//扩展名
		String realName = new Date().getTime()+str;//新的文件的名称
		FileUtils.copyFile(srcFile, new File(path+"/"+realName));
		return relativePath+"/"+realName;
	}
}
