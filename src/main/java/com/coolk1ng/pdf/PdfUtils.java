package com.coolk1ng.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * 读取pdf
 *
 * @author coolk1ng
 * @since 2023/2/10 14:40
 */
public class PdfUtils {

    /** 
     * 阅读pdf文本
     * @param file pdf文件
     * @return String
     */
    public static String getPdfText(File file) {
        try {
            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            return pdfTextStripper.getText(document);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
