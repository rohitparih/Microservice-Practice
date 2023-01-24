package com.smModule.tagService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author : Rohit Parihar
 * Date : 12/1/2022
 * Time : 5:54 PM
 * Class : TagServiceApplication
 * Project : Bloggios-Backend
 */

@SpringBootApplication
@EnableEurekaClient
public class TagServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TagServiceApplication.class, args);
    }
}
