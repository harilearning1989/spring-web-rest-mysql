package com.web.demo.controls.file;

import com.lowagie.text.DocumentException;
import com.web.demo.file.models.Tutorial;
import com.web.demo.file.pdf.services.PDFService;
import com.web.demo.file.pdf.utils.UserPDFExporter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("pdf")
public class PDFRestController {

    @Autowired
    private PDFService pdfService;

    @GetMapping("/download")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Tutorial> listUsers = pdfService.getAllTutorials();

        UserPDFExporter exporter = new UserPDFExporter();
        exporter.export(response,listUsers);

    }
}
