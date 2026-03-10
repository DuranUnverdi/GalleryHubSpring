package com.example.starter;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller","com.example.service","com.example.repository","com.example.model"})
@EntityScan(basePackages = {"com.example.model"})
@EnableJpaRepositories(basePackages = {"com.example.repository"})
public class GalleryhubApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(GalleryhubApplicationStarter.class, args);
	}

}
