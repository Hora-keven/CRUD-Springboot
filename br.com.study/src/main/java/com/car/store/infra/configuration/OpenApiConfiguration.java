package com.car.store.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Car Service API", version = "v1", description = "Documentation of Car service API"))
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components()).info(new io.swagger.v3.oas.models.info.Info().title( "Car Service API").version("v1").description("Documentation of Book Service API").license(new License().name("Apache 2.0").url("htpp://springdoc.org")));
	}

	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH").allowedOrigins("http://localhost:8085").allowedHeaders();
            }
        };
        
        
    }
}
    