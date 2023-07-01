package com.web.demo.scheduler;

import com.web.demo.scheduler.async.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
public class SchedulerExample {

    //value = "* * * * * * ?"
    //second(0 - 59)
    //minute (0 - 59)
    //hour (0 - 23)
    //day of month (1 - 31)
    //month (1 - 12)
    //day of week (0 - 6) (Sunday=0 or 7)
    //year [optional]

    //So if you want to run a command every 30 minutes you can say either of these:
    //0 0/30 * * * * ?
    //0 0,30 * * * * ?

    @Autowired
    private AsyncTask asyncTask;
    //@Scheduled(cron = "0 0/2 * * * * ?")
    //@Scheduled(fixedDelay = 1000, initialDelay = 3000)
    @Scheduled(cron = "* 0/30 * * * *")
    public void cronJobSch() {
        System.out.println("========SchedulerExample cronJobSch===========");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
        try {
            //Thread.sleep(10000);
            //TimeUnit.SECONDS.sleep(1);
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void testaMethod() {
        asyncTask.asyncMethod();
    }

}
