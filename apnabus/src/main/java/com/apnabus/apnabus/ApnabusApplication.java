package com.apnabus.apnabus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.apnabus.apnabus") 
@EnableWebMvc
public class ApnabusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApnabusApplication.class, args);
	}
}
