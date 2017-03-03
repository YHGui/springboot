package com.katsura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Chapter911Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter911Application.class, args);
	}
}
