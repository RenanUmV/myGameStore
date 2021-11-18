package com.myGameStore.myGameStore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.models.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("com.myGameStore.myGameStore.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metadata())
				.useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, responseMessage())
				.globalResponses(HttpMethod.POST, responseMessage())
				.globalResponses(HttpMethod.PUT, responseMessage())
				.globalResponses(HttpMethod.DELETE, responseMessage());
	}
	
	public static ApiInfo metadata() {
		
		return new ApiInfoBuilder()
				.title("API - My Game Store")
				.description("Projeto API String - My Game Store")
				.version("1. 0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/alysoncampos")
				.contact(contact())
				.build();
	}
	
	private static Contact contact () {
		return new Contact("Alyson Campos",
				"https://github.com/alysoncampos",
				"alyson@gmail.com");
	}
		
}
