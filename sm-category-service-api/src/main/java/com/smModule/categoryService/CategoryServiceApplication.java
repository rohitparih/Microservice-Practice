package com.smModule.categoryService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author : Rohit Parihar
 * Date : 11/21/2022
 * Time : 12:21 AM
 * Class : CategoryServiceApplication
 * Project : Bloggios-Backend
 */

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class CategoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategoryServiceApplication.class, args);
    }
}
