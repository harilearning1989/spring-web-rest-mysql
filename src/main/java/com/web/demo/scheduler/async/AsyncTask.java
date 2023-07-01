package com.web.demo.scheduler.async;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@EnableAsync
public class AsyncTask {

    private Log log = LogFactory.getLog(AsyncTask.class);

    @Async
    public void asyncMethod() {
        log.debug("here is the message");
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}