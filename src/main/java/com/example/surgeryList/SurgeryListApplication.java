package com.example.surgeryList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController


public class SurgeryListApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SurgeryListApplication.class, args);
		System.out.println("chakri???");
	}
	
	


}
