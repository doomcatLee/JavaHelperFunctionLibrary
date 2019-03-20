package com.doomcatlee.helperfunctionlibrary.files;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

@Component
public class FileSave {

    public ResponseEntity<Resource> localFileToRest() {
        File file = new File("test.txt"); // test file to send over
        HttpHeaders headers = new HttpHeaders();
        InputStreamResource resource = null;

        try {
            resource = new InputStreamResource(new FileInputStream(file));
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            // Set the file name
            headers.setContentDispositionFormData(HttpHeaders.CONTENT_DISPOSITION, "result.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);
    }
}
