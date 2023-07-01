package com.web.demo.file.excel.servives;

import com.web.demo.file.models.Tutorial;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface ExcelService {
    void save(MultipartFile file);

    List<Tutorial> getAllTutorials();

    InputStream load();
}
