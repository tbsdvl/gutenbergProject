package com.company.GutenbergCloudConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class GutenbergCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(GutenbergCloudConfigApplication.class, args);
	}

}
