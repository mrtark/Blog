package com.mrtark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication()
@EnableJpaAuditing(auditorAwareRef = "auditorAwareMethod")
public class BlogApplication {

    public static void main(String[] args) {
        System.setProperty("java.awt.headles","false");
        SpringApplication.run(BlogApplication.class, args);
    }

}
