package com.dwfin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ApiDwfTeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDwfTeoApplication.class, args);
	}

}