package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring.controller.HelloWorld;

@SpringBootApplication
public class PracticeSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringBootApplication.class, args);
		
	}
}
