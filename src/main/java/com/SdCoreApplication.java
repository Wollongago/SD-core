package com;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SdCoreApplication {
	private static final Logger logger = 
		LoggerFactory.getLogger(
			SdCoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SdCoreApplication.class, args);
		logger.info("Application started");
	}

}
