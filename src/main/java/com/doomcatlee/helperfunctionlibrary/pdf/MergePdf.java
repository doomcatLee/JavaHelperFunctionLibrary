package com.doomcatlee.helperfunctionlibrary.pdf;

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

    void doMerge(List<InputStream> list, OutputStream outputStream) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte cb = writer.getDirectContent();

        for (InputStream in : list) {
            PdfReader reader = new PdfReader(in);
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                document.newPage();
                //import the page from source pdf
                PdfImportedPage page = writer.getImportedPage(reader, i);
                //add the page to the destination pdf
                cb.addTemplate(page, 0, 0);
            }
        }

        outputStream.flush();
        document.close();
        outputStream.close();
    }

    // Saves merged PDF documents
    public void mergePdfFiles(List<String> files, String dealNumber) {
        List<InputStream> list = new ArrayList<InputStream>();
        try {

            // Source pdfs
            for (String file : files) {
                list.add(new FileInputStream(new File(file)));
            }

            // Resulting pdf
            OutputStream out = new FileOutputStream(new File(dealNumber + ".pdf"));

            doMerge(list, out);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
