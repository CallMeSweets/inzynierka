package com.shopapp.clothesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClothesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothesServiceApplication.class, args);
	}

}
