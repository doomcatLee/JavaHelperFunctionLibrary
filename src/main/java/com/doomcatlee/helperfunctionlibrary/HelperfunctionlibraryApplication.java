package com.doomcatlee.helperfunctionlibrary;

import com.doomcatlee.helperfunctionlibrary.files.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties({FileStorageProperties.class})
public class HelperfunctionlibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelperfunctionlibraryApplication.class, args);
    }
}
