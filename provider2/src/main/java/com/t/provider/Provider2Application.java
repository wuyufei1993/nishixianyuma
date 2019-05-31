package com.t.provider;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.t.**.mapper")
@EnableTransactionManagement
public class Provider2Application {

	public static void main(String[] args) {
		SpringApplication.run(Provider2Application.class, args);
	}

}
