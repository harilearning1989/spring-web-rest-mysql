package com.web.demo.batch.step.employee;

import com.web.demo.batch.constants.JobConstants;
import com.web.demo.batch.models.Employee;
import com.web.demo.batch.repos.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component(JobConstants.FIRST_JOB_ITEM_WRITER_ID)
public class EmployeeWriter implements ItemWriter<Employee> {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeWriter setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        return this;
    }

    @Override
    public void write(Chunk<? extends Employee> employees) throws Exception {
        //employeeRepository.saveAll(employees);
    }
}
