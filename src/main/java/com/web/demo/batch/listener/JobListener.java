package com.web.demo.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobListener implements JobExecutionListener {
    private static final Logger LOG = LoggerFactory.getLogger(JobListener.class);

    private JobExecution activeJob;

    @Autowired
    private JobOperator jobOperator;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        final String jobName = jobExecution.getJobInstance().getJobName();
        final BatchStatus batchStatus = jobExecution.getStatus();

        LOG.info("JobListener beforeJob with job {} and status {}", jobName,batchStatus.isRunning());

        synchronized (jobExecution) {
            if (activeJob != null && activeJob.isRunning()) {
                LOG.info("JobListener beforeJob isRunning with job {} and status {}", jobName,batchStatus.isRunning());
                try {
                    jobOperator.stop(jobExecution.getId());
                } catch (NoSuchJobExecutionException | JobExecutionNotRunningException e) {
                    e.printStackTrace();
                }
            } else {
                activeJob = jobExecution;
            }
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        final String jobName = jobExecution.getJobInstance().getJobName();
        final BatchStatus jobExecutionStatus = jobExecution.getStatus();
        LOG.info("JobListener afterJob afterJob with job {} and status {}", jobName,jobExecutionStatus.isRunning());

        synchronized (jobExecution) {
            if (jobExecution == activeJob) {
                activeJob = null;
            }
        }
    }

}
