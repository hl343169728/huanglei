package com.hz.yisheng.demo.utils;

import org.javafans.common.constants.CommonConstants;

/**
 * 
 * @Description Quartz定时任务调度
 * @author huanglei
 * @date 2015-2-9 上午10:51:32
 * @version 1.0
 * 
 */
public class QuartzJob {

	/**
	 * 调用的任务
	 */
	public void execute() {
		System.out.println(DateUtil
				.getCurrentDateString(CommonConstants.DATE.FORMAT_DEFAULT));
	}

}
