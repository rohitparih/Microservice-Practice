package com.userModule.registrationService.Listners;

import com.userModule.registrationService.Entity.User;
import com.userModule.registrationService.Events.registrationDoneEvent;
import com.userModule.registrationService.Service.registerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 1:14 AM
 * Class : registrationDoneListner
 * Project : Bloggios-Backend
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class registrationDoneListner implements ApplicationListener<registrationDoneEvent> {

    private final registerService registerService;

    @Override
    public void onApplicationEvent(registrationDoneEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        registerService.saveRegistrationToken(user, token);
        String verifyUrl = event.getUrl() + "/api/registration/verifyUserRegistration?token=" + token;
        log.info("Complete Registration using this URL : {}", verifyUrl);
    }
}
