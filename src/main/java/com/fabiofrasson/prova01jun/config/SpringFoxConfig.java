package com.fabiofrasson.prova01jun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

  @Bean
  public Docket swagger() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.fabiofrasson.prova01jun.resources"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(metaData());
  }

  private ApiInfo metaData() {
    return new ApiInfoBuilder()
        .title("Test API")
        .description("Welcome to Test API!")
        .version("1.0")
        .contact(
            new Contact("Fabio Frasson", "http://www.fabiofrasson.com", "contact@fabiofrasson.com"))
        .build();
  }
}
