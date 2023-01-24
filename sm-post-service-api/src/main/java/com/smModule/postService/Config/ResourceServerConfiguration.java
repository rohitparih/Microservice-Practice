package com.smModule.postService.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.session.ConcurrentSessionFilter;

import javax.servlet.http.HttpServletResponse;

/**
 * Author : Rohit Parihar
 * Date : 12/27/2022
 * Time : 2:27 AM
 * Class : ResourceServerConfiguration
 * Project : Bloggios-Backend
 */

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    public TokenStore tokenStore;

    @Autowired
    private MyAccessDeniedHandler accessDeniedHandler;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/sm-post/auth/**")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .cors()
                .disable()
                .csrf()
                .disable()
                .httpBasic()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .accessDeniedHandler(accessDeniedHandler);
        http.addFilterBefore(new ApiGatewayFilter(), ConcurrentSessionFilter.class);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("USER_ADMIN_RESOURCE").tokenStore(tokenStore);
    }
}
