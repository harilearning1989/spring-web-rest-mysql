package com.web.demo.file.excel.servives;

import com.web.demo.file.excel.utils.ExcelHelper;
import com.web.demo.file.models.Tutorial;
import com.web.demo.file.repos.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


@Service
public class ExcelServiceImpl implements ExcelService{

    @Autowired
    TutorialRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
            tutorials.forEach(t -> {
                System.out.println(t);
            });
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    @Override
    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }

    public ByteArrayInputStream load() {
        List<Tutorial> tutorials = repository.findAll();

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }
}
