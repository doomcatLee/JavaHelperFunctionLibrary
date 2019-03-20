package com.doomcatlee.helperfunctionlibrary.files;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadRestController {
    @Autowired
    FileStorageService fileStorageService;

    @RequestMapping(value = "/uploadFileFromRestEndpoint", method = RequestMethod.POST)
    public String uploadFileFromRestEndpoint(@RequestParam("file") MultipartFile file) {
        try {
            fileStorageService.storeFile(file);
            return new JSONObject().put("result", "Success").toString();
        } catch (Exception ex) {
            return new JSONObject().put("result", ex.getMessage()).toString();
        }
    }
}
