package com.mrtark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        System.setProperty("java.awt.headles","false");
        SpringApplication.run(BlogApplication.class, args);
    }

}
