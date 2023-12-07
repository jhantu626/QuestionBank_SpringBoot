package io.quizApp.config;
//9826836534

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
			title = "Quiz Management",
			description = "All The Related Operation has Done QuizApp",
			summary = "This is a Quiz app",
			termsOfService = "T&C",
			contact = @Contact(
				name = "Pritam",
				email = "pritam@gmail.com"
			),
			license = @License(
				name = "0000000000"
			),
			version = "v1"
		),
		servers = {
				@Server(
						description = "Prod",
						url = "http://localhost:8080"
				),
				@Server(
						description = "Test",
						url = "http://localhost:8080"
				)
		}
)
class swaggerConfig{

}
