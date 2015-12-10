package com.bjsxt.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUtil {

	/**
	 * 保存文件的方法
	 * @param relativePath
	 * @param srcFile
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static String  saveFile(String  relativePath,File  srcFile,String fileName) throws IOException{
		String  path=ServletActionContext.getRequest().getRealPath(relativePath);
		String  str=fileName.substring(fileName.lastIndexOf("."));
		String realName= UUID.randomUUID()+str;  //新文件的名称
		FileUtils.copyFile(srcFile, new File(path+"/"+realName));
		return relativePath+"/"+realName;
	}
}
