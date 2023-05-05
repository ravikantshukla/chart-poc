package com.verizon.poc.controller;

import com.ironsoftware.ironpdf.PdfDocument;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.impl.DefaultTagWorkerFactory;
import com.itextpdf.html2pdf.css.apply.impl.DefaultCssApplierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PdfGeneratorUsingIronPdfController {

    @GetMapping(path = "/ironpdf")
    public void getPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PdfDocument myPdf = PdfDocument.renderUrlAsPdf ("localhost:8080/chart");

// Save the PdfDocument to a file
        try {
            myPdf.saveAs(Paths.get("D:\\Verizon\\usingironpdf.pdf"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
