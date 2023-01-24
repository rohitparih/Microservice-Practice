package com.gateway.apiGateway.Configurations;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Author : Rohit Parihar
 * Date : 12/29/2022
 * Time : 1:36 AM
 * Class : GatewayConfigurations
 * Project : Bloggios-Backend
 */

@Configuration
public class GatewayConfigurations implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest build = exchange.getRequest().mutate().header("testing", "hello").build();
        return chain.filter(exchange.mutate().request(build).build());
    }
}
