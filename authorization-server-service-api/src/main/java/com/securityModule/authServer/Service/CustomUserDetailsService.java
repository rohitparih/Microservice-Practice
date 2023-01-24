package com.securityModule.authServer.Service;

import Exceptions.AuthorizationException;
import com.securityModule.authServer.Entity.User;
import com.securityModule.authServer.Repository.registerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Author : Rohit Parihar
 * Date : 12/26/2022
 * Time : 12:46 AM
 * Class : CustomUserDetailsService
 * Project : Bloggios-Backend
 */

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private registerRepository registerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.registerRepository.findByUsernameIgnoreCase(username).orElseThrow(() -> new AuthorizationException(HttpStatus.BAD_REQUEST, "Username not found with given entry", "BAD_CREDENTIALS"));
        log.warn(user.getPassword());
        new AccountStatusUserDetailsChecker().check(user);
        return user;
    }
}
