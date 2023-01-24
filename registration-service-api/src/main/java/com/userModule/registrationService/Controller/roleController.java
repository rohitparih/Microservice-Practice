package com.userModule.registrationService.Controller;

import com.userModule.registrationService.Entity.CustomPrincipal;
import com.userModule.registrationService.Entity.Role;
import com.userModule.registrationService.Payloads.roleResponse;
import com.userModule.registrationService.Service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Author : Rohit Parihar
 * Date : 1/1/2023
 * Time : 2:03 AM
 * Class : roleController
 * Project : Bloggios-Backend
 */

@RestController
@RequestMapping("/api/registration/auth/role")
public class roleController {

    @Autowired
    private roleService roleService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('role_admin') or hasAuthority('role_developer')")
    public roleResponse createRole(@RequestBody Role role, CustomPrincipal customPrincipal){
        roleResponse createdRole = this.roleService.createRole(customPrincipal.getUserId(), role);
        return createdRole;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('role_admin') or hasAuthority('role_developer')")
    public roleResponse allRoles(){
        roleResponse allRoles = this.roleService.getAllRoles();
        return allRoles;
    }
}
