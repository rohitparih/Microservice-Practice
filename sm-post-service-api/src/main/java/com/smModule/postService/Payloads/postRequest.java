package com.smModule.postService.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * Author : Rohit Parihar
 * Date : 11/27/2022
 * Time : 6:11 PM
 * Class : postRequest
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
public class postRequest {
    private String caption;
    private String categoryId;
    private List<String> tags;
}
