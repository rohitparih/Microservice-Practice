package com.userModule.registrationService.Implementation;

import Exceptions.ApiException;
import Payloads.ApiResponse;
import RegistrationServiceApiConstants.RegisterConstants;
import com.userModule.registrationService.Entity.Role;
import com.userModule.registrationService.Entity.User;
import com.userModule.registrationService.Payloads.assignResponse;
import com.userModule.registrationService.Payloads.registerResponse;
import com.userModule.registrationService.Repository.registerRepository;
import com.userModule.registrationService.Repository.roleRepository;
import com.userModule.registrationService.Service.handleRegisteredUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author : Rohit Parihar
 * Date : 1/1/2023
 * Time : 12:30 AM
 * Class : handleRegisteredUserImplementation
 * Project : Bloggios-Backend
 */

@Service
@RequiredArgsConstructor
public class handleRegisteredUserImplementation implements handleRegisteredUserService {

    private final registerRepository registerRepository;
    private final roleRepository roleRepository;

    /**
     *
     * @createdBy Rohit Parihar
     * @param userId
     * @return ApiResponse
     */
    @Override
    public ApiResponse lockAccount(String userId) {
        User user = this.registerRepository.findById(userId).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, RegisterConstants.USER_NOT_FOUND_EXCEPTION));
        if (user.getIsEnabled() && user.getIsAccountNonLocked()){
            user.setIsAccountNonLocked(false);
            user.setTimeLocked(new Date());
            User lockedUser = this.registerRepository.save(user);
            return new ApiResponse("User Locked", true);
        }
        else {
            if (user.getIsEnabled()){
                if (!user.getIsAccountNonLocked()){
                    throw new ApiException(HttpStatus.BAD_REQUEST, "User is already locked");
                }
            }
            throw new ApiException(HttpStatus.BAD_REQUEST, "User is not Enabled");
        }
    }

    /**
     *
     * @createdBy Rohit Parihar
     * @param userId
     * @return registerResponse
     */
    @Override
    public registerResponse deleteTemporary(String userId) {
        User user = this.registerRepository.findById(userId).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, RegisterConstants.USER_NOT_FOUND_EXCEPTION));
        if (user.isEnabled() && user.isAccountNonLocked()){
            user.setIsEnabled(false);
            user.setIsAccountNonLocked(false);
            user.setTimeDisabled(new Date());
            user.setTimeLocked(new Date());
            User deletedUser = this.registerRepository.save(user);
            return registerResponse
                    .builder()
                    .userId(deletedUser.getUserId())
                    .isDeleted(true)
                    .message("Unregistered Successfully")
                    .build();
        }
        else {
            if (user.getIsEnabled()){
                if (!user.getIsAccountNonLocked()){
                    throw new ApiException(HttpStatus.BAD_REQUEST, "User is already locked");
                }
            }
            throw new ApiException(HttpStatus.BAD_REQUEST, "User is not Enabled");
        }
    }

    /**
     *
     * @createdBy Rohit Parihar
     * @param userId
     * @return registerResponse
     */
    @Override
    public registerResponse deletePermanent(String userId) {
        User user = registerRepository.findById(userId).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, RegisterConstants.USER_NOT_FOUND_EXCEPTION));
        this.registerRepository.delete(user);
        return registerResponse
                .builder()
                .userId(user.getUserId())
                .message("User deleted successfully from database")
                .isDeleted(true)
                .build();
    }

    @Override
    public assignResponse assignRole(List<String> roleId, String userId, String currentUser) {
        User user = this.registerRepository.findById(userId).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, RegisterConstants.USER_NOT_FOUND_EXCEPTION));
        Map<Boolean, List<String>> splittedRoles = roleId.stream().collect(Collectors.partitioningBy(roleRepository::existsByRoleId));
        if (splittedRoles.get(false).isEmpty()){
            List<Role> roles = splittedRoles.get(true).stream().map(e -> roleRepository.findById(e).get()).collect(Collectors.toList());
            user.setRoles(roles);
            User updatedUser = registerRepository.save(user);
            return assignResponse
                    .builder()
                    .userId(updatedUser.getUserId())
                    .roles(updatedUser.getRoles())
                    .assignedBy(currentUser)
                    .build();
        }
        throw new ApiException(HttpStatus.BAD_REQUEST, RegisterConstants.ROLES_NOT_PRESENT_TO_ADD);
    }
}
