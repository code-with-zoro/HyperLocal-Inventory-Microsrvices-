package com.HyperLocal_Inventory.Loaction_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoactionServiceApplication.class, args);
	}

}
