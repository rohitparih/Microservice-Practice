package com.userModule.registrationService.Implementation;

import RegistrationServiceApiConstants.RegisterConstants;
import Exceptions.ApiException;
import com.userModule.registrationService.Entity.RegistrationToken;
import com.userModule.registrationService.Entity.Role;
import com.userModule.registrationService.Entity.User;
import com.userModule.registrationService.Logic.logicProcessor;
import com.userModule.registrationService.Payloads.registerRequest;
import com.userModule.registrationService.Repository.registerRepository;
import com.userModule.registrationService.Repository.registrationTokenRepository;
import com.userModule.registrationService.Repository.roleRepository;
import com.userModule.registrationService.Service.registerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Author : Rohit Parihar
 * Date : 11/18/2022
 * Time : 12:53 AM
 * Class : registerImplementation
 * Project : register-module
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class registerImplementation implements registerService {

    private final registerRepository registerRepository;
    private final logicProcessor logicProcessor;
    private final registrationTokenRepository registrationTokenRepository;
    private final roleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(registerRequest registerRequest) {
        if (Boolean.TRUE.equals(registerRepository.existsByEmail(registerRequest.getEmail()))){
            throw new ApiException(HttpStatus.BAD_REQUEST, RegisterConstants.EMAIL_TAKEN_MESSAGE);
        }
        if (Boolean.TRUE.equals(registerRepository.existsByUsername(registerRequest.getUsername()))){
            throw new ApiException(HttpStatus.BAD_REQUEST, RegisterConstants.USERNAME_TAKEN_MESSAGE);
        }
        String name = logicProcessor.capitalizeLetter(registerRequest.getName());
        Role role = roleRepository.findById("2b628dbc-4c3f-4978-adec-f33969f4f51b").get();
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        User userSave = User
                .builder()
                .name(name)
                .email(registerRequest.getEmail().trim().toLowerCase())
                .username(registerRequest.getUsername().trim().toLowerCase())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .roles(roles)
                .dateRegistered(LocalDate.now())
                .timeRegistered(LocalTime.now())
                .isEnabled(Boolean.FALSE)
                .build();
        User registeredUser = registerRepository.save(userSave);
        return registeredUser;
    }

    @Override
    public void saveRegistrationToken(User user, String token) {
        RegistrationToken registrationToken = new RegistrationToken(user, token);
        registrationTokenRepository.save(registrationToken);
    }

    @Override
    public String validateRegistrationToken(String token) {
        RegistrationToken registrationToken = registrationTokenRepository.findByToken(token);
        if (registrationToken==null){
            return RegisterConstants.NULL_REGISTRATION_COMPLETE_TOKEN;
        }
        User user = registrationToken.getUser();
        Calendar instance = Calendar.getInstance();
        if (registrationToken.getExpirationTime().getTime()-instance.getTime().getTime()<=0){
            registrationTokenRepository.delete(registrationToken);
            return "Token Expired";
        }
        user.setIsEnabled(true);
        user.setIsAccountNonLocked(true);
        registerRepository.save(user);
        return "Success";
    }

    @Override
    public Boolean checkByUserId(String userId) {
        return registerRepository.existsByUserId(userId);
    }

    @Override
    public String getName(String userId) {
        User user = this.registerRepository.findById(userId).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, RegisterConstants.USER_NOT_FOUND_EXCEPTION));
        return user.getName();
    }
}
