package com.web.demo.file.csv.async;

import com.opencsv.bean.CsvToBeanBuilder;
import com.web.demo.file.csv.dtos.StudentDTO;
import com.web.demo.utils.DownloadGitHubFiles;

import java.io.FileReader;
import java.util.List;
import java.util.function.Supplier;

public class ReadStudentSupplier implements Supplier<List<StudentDTO>> {
    @Override
    public List<StudentDTO> get() {
        List<StudentDTO> listCrop = null;
        try {
            String fileName = DownloadGitHubFiles.downloadFile("csv/StudentInfo.csv");
            listCrop = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(StudentDTO.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
