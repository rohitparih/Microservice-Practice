package com.userModule.registrationService.Repository;

import com.userModule.registrationService.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author : Rohit Parihar
 * Date : 12/27/2022
 * Time : 12:35 AM
 * Class : roleRepository
 * Project : Bloggios-Backend
 */

public interface roleRepository extends JpaRepository<Role, String> {
    Boolean existsByRoleId(String roleId);
}
