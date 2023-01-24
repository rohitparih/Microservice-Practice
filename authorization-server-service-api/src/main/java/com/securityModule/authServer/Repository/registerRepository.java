package com.securityModule.authServer.Repository;

import com.securityModule.authServer.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
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
    Optional<User> findByUsernameIgnoreCase(String emailOrUsername);
}
