package com.verizon.poc;

import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        HtmlConverter.convertToPdf(new File("D:\\Verizon\\chart-poc\\chart-poc\\src\\main\\resources\\templates\\table.html"),new File("D:\\Verizon\\chart-poc\\chart-poc\\src\\main\\resources\\templates\\index.pdf"));
    }
}
