package com.restcompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class RestCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCompanyApplication.class, args);
	}

}
