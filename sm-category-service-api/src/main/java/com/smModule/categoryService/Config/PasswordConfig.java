package com.smModule.categoryService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Author : Rohit Parihar
 * Date : 12/27/2022
 * Time : 2:37 AM
 * Class : PasswordConfig
 * Project : Bloggios-Backend
 */

@Configuration
public class PasswordConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
