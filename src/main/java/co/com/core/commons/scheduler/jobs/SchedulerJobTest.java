package co.com.core.commons.scheduler.jobs;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SchedulerJobTest implements Job {

	private static final Logger logger = Logger.getLogger(SchedulerJobTest.class);
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//logger.info("SchedulerJobTest.execute: " + arg0);
		
	}

}
