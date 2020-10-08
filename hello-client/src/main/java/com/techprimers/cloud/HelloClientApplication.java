package com.techprimers.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.india.cloud.demo.feignClients"})
public class HelloClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloClientApplication.class, args);
	}
	
}
