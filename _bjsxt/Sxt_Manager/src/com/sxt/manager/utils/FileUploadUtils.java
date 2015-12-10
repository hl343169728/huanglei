package com.sxt.manager.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
/**
 * upLoad  file
 * @author oiYc_
 *
 */
public class FileUploadUtils {

	/**
	 * 格式化当前时间 
	 * 用于保存当前上传的文件 
	 */
	private static SimpleDateFormat sd = new SimpleDateFormat("/yyyy/MM/dd/");
	/**
	 * save upload file to path (目录)
	 * @param BasePath
	 * @param in
	 * @throws Exception
	 * @retrun path 文件存储的路径
	 */
	public static String saveUploadFile(String basePath , InputStream in , String fileName) throws Exception {
		
		FileOutputStream fos = null;
		try{
			/**
			 * 注意保存的时候按日期保存
			 * 避免过多上传文件在一个文件夹内
			 */
			String subPath = sd.format(new Date());
			File dir = new File(basePath + subPath);
			if(!dir.exists()){
				dir.mkdirs();
			}
			/**
			 * 存储文件防止名称重复设置 UUID的随即数为文件后缀名称
			 */
			String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			String path = basePath + subPath + UUID.randomUUID().toString() + ext;
			fos = new  FileOutputStream(path);
			IOUtils.copy(in, fos);
			return path ;
		}catch(Exception e ) {
			throw new RuntimeException(e);
		}finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(fos);
		}
	}
	
	/**
	 * return a fileInputStream
	 * @param file
	 * @return
	 * @author oiYc_
	 */
	public static InputStream ReturnInputStream(File file){
		FileInputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return is;
	}


	
	/**
	 * test main
	 * @param args
	 */
	public static void main(String[] args) {
		
		//System.out.println(System.currentTimeMillis());
		//System.out.println(System.currentTimeMillis());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
		/*
		String rootpath=FileUploadUtils.class.getResource("").getPath().substring(1);
        System.out.println(rootpath);
    	String kk = rootpath.substring(0,rootpath.indexOf("WebRoot/")+8)+"uploads/";
        System.out.println(kk);
		*/
	}
	

}
