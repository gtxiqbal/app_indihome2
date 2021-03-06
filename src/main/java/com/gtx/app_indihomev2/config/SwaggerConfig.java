package com.gtx.app_indihomev2.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error/*")))
                .paths(Predicates.not(PathSelectors.regex("actuator")))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "Mohammad Iqbal Alhusain",
                "Belum ada Web, nanti menyusul",
                "moh.iqbal.alhusain@gmail.com");

        return new ApiInfo(
                "Restful Api Spring Boot",
                "Ini Adalah Impementasi Swagger pada Rest Spring Boot",
                "Version 2.9.2",
                "Diperuntukan untuk belajar",
                contact,
                "Gratis",
                "Gratis bos",
                Collections.emptyList());
    }
}
