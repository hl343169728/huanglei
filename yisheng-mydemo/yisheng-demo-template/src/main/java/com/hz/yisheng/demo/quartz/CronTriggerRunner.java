package com.hz.yisheng.demo.quartz;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 使用CronTrigger进行调度：我们使用CronTrigger对SimpleJob进行调度，通过Cron表达式制定调度规则，让它每5秒钟运行一次
 * 
 * 运行CronTriggerRunner，每5秒钟将触发运行SimpleJob一次。默认情况下Cron表达式对应当前的时区，
 * 可以通过CronTriggerRunner的setTimeZone(java.util.TimeZone timeZone)方法显式指定时区。
 * 你还也可以通过setStartTime(java.util.Date startTime)和setEndTime(java.util.Date endTime)指定开始和结束的时间。
 * 在代码清单3的②处需要通过Thread.currentThread.sleep()的方式让主线程睡眠，以便调度器可以继续工作执行任务调度。
 * 否则在调度器启动后，因为主线程马上退出，也将同时引起调度器关闭，调度器中的任务都将相应销毁，这将导致看不到实际的运行效果。
 * 在单元测试的时候，让主线程睡眠经常使用的办法。对于某些长周期任务调度的测试，你可以简单地调整操作系统时间进行模拟。
 * 
 * @author a
 *
 */
public class CronTriggerRunner {

	public static void main(String[] args) {
		try {
			// 创建一个JobDetail实例，指定SimpleJob
			JobDetail jobDetail = new JobDetail("job1_2", "jGroup1", SimpleJob.class);
			// ①-1：创建CronTrigger，指定组及名称
			CronTrigger cronTrigger = new CronTrigger("trigger1_2", "tgroup1");
			// ①-2：定义Cron表达式
			CronExpression cexp = new CronExpression("0/5 * * * * ?");
			// ①-3：设置Cron表达式
			cronTrigger.setCronExpression(cexp);
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			scheduler.start();
			
			// ②
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
