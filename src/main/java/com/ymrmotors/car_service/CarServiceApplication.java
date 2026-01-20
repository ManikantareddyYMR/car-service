package com.ymrmotors.car_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Scan at the top-level 'com.ymrmotors' package so entities and repositories
// placed in sibling packages (e.g. com.ymrmotors.model, com.ymrmotors.repository)
// are discovered by Spring Boot.
@SpringBootApplication(scanBasePackages = "com.ymrmotors")
@EntityScan(basePackages = "com.ymrmotors.model")
@EnableJpaRepositories(basePackages = "com.ymrmotors.repository")
public class CarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarServiceApplication.class, args);
	}

}
