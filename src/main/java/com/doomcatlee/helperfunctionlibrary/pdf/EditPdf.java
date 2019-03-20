package com.doomcatlee.helperfunctionlibrary.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;

import java.io.File;

public class EditPdf {

    /**
     *
     *  Given file path for PDF, loop through all fillable fields.
     *  Grab by pdf field name and set field
     *
     * **/
    public void editPdf(String filePath) {
        File pdfFile = new File(filePath);

        try (PDDocument doc = PDDocument.load(pdfFile)) {
            PDAcroForm pDAcroForm = doc.getDocumentCatalog().getAcroForm();

            pDAcroForm.getFields().get(0).setValue("firstField"); // Text fields
            pDAcroForm.getFields().get(1).setValue("secondField"); // Text fields

            pDAcroForm.getFields().get(2).setValue("Yes"); // Check boxes
            pDAcroForm.getFields().get(3).setValue("Off"); // Check boxes

            // Flatten the document
            pDAcroForm.flatten();

            // Save file
            doc.save("result.pdf");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
