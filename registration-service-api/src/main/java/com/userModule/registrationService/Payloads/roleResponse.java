package com.userModule.registrationService.Payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * Author : Rohit Parihar
 * Date : 1/1/2023
 * Time : 1:23 AM
 * Class : roleResponse
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class roleResponse {
    private String message;
    private Boolean isDone;
    private Map<String, Boolean> role;
}
