package com.example.springmvc;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com.dao")
@EntityScan("com.model")
@EnableSwagger2
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
		//changes
		System.out.println("I am commit from feature1")
		System.out.println("I am feature2 branch updation");
	}
@Bean
	public Docket swaggerconf() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com"))
						.build()
						.apiInfo(apiDetails());
	}

private ApiInfo apiDetails() {
	return new ApiInfo("Sunlife Api Doc","Sample Api for end user review",
			"1.3.4",
			"for internal use only",
			new springfox.documentation.service.Contact("Itashi",
					"itashi2tech.com", "connect.com"),
			"API License",
			"http://sunloife.com",
			Collections.emptyList()
			);
	
			
}
}
