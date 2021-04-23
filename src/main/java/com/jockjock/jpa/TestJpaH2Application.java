package com.jockjock.jpa;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class TestJpaH2Application {

	@Bean
	public ApplicationRunner applicationRun() {
		return (args) -> {

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TestJpaH2Application.class, args);
	}

}
