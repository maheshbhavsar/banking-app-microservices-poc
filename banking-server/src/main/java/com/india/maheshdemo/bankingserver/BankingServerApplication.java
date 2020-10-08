package com.india.maheshdemo.bankingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.india.maheshdemo.bankingserver.*"})
public class BankingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingServerApplication.class, args);
	}

}
