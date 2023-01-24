package com.userModule.registrationService.Entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author : Rohit Parihar
 * Date : 11/17/2022
 * Time : 11:24 PM
 * Class : Register
 * Project : register-module
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "randomUUID")
    @GenericGenerator(name = "randomUUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String userId;
    private String name;
    private String email;
    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "roleId"))
    private List<Role> roles = new ArrayList<>();
    private LocalDate dateRegistered;
    private LocalTime timeRegistered;
    private Date timeLocked;
    private Date timeDisabled;
    private Date lastUpdated;

    private Boolean isEnabled;
    private Boolean isAccountNonLocked;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> collect = this.roles.stream().map(e -> new SimpleGrantedAuthority(e.getRoleName())).collect(Collectors.toList());
        return collect;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
