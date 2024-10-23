package com.csc340.Assigment02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Assigment02Application {

	public static void main(String[] args) {
		SpringApplication.run(Assigment02Application.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}
}
