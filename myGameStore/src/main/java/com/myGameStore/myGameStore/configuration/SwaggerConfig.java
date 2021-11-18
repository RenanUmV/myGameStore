package com.myGameStore.myGameStore.configuration;

import io.swagger.models.HttpMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {

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
		
}
