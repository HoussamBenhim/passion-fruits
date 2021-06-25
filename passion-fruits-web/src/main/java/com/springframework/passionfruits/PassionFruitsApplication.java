package com.springframework.passionfruits;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class PassionFruitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassionFruitsApplication.class, args);

	}

}