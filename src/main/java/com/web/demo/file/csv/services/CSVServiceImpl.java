package com.web.demo.file.csv.services;

import com.web.demo.file.csv.utils.CSVHelper;
import com.web.demo.file.models.Tutorial;
import com.web.demo.file.repos.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVServiceImpl implements CSVService{

    @Autowired
    TutorialRepository repository;

    @Override
    public void save(MultipartFile file) {
        try {
            List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    @Override
    public ByteArrayInputStream load() {
        List<Tutorial> tutorials = repository.findAll();
        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
        return in;
    }
}
