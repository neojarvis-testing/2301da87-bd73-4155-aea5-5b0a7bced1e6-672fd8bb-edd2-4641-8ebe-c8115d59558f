package com.examly.springappwifi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringappwifiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappwifiApplication.class, args);
	}

}
