package com.katsura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Chapter411Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter411Application.class, args);
	}
}
