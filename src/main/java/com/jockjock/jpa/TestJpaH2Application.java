package com.jockjock.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class TestJpaH2Application {

	public static void main(String[] args) {
		SpringApplication.run(TestJpaH2Application.class, args);
	}

}
