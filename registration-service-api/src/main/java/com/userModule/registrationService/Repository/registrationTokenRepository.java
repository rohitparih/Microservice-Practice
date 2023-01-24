package com.userModule.registrationService.Repository;

import com.userModule.registrationService.Entity.RegistrationToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 1:11 AM
 * Class : registrationTokenRepository
 * Project : Bloggios-Backend
 */
public interface registrationTokenRepository extends JpaRepository<RegistrationToken, String> {
    RegistrationToken findByToken(String token);
}
