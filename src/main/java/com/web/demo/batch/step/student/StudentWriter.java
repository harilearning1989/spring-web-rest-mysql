package com.web.demo.batch.step.student;

import com.web.demo.batch.constants.JobConstants;
import com.web.demo.batch.models.Student;
import com.web.demo.batch.repos.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(JobConstants.STUDENT_JOB_ITEM_WRITER_ID)
public class StudentWriter implements ItemWriter<Student> {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private StudentRepository studentRepository;

    @Autowired
    public StudentWriter setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        return this;
    }

    @Override
    public void write(Chunk<? extends Student> students) throws Exception {
        //studentRepository.saveAll(students);
    }
}
