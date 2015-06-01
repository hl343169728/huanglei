package com.hz.yisheng.demo.quartz;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 使用SimpleTrigger进行调度
 * 
 * @author a
 *
 */
public class SimpleTriggerRunner {

	/**
	 * 首先在①处通过JobDetail封装SimpleJob，同时指定Job在Scheduler中所属组及名称，这里，组名为jGroup1，而名称为job1_1。
	 * 在②处创建一个SimpleTrigger实例，指定该Trigger在Scheduler中所属组及名称。接着设置调度的时间规则。
	 * 最后，需要创建Scheduler实例，并将JobDetail和Trigger实例注册到Scheduler中。这里，我们通过StdSchedulerFactory获取一个Scheduler实例，并通过scheduleJob(JobDetail jobDetail, Trigger trigger)完成两件事：
	 * 1）将JobDetail和Trigger注册到Scheduler中；
	 * 2）将Trigger指派给JobDetail，将两者关联起来。
	 * 当Scheduler启动后，Trigger将定期触发并执行SimpleJob的execute(JobExecutionContext jobCtx)方法，然后每 10 秒重复一次，直到任务被执行 100 次后停止。
	 * 还可以通过SimpleTrigger的setStartTime(java.util.Date startTime)和setEndTime(java.util.Date endTime)指定运行的时间范围，当运行次数和时间范围冲突时，超过时间范围的任务运行不被执行。如可以通过simpleTrigger.setStartTime(new Date(System.currentTimeMillis() + 60000L))指定60秒钟以后开始。
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// ①创建一个JobDetail实例，指定SimpleJob
			JobDetail jobDetail = new JobDetail("job1_1", "jGroup1", SimpleJob.class);
			// ②通过SimpleTrigger定义调度规则：马上启动，每2秒运行一次，共运行100次
			SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1", "tgroup1");
			simpleTrigger.setStartTime(new Date());
			simpleTrigger.setRepeatInterval(2000);
			simpleTrigger.setRepeatCount(100);
			// ③通过SchedulerFactory获取一个调度器实例
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, simpleTrigger);// ④ 注册并进行调度
			scheduler.start();// ⑤调度启动
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
