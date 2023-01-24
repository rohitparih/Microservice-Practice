package com.smModule.postService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 2:55 PM
 * Class : PostServiceApplication
 * Project : Bloggios-Backend
 */

@SpringBootApplication
@EnableEurekaClient
public class PostServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostServiceApplication.class, args);
    }

}
