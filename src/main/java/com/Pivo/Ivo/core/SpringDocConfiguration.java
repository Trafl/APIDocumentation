package com.Pivo.Ivo.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ProblemDetail;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

@Configuration
public class SpringDocConfiguration {

	@Bean
	OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("ApiDocument")
						.version("v1")
						.description("example of the documentation model using the SpringDoc"))
						.components(new Components()
			                    .addSchemas("ProblemDetail", new Schema<ProblemDetail>()
			                            .type("object")
			                            .addProperty("type", new StringSchema().example("https://document/errors/entity-not-found"))
			                            .addProperty("title", new StringSchema().example("Document not found"))
			                            .addProperty("status", new StringSchema().example(404))
			                            .addProperty("detail", new StringSchema().example("Document id 5 was not found"))
			                            .addProperty("timestamp", new StringSchema().example("2023-10-16T19:32:54.253417400Z"))
										));			
	}
	
}
