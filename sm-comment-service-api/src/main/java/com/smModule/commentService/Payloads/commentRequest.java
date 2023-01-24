package com.smModule.commentService.Payloads;

import lombok.*;

/**
 * Author : Rohit Parihar
 * Date : 1/11/2023
 * Time : 3:16 PM
 * Class : commentRequest
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class commentRequest {
    private String comment;
}
