package com.project.theatre_management_system.util;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components())
				.info(new Info().title("Theatre Management System")
						.description("Theatre Management System is a project for online ticket booking. "
								+ "This system allows users to browse movies, order food, and choose seat options. "
								+ "It helps streamline the process of ordering from various theatre, "
								+ "manage the delivery status, and maintain order history.")
						.version("1.0").contact(new Contact().name("Qspiders Team").email("kalamsathishkumar@gmail.com"))
						.license(new License().name("License").url("#")));
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("public").packagesToScan("com.project.theatre_management_system")
				.build();
	}

}
