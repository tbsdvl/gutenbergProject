package com.company.GutenbergAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GutenbergApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GutenbergApiApplication.class, args);
	}

}
