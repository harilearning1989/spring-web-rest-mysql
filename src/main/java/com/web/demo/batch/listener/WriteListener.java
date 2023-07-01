package com.web.demo.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WriteListener<S> implements ItemWriteListener<S> {
    private static final Logger LOG = LoggerFactory.getLogger(WriteListener.class);

    public void beforeWrite(List<? extends S> list) {
        LOG.info("WriteListener beforeWrite : {}", list);
    }

    public void afterWrite(List<? extends S> list) {
        LOG.info("WriteListener afterWrite : {}", list);
    }

    public void onWriteError(Exception exception, List<? extends S> list) {
        LOG.info("WriteListener onWriteError  {} with exception", list, exception);
    }

}
