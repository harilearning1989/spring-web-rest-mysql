package com.web.demo.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

@Component
public class ReadListener<T> implements ItemReadListener<T> {
    private static final Logger LOG = LoggerFactory.getLogger(ReadListener.class);

    @Override
    public void beforeRead()
    {
        System.out.println("ReaderListener::beforeRead()");
    }

    @Override
    public void afterRead(T t) {
        LOG.info("ReadListener afterRead: {}", t);
    }

    @Override
    public void onReadError(Exception ex) {
        LOG.info("ReadListener onReadError exception: {}", ex);
    }
}
