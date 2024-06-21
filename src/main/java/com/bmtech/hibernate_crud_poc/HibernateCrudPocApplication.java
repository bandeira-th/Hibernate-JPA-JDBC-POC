package com.bmtech.hibernate_crud_poc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateCrudPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrudPocApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return runner -> {
			System.out.println("Hello World!");
		};
	}

}
