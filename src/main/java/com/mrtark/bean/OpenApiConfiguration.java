package com.mrtark.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    //localhost:4444/swagger-ui.html
    //swagger: API Document
    @Bean
    public OpenAPI openAPIMethod(){
        return new OpenAPI().info( new Info()
                .title("My Title")
                .description("My Description")
                .version("V1.0")
                .contact(new Contact()
                        .name("Murat")
                        .url("www.mrtark.com")
                        .email("iletisim@mrtark.com"))
                .termsOfService(" Software INC.")
                .license(new License()
                        .name("Licence ")
                        .url("www."))
        );
    }
}
