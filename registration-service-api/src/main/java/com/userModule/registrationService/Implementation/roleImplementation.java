package com.userModule.registrationService.Implementation;

import com.userModule.registrationService.Entity.Role;
import com.userModule.registrationService.Payloads.roleResponse;
import com.userModule.registrationService.Repository.roleRepository;
import com.userModule.registrationService.Service.roleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Author : Rohit Parihar
 * Date : 1/1/2023
 * Time : 1:27 AM
 * Class : roleImplementation
 * Project : Bloggios-Backend
 */

@Service
@RequiredArgsConstructor
public class roleImplementation implements roleService {

    private final roleRepository roleRepository;

    /**
     *
     * @createdBy Rohit Parihar
     * @param userId
     * @param role
     * @return roleResponse
     */
    @Override
    public roleResponse createRole(String userId, Role role) {
        role.setUserId(userId);
        role.setCreatedAt(new Date());
        role.setIsActive(true);
        roleRepository.save(role);
        return roleResponse.builder().message("Role Added").isDone(true).build();
    }

    /**
     *
     * @createdBy Rohit Parihar
     * @return roleResponse
     */
    @Override
    public roleResponse getAllRoles() {
        List<Role> allRoles = this.roleRepository.findAll();
        Map<String, Boolean> roleNames = new HashMap<>();
        allRoles.forEach(e-> {
            String roleName = e.getRoleName();
            Boolean isActive = e.getIsActive();
            roleNames.put(roleName, isActive);
        });
        return roleResponse
                .builder()
                .role(roleNames)
                .build();
    }
}
