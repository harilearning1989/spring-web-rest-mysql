package com.web.demo.file.csv.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface CSVService {
    void save(MultipartFile file);


    InputStream load();
}
