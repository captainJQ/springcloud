package com.jql.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProviderOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOneApplication.class,args);
    }
}
