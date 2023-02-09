package com.example.postgre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableR2dbcRepositories("com.example.postgre.repository")
@EnableScheduling
public class PostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresApplication.class, args);
	}
}