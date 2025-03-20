package com.example.okr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.okr.config")
public class OkrApplication {

	public static void main(String[] args) {
		SpringApplication.run(OkrApplication.class, args);
	}

}
