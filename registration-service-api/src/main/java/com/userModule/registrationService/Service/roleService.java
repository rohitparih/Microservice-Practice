package com.userModule.registrationService.Service;

import com.userModule.registrationService.Entity.Role;
import com.userModule.registrationService.Payloads.roleResponse;

/**
 * Author : Rohit Parihar
 * Date : 1/1/2023
 * Time : 1:21 AM
 * Class : roleService
 * Project : Bloggios-Backend
 */

public interface roleService {
    roleResponse createRole(String userId, Role role);
    roleResponse getAllRoles();
}
