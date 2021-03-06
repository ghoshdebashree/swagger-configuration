package com.springswagger.swaggerconfiguration;

import com.springswagger.swaggerconfiguration.Model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SwaggerConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerConfigurationApplication.class, args);
	}
	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.springswagger"))
				.build()
				.apiInfo(apiDetails());
	}
	private ApiInfo apiDetails(){
		return new ApiInfo(
			"Employee details API",
			"Sample API to demonstrate the swagger Configuration",
			"1.0",
			"Free to use",
			new springfox.documentation.service.Contact("Debashree", "http://javabrains.io","a@b.com"),
			"API License",
			"http://javabrains.io",
					Collections.emptyList());
		}


}

