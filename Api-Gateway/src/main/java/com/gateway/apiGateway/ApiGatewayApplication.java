package com.gateway.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author : Rohit Parihar
 * Date : 11/19/2022
 * Time : 5:23 PM
 * Class : ApiGatewayApplication
 * Project : Bloggios-Backend
 */

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
