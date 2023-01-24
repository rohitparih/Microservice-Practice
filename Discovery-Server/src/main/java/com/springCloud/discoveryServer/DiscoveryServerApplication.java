package com.springCloud.discoveryServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Author : Rohit Parihar
 * Date : 11/19/2022
 * Time : 1:25 AM
 * Class : DiscoveryServerApplication
 * Project : Bloggios-Backend
 */

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
