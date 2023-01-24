package com.smModule.postService.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Author : Rohit Parihar
 * Date : 11/18/2022
 * Time : 4:54 PM
 * Class : webClientConfig
 * Project : Bloggios-Backend
 */

@Configuration
public class webClientConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClient(){
        return WebClient.builder();
    }
}
