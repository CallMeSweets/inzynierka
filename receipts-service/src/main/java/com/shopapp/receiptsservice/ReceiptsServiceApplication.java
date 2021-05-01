package com.shopapp.receiptsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReceiptsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceiptsServiceApplication.class, args);
	}

}
