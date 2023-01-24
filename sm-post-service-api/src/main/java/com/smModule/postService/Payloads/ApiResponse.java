package com.smModule.postService.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Rohit Parihar
 * Date : 11/28/2022
 * Time : 12:54 AM
 * Class : ApiResponse
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    String message;
    Boolean success;
}
