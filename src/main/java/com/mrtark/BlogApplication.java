package com.mrtark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.TimeZone;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import javax.annotation.PostConstruct;
@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
@EnableJpaAuditing(auditorAwareRef = "auditorAwareMethod")
@EntityScan(basePackages = "com.mrtark.data.entity")
public class BlogApplication {
    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("IST"));
    }
    public static void main(String[] args) {
        System.setProperty("java.awt.headles","false");
        SpringApplication.run(BlogApplication.class, args);
    }

}
