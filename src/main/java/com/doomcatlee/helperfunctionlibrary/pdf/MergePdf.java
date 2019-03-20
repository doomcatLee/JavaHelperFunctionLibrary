package com.doomcatlee.helperfunctionlibrary.pdf;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class MergePdf {

    /**
     *
     *  Merges multiple PDF files into one PDF.
     *  Given filePath string of all PDFs, merge them into one PDF doc.
     *
     * **/
    public void mergePDFDocuments(ArrayList<String> fileNamesToMerge) {
        // Instantiating PDFMergerUtility class
        PDFMergerUtility PDFmerger = new PDFMergerUtility();
        String outputURI = "/test/someDirectory/";

        // Setting the destination file
        PDFmerger.setDestinationFileName(outputURI + "test.pdf"); // server

        for (String fileName : fileNamesToMerge) {
            // Loading an existing PDF document
            try {
                File file = new File(fileName);
                PDDocument doc = PDDocument.load(file);

                // adding the source files
                PDFmerger.addSource(file);

                // Closing the documents
                doc.close();

            } catch (Exception ex) {ex.printStackTrace();}
        }

        // Merging the two documents
        try {
            PDFmerger.mergeDocuments();
            System.out.println("Documents merged");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
