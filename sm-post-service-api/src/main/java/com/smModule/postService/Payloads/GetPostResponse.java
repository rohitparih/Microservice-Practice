package com.smModule.postService.Payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Author : Rohit Parihar
 * Date : 12/6/2022
 * Time : 9:41 PM
 * Class : GetPostResponse
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetPostResponse {
    private String caption;
    private List<String> tags;
    private String createdBy;
    private String categoryId;
    private Date dateCreated;
}
