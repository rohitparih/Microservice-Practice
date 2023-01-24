package com.userModule.registrationService.Repository;

import com.userModule.registrationService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * Author : Rohit Parihar
 * Date : 11/18/2022
 * Time : 12:50 AM
 * Class : registerRepository
 * Project : register-module
 */

@Repository
public interface registerRepository extends JpaRepository<User, String> {
    Boolean existsByEmail(@NotBlank String email);
    Boolean existsByUsername(@NotBlank String username);
    Boolean existsByUserId(@NotBlank String userId);
    Optional<User> findByUsernameIgnoreCase(String emailOrUsername);
    User findByEmailIgnoreCase(String email);
}
