package com.bjsxt.action;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class DemoAction {
	private File[] image;
	private String[] imageFileName;
	
	/**
	 * 图片上传的方法
	 * @return
	 * @throws Exception
	 */
	public String upload() throws Exception{
		for (int i = 0; i < image.length; i++) {
			File temp = image[i];
			String fileName = imageFileName[i];
			
		}
		return null;
	}
	
	public File[] getImage() {
		return image;
	}
	public void setImage(File[] image) {
		this.image = image;
	}
	public String[] getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String[] imageFileName) {
		this.imageFileName = imageFileName;
	}
}
