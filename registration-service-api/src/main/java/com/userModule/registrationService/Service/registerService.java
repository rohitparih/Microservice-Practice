package com.userModule.registrationService.Service;

import Payloads.ApiResponse;
import com.userModule.registrationService.Entity.User;
import com.userModule.registrationService.Payloads.registerRequest;
import com.userModule.registrationService.Payloads.registerResponse;

/**
 * Author : Rohit Parihar
 * Date : 11/18/2022
 * Time : 12:51 AM
 * Class : registerService
 * Project : register-module
 */

public interface registerService {
    User registerUser(registerRequest registerRequest);
    void saveRegistrationToken(User user, String token);
    String validateRegistrationToken(String token);
    Boolean checkByUserId(String userId);
    String getName(String userId);

}
