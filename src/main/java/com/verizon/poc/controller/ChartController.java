package com.verizon.poc.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.impl.DefaultTagWorkerFactory;
import com.itextpdf.html2pdf.css.apply.impl.DefaultCssApplierFactory;
import com.verizon.poc.repository.DownloadRepository;
import com.verizon.poc.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChartController {

    @Autowired
    ServletContext servletContext;

    private final TemplateEngine templateEngine;

    public ChartController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Autowired
    private DownloadRepository downloadRepository;
    @GetMapping("/chart")
    public String getChart(Model model){
        List<Integer> surveyMap = getStringIntegerMap();
        model.addAttribute("surveyMap", surveyMap);
        return "index";
        /*        model.addAttribute("downloads", downloadRepository.getDownloadData());
        return "index";*/
    }

    @GetMapping("/")
    public String getChartPage(Model model){
        List<Integer> surveyMap = getStringIntegerMap();
        model.addAttribute("surveyMap", surveyMap);
        return "index";
        /*        model.add Attribute("downloads", downloadRepository.getDownloadData());
        return "index";*/
    }
//    @GetMapping(path = "/pdf")
    public ResponseEntity<?> getPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {


        /* Create HTML using Thymeleaf template Engine */

        WebContext context = new WebContext(request, response, servletContext);

        List<Integer> surveyMap = getStringIntegerMap();
        context.setVariable("surveyMap", surveyMap);
        String orderHtml = templateEngine.process("index", context);

        /* Setup Source and target I/O streams */

        ByteArrayOutputStream target = new ByteArrayOutputStream();


        // Create custom tagworker factory
        // The tag <qr> is mapped on a QRCode tagworker. Every other tag is mapped to the default.
        // The tagworker processes a <qr> tag using iText Barcode functionality
        DefaultTagWorkerFactory tagWorkerFactory = new DefaultTagWorkerFactory();

        // Creates custom css applier factory
        // The tag <qr> is mapped on a BlockCssApplier. Every other tag is mapped to the default.
        DefaultCssApplierFactory cssApplierFactory = new DefaultCssApplierFactory();

        /*Setup converter properties. */
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri("http://localhost:8080");
        converterProperties.setTagWorkerFactory(tagWorkerFactory);
        converterProperties.setCssApplierFactory(cssApplierFactory);
        /* Call convert method */
        HtmlConverter.convertToPdf(orderHtml, target, converterProperties);

        /* extract output as bytes */
        byte[] bytes = target.toByteArray();


        /* Send the response as downloadable PDF */

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(bytes);

    }


    private static List<Integer> getStringIntegerMap() {
        List<Integer> surveyMap = new ArrayList<>();
        surveyMap.add(2000);
        surveyMap.add(2400);
        surveyMap.add(1200);
        surveyMap.add(1800);
        return surveyMap;
    }

}
