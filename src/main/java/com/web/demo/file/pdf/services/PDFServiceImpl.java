package com.web.demo.file.pdf.services;

import com.web.demo.file.models.Tutorial;
import com.web.demo.file.repos.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PDFServiceImpl implements PDFService{

    @Autowired
    TutorialRepository repository;
    @Override
    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }
}
