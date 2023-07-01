package com.web.demo.file.json.services;

import com.web.demo.file.json.dtos.SalesOrderDTO;

import java.util.List;

public interface SalesService {

    List<SalesOrderDTO> readSalesDetails();
}
