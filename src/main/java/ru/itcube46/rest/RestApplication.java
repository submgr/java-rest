package ru.itcube46.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {
	public static void main(String[] args) {
		System.setProperty("file.encoding","UTF-8");
		SpringApplication.run(RestApplication.class, args);
	}
}
