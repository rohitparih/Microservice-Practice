package com.securityModule.authServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author : Rohit Parihar
 * Date : 12/26/2022
 * Time : 9:53 PM
 * Class : AuthorizationServerApplication
 * Project : Bloggios-Backend
 */

@SpringBootApplication
@EnableEurekaClient
public class AuthorizationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }
}
