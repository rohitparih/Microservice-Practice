package com.userModule.registrationService.Entity;

import RegistrationServiceApiConstants.RegisterConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 12:35 AM
 * Class : RegistrationToken
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RegistrationToken {

    @Id
    @GeneratedValue(generator = "randomUUID")
    @GenericGenerator(name = "randomUUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String registrationTokenId;
    private String token;
    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "REGISTRATION_TOKEN"))
    private User user;

    public RegistrationToken(User user, String token){
        super();
        this.token=token;
        this.user=user;
        this.expirationTime = calculateTime();
    }

    private Date calculateTime() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(new Date().getTime());
        instance.add(Calendar.MINUTE, RegisterConstants.TOKEN_EXPIRATION_TIME_IN_MINUTES);
        return new Date(instance.getTime().getTime());
    }
}
