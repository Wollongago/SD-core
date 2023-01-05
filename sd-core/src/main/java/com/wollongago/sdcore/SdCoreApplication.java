package com.wollongago.sdcore;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SdCoreApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SdCoreApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8000"));
		app.run(args);
	}

}
