package com.mehmetpekdemir.categoryservice.common.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${category.swagger.title}")
    private String title;

    @Value("${category.swagger.description}")
    private String description;

    @Value("${category.swagger.license}")
    private String license;

    @Value("${category.swagger.licenseUrl}")
    private String licenseUrl;

    @Value("${category.swagger.version}")
    private String version;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mehmetpekdemir"))
                .paths(PathSelectors.regex("/.*")).build()
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(license)
                .licenseUrl(licenseUrl)
                .version(version)
                .build();
    }

}