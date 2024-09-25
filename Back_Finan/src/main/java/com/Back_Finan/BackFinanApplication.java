package com.Back_Finan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BackFinanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackFinanApplication.class, args);
	}

	@GetMapping("/hello") // Mapeo para el endpoint
    public String hello() {
        return "Hello, World!";
		
    }

}
