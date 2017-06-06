package br.com.voffice.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;


@SpringBootApplication
@EnableSwagger2
@ComponentScan
@Configuration
public class BootLab05Application {

	public static void main(String[] args) {
		SpringApplication.run(BootLab05Application.class, args);
	}

    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
