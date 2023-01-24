package com.userModule.registrationService.Payloads;

import com.userModule.registrationService.Entity.Role;
import lombok.*;

import java.util.List;

/**
 * Author : Rohit Parihar
 * Date : 1/1/2023
 * Time : 12:52 AM
 * Class : rolesResponse
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class assignResponse {
    private String userId;
    private List<Role> roles;
    private String assignedBy;
}
