package com.userModule.registrationService.Payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * Author : Rohit Parihar
 * Date : 11/25/2022
 * Time : 4:28 PM
 * Class : registerResponse
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class registerResponse {
    private String userId;
    private String message;
    private Boolean isRegistered;
    private Boolean isUpdated;
    private Boolean isDeleted;
}
