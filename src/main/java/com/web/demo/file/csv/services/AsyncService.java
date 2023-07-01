package com.web.demo.file.csv.services;

import com.web.demo.file.csv.dtos.*;

import java.util.List;

public interface AsyncService {
    List<CropInsuranceDTO> readCropDetails(String s);

    List<StudentDTO> readStudentInfo(String s);

    List<EmployeeDTO> readEmployeeInfo(String s);

    List<Countries> readCountriesRegions(String s);

    List<SalesOrderDTO> readSalesOrderDetails(String s);
}
