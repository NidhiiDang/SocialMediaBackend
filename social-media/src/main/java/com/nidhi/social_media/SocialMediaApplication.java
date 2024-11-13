package com.nidhi.social_media;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialMediaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SocialMediaApplication.class, args);
		System.out.println();
		System.out.println("Application Started successfully...Go Ahead and test your endpoints in postman!");
	}

}
