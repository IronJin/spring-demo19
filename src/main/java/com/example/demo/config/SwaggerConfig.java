package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "데모 API 명세서",
                description = "데모 API 명세서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi defaultOpenApi() {
        return GroupedOpenApi.builder()
                .packagesToScan("com.example.demo.controller")
                .group("Demo API v1")
                .build();
    }

}
