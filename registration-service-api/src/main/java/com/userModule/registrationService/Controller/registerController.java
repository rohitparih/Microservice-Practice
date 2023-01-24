package com.userModule.registrationService.Controller;

import RegistrationServiceApiConstants.RegisterConstants;
import RegistrationServiceApiConstants.RegisterUri;
import com.userModule.registrationService.Entity.CustomPrincipal;
import com.userModule.registrationService.Entity.User;
import com.userModule.registrationService.Events.registrationDoneEvent;
import com.userModule.registrationService.Payloads.registerRequest;
import com.userModule.registrationService.Service.registerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Author : Rohit Parihar
 * Date : 11/18/2022
 * Time : 1:03 AM
 * Class : registerController
 * Project : register-module
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(RegisterUri.REGISTER_CONTROLLER_ENTRY_POINT)
@Slf4j
public class registerController {

    private final registerService registerService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public String registerUser(@Valid @RequestBody registerRequest registerRequest, HttpServletRequest request){
        User user = this.registerService.registerUser(registerRequest);
        applicationEventPublisher.publishEvent(new registrationDoneEvent(user, gettingUrl(request)));
        return RegisterConstants.COMPLETE_REGISTRATION_MESSAGE;
    }

    @GetMapping(RegisterUri.VALIDATE_USER)
    public String validateUser(@RequestParam("token") String token){
        String s = registerService.validateRegistrationToken(token);
        if (s.equalsIgnoreCase("success")){
            return RegisterConstants.REGISTER_SUCCESS_MESSAGE;
        }
        return RegisterConstants.NOT_VALIDATED;
    }

    private String gettingUrl(HttpServletRequest request){
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

    @GetMapping(RegisterUri.CHECK_BY_USER_ID)
    public Boolean checkByUserId(@PathVariable String userId){
        return this.registerService.checkByUserId(userId);
    }

    @GetMapping(RegisterUri.GET_NAME)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('role_admin')")
    public String getName(@PathVariable String userId, CustomPrincipal customPrincipal){
        log.error(customPrincipal.getUsername());
        return registerService.getName(customPrincipal.getUserId());
    }
}
