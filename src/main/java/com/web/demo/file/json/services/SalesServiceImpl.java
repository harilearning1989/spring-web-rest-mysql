package com.web.demo.file.json.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.web.demo.file.json.dtos.SalesOrderDTO;
import com.web.demo.file.json.utils.IDemoUtils;
import com.web.demo.utils.DownloadGitHubFiles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Override
    public List<SalesOrderDTO> readSalesDetails() {
        List<SalesOrderDTO> countryRegion = null;
        try {
            //String path = DownloadGitHubFiles.downloadFile("json/sales.json");
            //String fixture = IDemoUtils.readResource(path, Charsets.UTF_8);
            String fixture = IDemoUtils.readResource("sales.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, SalesOrderDTO.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryRegion;
    }

}
