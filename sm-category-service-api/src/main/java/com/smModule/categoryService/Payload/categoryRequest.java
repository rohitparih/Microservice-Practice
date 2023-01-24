package com.smModule.categoryService.Payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author : Rohit Parihar
 * Date : 11/22/2022
 * Time : 11:22 PM
 * Class : categoryRequest
 * Project : Bloggios-Backend
 */

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class categoryRequest {
    private String title;
    private String description;
}
