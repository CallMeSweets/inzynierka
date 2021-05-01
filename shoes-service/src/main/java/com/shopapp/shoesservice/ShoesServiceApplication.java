package com.shopapp.shoesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShoesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoesServiceApplication.class, args);
	}

}
