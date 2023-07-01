package com.web.demo.batch.step.student;

import com.web.demo.batch.constants.JobConstants;
import com.web.demo.batch.dtos.StudentDTO;
import com.web.demo.batch.models.Student;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component(JobConstants.STUDENT_JOB_ITEM_PROCESSOR_ID)
public class StudentProcess implements ItemProcessor<StudentDTO, Student> {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public Student process(StudentDTO item) throws Exception {
        System.out.println(item);
        if(StringUtils.isNumeric(item.studentId())){
            final Student transformed = new Student(Long.parseLong(item.studentId()),item.studentName(),
                    item.fatherName(), item.gender(), Long.parseLong(item.mobile()), item.category());
            return transformed;
        }
        return null;
    }
}
