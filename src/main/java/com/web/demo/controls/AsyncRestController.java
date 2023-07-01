package com.web.demo.controls;

import com.web.demo.async.dto.User;
import com.web.demo.async.services.GitHubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("user")
public class AsyncRestController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GitHubLookupService gitHubLookupService;

    @GetMapping("asyncMethods")
    public void callAsyncMethods() {
        // Start the clock
        long start = System.currentTimeMillis();
        try {
            CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
            CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
            CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");
            CompletableFuture<User> page4 = gitHubLookupService.findUser("RameshMF");
            // Wait until they are all done
            CompletableFuture.allOf(page1, page2, page3, page4).join();

            // Print results, including elapsed time
            LOGGER.info("Elapsed time: " + (System.currentTimeMillis() - start));
            LOGGER.info("--> " + page1.get());
            LOGGER.info("--> " + page2.get());
            LOGGER.info("--> " + page3.get());
            LOGGER.info("--> " + page4.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
