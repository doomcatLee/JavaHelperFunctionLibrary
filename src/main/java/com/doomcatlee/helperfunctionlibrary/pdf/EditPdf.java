package com.doomcatlee.helperfunctionlibrary.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;

import java.io.File;

public class EditPdf {

    // Requires fillable PDF
    public void editPdf() {
        File pdfFile = new File("test.pdf");

        try (PDDocument doc = PDDocument.load(pdfFile)) {
            PDAcroForm pDAcroForm = doc.getDocumentCatalog().getAcroForm();

            pDAcroForm.getFields().get(0).setValue("firstField");
            pDAcroForm.getFields().get(1).setValue("secondField");

            //Flatten the document
            pDAcroForm.flatten();

            // Save the file locally and call it back
            doc.save("result.pdf");

        } catch (Exception ex) {
            System.err.print(ex);
        }
    }
}
