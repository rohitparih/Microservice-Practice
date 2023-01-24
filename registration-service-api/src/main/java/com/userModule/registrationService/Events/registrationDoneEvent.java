package com.userModule.registrationService.Events;

import com.userModule.registrationService.Entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 12:09 AM
 * Class : registrationDoneEvent
 * Project : Bloggios-Backend
 */

@Getter
@Setter
public class registrationDoneEvent extends ApplicationEvent {
    private User user;
    private String url;

    public registrationDoneEvent(User user, String url){
        super(user);
        this.user = user;
        this.url = url;
    }
}
