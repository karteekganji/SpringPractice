package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Adding '/api' before every URI in the controller
@RequestMapping("/api")
@RestController
public class TestController {

	@GetMapping(value = "/sample")
	public String hello() {
		return "Hello SpringBoot!!";
	}

	// Using HTML properties
	@GetMapping(value = "/")
	public String Welcome() {
		return "<h2 style = \"text-align: center; color:green;\"><b>Welcome to Spring Boot!!</b></h2>";
	}

}
