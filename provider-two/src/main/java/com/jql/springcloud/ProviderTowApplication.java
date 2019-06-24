package com.jql.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderTowApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderTowApplication.class,args);
    }
}
