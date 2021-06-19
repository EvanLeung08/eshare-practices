package com.eshare.scheduler;

import com.eshare.job.Job1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashSet;
import java.util.Set;

public class MyScheduler {
	public static void main(String[] args) throws SchedulerException {

		// JobDetail
		JobDetail jobDetail = JobBuilder.newJob(Job1.class)
				.withIdentity("job1", "group1")
				.usingJobData("author","evan")
				.usingJobData("version","0.1")
				.build();

		// Trigger
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(1)
						.repeatForever())
				.build();

		// Trigger
		Trigger trigger1 = TriggerBuilder.newTrigger()
				.withIdentity("trigger2", "group1")
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ? ").withMisfireHandlingInstructionDoNothing()).build();
				;

		Set triggersForJob = new HashSet();
		triggersForJob.add(trigger);
		triggersForJob.add(trigger1);


		// SchedulerFactory
		SchedulerFactory  factory = new StdSchedulerFactory();

		// Scheduler
		Scheduler scheduler = factory.getScheduler();

		// 绑定关系是1：N
		scheduler.scheduleJob(jobDetail, triggersForJob,true);
		scheduler.start();
		
	}

}
