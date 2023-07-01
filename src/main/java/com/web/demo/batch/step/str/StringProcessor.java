package com.web.demo.batch.step.str;

import org.springframework.batch.item.ItemProcessor;

/**
 * ItemProcessor
 */
public class StringProcessor implements ItemProcessor<String, String> {

    /**
     * Read input data from itemReader, and then ItemProcessor applies the business logic here
     *
     * @param content
     * @return String
     * @throws Exception
     */
    @Override
    public String process(String content) throws Exception {
        return "TEST - [" + content.toUpperCase() + "]";
    }
}
