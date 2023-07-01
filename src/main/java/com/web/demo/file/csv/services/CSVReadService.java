package com.web.demo.file.csv.services;

import com.web.demo.file.csv.dtos.*;

import java.util.List;

public interface CSVReadService {

    List<EmployeeDTO> readEmployeeInfo();

    List<CropInsuranceDTO> readCropDetails();

    List<StudentDTO> readStudentInfo();

    List<Countries> readCountriesRegions();

    List<SalesOrderDTO> readSalesOrderDetails();

    List<IndiaStatesDTO> getIndiaStates();
}
