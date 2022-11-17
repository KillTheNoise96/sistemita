package com.example.pruebaSis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Hola que hace?").description("Programando o que hace?").build();
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30).
                apiInfo(apiInfo()).
                select().
                apis(RequestHandlerSelectors.basePackage("com.example.pruebaSis.vista")).
                paths(PathSelectors.any()).
                build();
    }
}
