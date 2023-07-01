package com.web.demo.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class SpringBatchJobCompletionListener extends JobExecutionListenerSupport {
    Logger logger = LoggerFactory.getLogger(SpringBatchJobCompletionListener.class);

    //COMPLETED,STARTING,STARTED,STOPPING,STOPPED,FAILED,ABANDONED,UNKNOWN

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("BEFORE BATCH JOB STARTS");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("BATCH JOB COMPLETED SUCCESSFULLY");
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            logger.info("BATCH JOB FAILED");
        }
    }

}
