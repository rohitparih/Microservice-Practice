package com.smModule.categoryService.Payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author : Rohit Parihar
 * Date : 11/22/2022
 * Time : 11:23 PM
 * Class : categoryResponse
 * Project : Bloggios-Backend
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class categoryResponse {
    private String categoryId;
    private String createdBy;
    private String updatedBy;
    private String title;
    private String description;
    private Boolean isAdded;
    private Boolean isDeleted;
    private Boolean isUpdated;
}
