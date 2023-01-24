package com.userModule.registrationService;

import com.userModule.registrationService.Entity.Role;
import com.userModule.registrationService.Repository.roleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RequiredArgsConstructor
@Slf4j
public class registrationModuleApplication implements CommandLineRunner {

    @Autowired
    private roleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(registrationModuleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Role role_admin = Role.builder().roleName("role_admin").userId("12345").createdAt(new Date()).isActive(true).build();
//        log.warn("Adding Role");
//        this.roleRepository.save(role_admin);
    }
}
