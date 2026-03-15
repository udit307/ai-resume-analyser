package com.AiResumeOptimizer.util;


import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PdfExtractor {

    public static String extractText(MultipartFile file) throws IOException {

        PDDocument document = Loader.loadPDF(file.getInputStream().readAllBytes());

        PDFTextStripper stripper = new PDFTextStripper();

        String text = stripper.getText(document);

        document.close();

        return text;
    }
}