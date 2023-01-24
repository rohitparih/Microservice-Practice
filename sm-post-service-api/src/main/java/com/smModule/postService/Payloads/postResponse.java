package com.smModule.postService.Payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 6:11 PM
 * Class : postResponse
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class postResponse {
    private String id;
    private String message;
    private Boolean isCreated;
    private Boolean idEdited;
    private Boolean isDeleted;
}
