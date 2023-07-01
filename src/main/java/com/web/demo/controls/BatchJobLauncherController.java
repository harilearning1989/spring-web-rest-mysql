package com.web.demo.controls;

import com.web.demo.utils.DownloadGitHubFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("batch")
public class BatchJobLauncherController {

   private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JobLauncher jobLauncher;
    @Qualifier("employeeJob")
    @Autowired
    Job employeeJob;
    @Qualifier("studentJob")
    @Autowired
    Job studentJob;
    @Qualifier("simpleJob")
    @Autowired
    Job simpleJob;
    @Qualifier("job1")
    @Autowired
    Job job1;
    @Qualifier("job2")
    @Autowired
    Job job2;
    @Qualifier("job3")
    @Autowired
    Job job3;



    /**
     * Method to launch the job
     *
     * @return String
     * @throws Exception
     */
    @RequestMapping("/employee")
    public String readEmployee() throws Exception {
        String fileLocation = DownloadGitHubFiles.downloadFile("csv/employee.csv");
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .addString("filePath", fileLocation)
                    .toJobParameters();
            //job launcher is an interface for running the jobs
            jobLauncher.run(employeeJob, jobParameters);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return "Job Launched Successfully!";
    }

    /**
     * Method to launch the job
     *
     * @return String
     * @throws Exception
     */
    @RequestMapping("/student")
    public String readStudent() throws Exception {
        String fileLocation = DownloadGitHubFiles.downloadFile("csv/StudentInfo.csv");
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .addString("filePath", fileLocation)
                    .toJobParameters();
            //job launcher is an interface for running the jobs
            jobLauncher.run(studentJob, jobParameters);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return "Job Launched Successfully!";
    }

    /**
     * Method to launch the job
     *
     * @return String
     * @throws Exception
     */
    @RequestMapping("/simple")
    public String jobLauncher() throws Exception {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .addString("filePath", "abc")
                    .toJobParameters();
            //job launcher is an interface for running the jobs
            jobLauncher.run(simpleJob, jobParameters);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return "Job Launched Successfully!";
    }

    //@Scheduled(fixedRate = 10000)
    @RequestMapping("/job1")
    public void runJob1() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        try {
            jobLauncher.run(job1, jobParameters);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    // @Scheduled(cron = "*/5 * * * * *")
    //@Scheduled(fixedRate = 10000)
    @RequestMapping("/job2")
    public void runJob2() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        try {
            jobLauncher.run(job2, jobParameters);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    // @Scheduled(cron = "*/5 * * * * *")
    //@Scheduled(fixedRate = 10000)
    @RequestMapping("/job3")
    public void runJob3() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        try {
            jobLauncher.run(job3, jobParameters);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
