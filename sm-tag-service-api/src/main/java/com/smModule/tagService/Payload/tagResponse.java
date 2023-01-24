package com.smModule.tagService.Payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

/**
 * Author : Rohit Parihar
 * Date : 12/1/2022
 * Time : 11:05 PM
 * Class : tagResponse
 * Project : Bloggios-Backend
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class tagResponse {
    private String id;
    private String tag;
    private Boolean isNew;
    private List<String> tags;
}
