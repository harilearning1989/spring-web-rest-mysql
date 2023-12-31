package com.web.demo.file.csv.services;

import com.web.demo.file.csv.dtos.*;
import com.web.demo.file.csv.read.ReadCSVFiles;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    public List<CropInsuranceDTO> readCropDetails(String s) {
        return ReadCSVFiles.readCropDetails(s);
    }

    @Override
    public List<StudentDTO> readStudentInfo(String s) {
        return ReadCSVFiles.readStudentInfo(s);
    }

    @Override
    public List<EmployeeDTO> readEmployeeInfo(String s) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ReadCSVFiles.readEmployeeInfo(s);
    }

    @Override
    public List<Countries> readCountriesRegions(String s) {
        return ReadCSVFiles.readCountriesRegions(s);
    }

    @Override
    public List<SalesOrderDTO> readSalesOrderDetails(String s) {
        return ReadCSVFiles.readSalesOrderDetails(s);
    }

}
