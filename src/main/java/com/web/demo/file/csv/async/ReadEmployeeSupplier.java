package com.web.demo.file.csv.async;

import com.opencsv.bean.CsvToBeanBuilder;
import com.web.demo.file.csv.dtos.EmployeeDTO;
import com.web.demo.utils.DownloadGitHubFiles;

import java.io.FileReader;
import java.util.List;
import java.util.function.Supplier;

public class ReadEmployeeSupplier implements Supplier<List<EmployeeDTO>> {

    @Override
    public List<EmployeeDTO> get() {
        List<EmployeeDTO> listCrop = null;
        try {
            String fileName = DownloadGitHubFiles.downloadFile("csv/employee.csv");
            listCrop = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(EmployeeDTO.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
