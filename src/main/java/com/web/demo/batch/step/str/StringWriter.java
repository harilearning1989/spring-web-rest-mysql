package com.web.demo.batch.step.str;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

/**
 * ItemWriter
 */

public class StringWriter implements ItemWriter<String> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * ItemWriter writes received data to destination.
     *
     * @param inputMessage
     * @throws Exception
     */
   /* @Override
    public void write(List<? extends String> inputMessage) throws Exception {
        //write data to console
        for (String outputMsg : inputMessage) {
            System.out.println("Received input data from Step:- " + outputMsg);
        }
    }*/

    /**
     * ItemWriter writes received data to destination.
     *
     * @param chunk
     * @throws Exception
     */
    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {
        //write data to console
        for (String outputMsg : chunk) {
            System.out.println("Received input data from Step:- " + outputMsg);
        }
    }
}
