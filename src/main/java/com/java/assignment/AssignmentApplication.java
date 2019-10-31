package com.java.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Start up Class
 * Enables JSP Repository
 * Enables Swagger 2
 * 
 * @author AbhishekK
 *
 */
@EnableJpaRepositories(basePackages = "com.java.assignment.repository")
@SpringBootApplication
@EnableSwagger2
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

}
