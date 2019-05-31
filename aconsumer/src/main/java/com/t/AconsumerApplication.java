package com.t;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
@EnableTransactionManagement
public class AconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AconsumerApplication.class, args);
	}

}
