package com.userModule.registrationService.Controller;

import com.userModule.registrationService.Entity.CustomPrincipal;
import com.userModule.registrationService.Payloads.assignResponse;
import com.userModule.registrationService.Service.handleRegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author : Rohit Parihar
 * Date : 1/1/2023
 * Time : 1:53 AM
 * Class : handleRegisteredUserController
 * Project : Bloggios-Backend
 */

@RestController
@RequestMapping("/api/registration/auth/handleUser")
public class handleRegisteredUserController {

    @Autowired
    private handleRegisteredUserService handleRegisteredUserService;

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('role_admin') or hasAuthority('role_developer')")
    public assignResponse assignRole(@RequestBody List<String> roleId, @PathVariable String userId, CustomPrincipal customPrincipal){
        assignResponse assignResponse = this.handleRegisteredUserService.assignRole(roleId, userId, customPrincipal.getUserId());
        return assignResponse;
    }
}
