package com.doomcatlee.helperfunctionlibrary.images;

import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

@Component
public class ImageComponent {

    /**
     *
     *  Given url web link, download as jpg file
     *
     *  Arguments:
     *      1. imageUrl = url for the link
     *      2. destinationFile = url of your output
     *
     * **/
    public void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
        is.close();
        os.close();
    }
}
