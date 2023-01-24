package com.smModule.commentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author : Rohit Parihar
 * Date : 1/11/2023
 * Time : 3:00 PM
 * Class : CommentServiceApplication
 * Project : Bloggios-Backend
 */

@SpringBootApplication
@EnableEurekaClient
public class CommentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentServiceApplication.class, args);
    }
}
