package com.web.demo.batch.step.employee;

import com.web.demo.batch.constants.JobConstants;
import com.web.demo.batch.dtos.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component(JobConstants.FIRST_JOB_ITEM_READER_ID)
public class EmployeeReader extends FlatFileItemReader<EmployeeDTO> implements StepExecutionListener {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public EmployeeReader() {
        super();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[] { "firstName","lastName","companyName","address","city","county","state","zip" });

        BeanWrapperFieldSetMapper<EmployeeDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(EmployeeDTO.class);

        DefaultLineMapper<EmployeeDTO> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        setLineMapper(lineMapper);
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        JobParameters jobParameters = stepExecution.getJobParameters();
        String filePath = jobParameters.getString("filePath");

        FileSystemResource resource = new FileSystemResource(filePath);
        setResource(resource);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

}
