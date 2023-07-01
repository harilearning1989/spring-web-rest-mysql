package com.web.demo.file.csv.async;

import com.opencsv.bean.CsvToBeanBuilder;
import com.web.demo.file.csv.dtos.CropInsuranceDTO;
import com.web.demo.utils.DownloadGitHubFiles;

import java.io.FileReader;
import java.util.List;
import java.util.function.Supplier;

public class ReadCropInsuranceSupplier implements Supplier<List<CropInsuranceDTO>> {

    @Override
    public List<CropInsuranceDTO> get() {
        List<CropInsuranceDTO> listCrop = null;
        try {
            String fileName = DownloadGitHubFiles.downloadFile("csv/crop_insurance.csv");
            listCrop = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(CropInsuranceDTO.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
