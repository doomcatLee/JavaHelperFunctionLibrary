package com.doomcatlee.helperfunctionlibrary.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Component
public class FtpComponent {

    /**
     *
     *  Given multipartFile, upload file to FTP server.\
     *
     * **/
    public String fileUpload(MultipartFile file) {
        String host = "fileupload.com";
        String hostDirectory = "/directory/directory2/";
        String user = "user";
        String password = "password";

        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host);
            reply = ftp.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                throw new Exception("Exception in connecting to FTP Server");
            }

            ftp.login(user, password);
            ftp.enterLocalPassiveMode();
            InputStream input = file.getInputStream();

            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.storeFile(hostDirectory + file.getOriginalFilename(), input);

            ftp.disconnect();
            return new JSONObject().put("result", "Successfully uploaded " + file.getOriginalFilename() + " to the server").toString();
        } catch (Exception e) {
            return new JSONObject().put("result", "Failed on file " + file.getOriginalFilename()).toString();
        }
    }
}
