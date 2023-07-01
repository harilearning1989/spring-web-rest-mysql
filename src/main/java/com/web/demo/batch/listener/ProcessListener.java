package com.web.demo.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Component
public class ProcessListener<T> implements ItemProcessListener<T, T> {

    private static final Logger LOG = LoggerFactory.getLogger(ReadListener.class);

    public void beforeProcess(String item) {
        System.out.println("ItemProcessListener - beforeProcess");
    }

    public void afterProcess(String item, Number result) {
        System.out.println("ItemProcessListener - afterProcess");
    }

    public void onProcessError(String item, Exception e) {
        System.out.println("ItemProcessListener - onProcessError");
    }
}
